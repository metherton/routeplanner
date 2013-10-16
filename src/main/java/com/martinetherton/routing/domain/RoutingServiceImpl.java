package com.martinetherton.routing.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.DataModel;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.bmtargoss.semafors.optimizer.domain.OptimalRouteAdvice;
import com.bmtargoss.semafors.optimizer.domain.OptimalRouteAdviceRequest;
import com.bmtargoss.semafors.optimizer.domain.OptimizerService;
import com.martinetherton.routing.persistence.RouteAdviceDao;
import com.martinetherton.routing.persistence.RouteAdviceRequestDao;

@Service("routingService")
public class RoutingServiceImpl implements RoutingService, Serializable {

    private RouteAdviceRequestDao routeAdviceRequestDao;
    private RouteAdviceDao routeAdviceDao;
    private JmsTemplate jmsTemplate;
    private OptimizerService optimizerService;

    @Autowired
    public RoutingServiceImpl(RouteAdviceRequestDao routeAdviceRequestDao, JmsTemplate jmsTemplate, OptimizerService optimizerService, RouteAdviceDao routeAdviceDao) {
        this.routeAdviceRequestDao = routeAdviceRequestDao;
        this.jmsTemplate = jmsTemplate;
        this.optimizerService = optimizerService;
        this.routeAdviceDao = routeAdviceDao;
    }

    public void triggerRouteAdviceCreationFor(final RouteAdviceRequest routeAdviceRequest) {
        routeAdviceRequestDao.storeRouteAdviceRequest(routeAdviceRequest);

        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(String.valueOf(routeAdviceRequest.getRouteRequestId()));
            }
        }
        );        
    }

    public void requestRouteAdviceFor(int routeAdviceRequestId) {
        routeAdviceDao.storeRouteAdvice(optimalRouteAdviceFor(getStoredRouteAdviceRequestFor(routeAdviceRequestId)));
    }

    private RouteAdviceRequest getStoredRouteAdviceRequestFor(int routeAdviceRequestId) {
        return routeAdviceRequestDao.findRouteAdviceRequestWithId(routeAdviceRequestId);
    }

    private RouteAdvice optimalRouteAdviceFor(
            RouteAdviceRequest routeAdviceRequest) {
        OptimalRouteAdvice optimalRouteAdvice = optimalRouteAdviceFrom(routeAdviceRequest);
        RouteAdvice routeAdvice = new RouteAdvice.Builder().routeAdviceRequest(routeAdviceRequest)
                .start(locationFrom(routeAdviceRequest.getStartLatitude(), routeAdviceRequest.getStartLongitude()))
                .destination(locationFrom(routeAdviceRequest.getDestinationLatitude(), routeAdviceRequest.getDestinationLongitude())).build();
        List<RouteAdviceLeg> raLegs = getRouteAdviceLegsFrom(optimalRouteAdvice, routeAdvice);
        routeAdvice.setRouteAdviceLegs(raLegs);
        return routeAdvice;
    }

    private List<RouteAdviceLeg> getRouteAdviceLegsFrom(
            OptimalRouteAdvice optimalRouteAdvice, RouteAdvice routeAdvice) {
        List<RouteAdviceLeg> routeAdviceLegs = new ArrayList<RouteAdviceLeg>();
        int sortOrder = 1;
        for (String waypoint : optimalRouteAdvice.waypoints()) {
            RouteAdviceLeg leg = new RouteAdviceLeg();
            leg.setRouteAdvice(routeAdvice);
            leg.setLocation(waypoint);
            leg.setSortOrder(sortOrder);
            sortOrder++;
            routeAdviceLegs.add(leg);
        }
        return routeAdviceLegs;

    }

    private OptimalRouteAdvice optimalRouteAdviceFrom(
            RouteAdviceRequest routeAdviceRequest) {

        OptimalRouteAdviceRequest optimalRouteAdviceRequest = new OptimalRouteAdviceRequest(locationFrom(routeAdviceRequest.getStartLatitude(), routeAdviceRequest.getStartLongitude()), locationFrom(routeAdviceRequest.getDestinationLatitude(), routeAdviceRequest.getDestinationLongitude()));
        OptimalRouteAdvice optimalRouteAdvice = optimizerService.findRouteAdviceFor(optimalRouteAdviceRequest);
        return optimalRouteAdvice;
    }

    private String locationFrom(String latitude, String longitude) {
        return longitude + "_" + latitude;
    }

    @Override
    public RouteAdvice routeAdviceFor(RouteAdviceRequest routeAdviceRequest) {
        RouteAdvice routeAdvice = routeAdviceDao.findRouteAdviceFor(routeAdviceRequest);
        return routeAdvice;
    }

	@Override
	public List<RouteAdviceRequest> findAllRouteAdviceRequests() {
	    List<RouteAdviceRequest> results = routeAdviceRequestDao.findAllRouteAdviceRequests();
	    System.out.println(results.size());
		return results;
	}


}
