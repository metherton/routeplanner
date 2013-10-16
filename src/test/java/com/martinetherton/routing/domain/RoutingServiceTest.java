package com.martinetherton.routing.domain;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;

import com.bmtargoss.semafors.optimizer.domain.OptimalRouteAdvice;
import com.bmtargoss.semafors.optimizer.domain.OptimalRouteAdviceRequest;
import com.bmtargoss.semafors.optimizer.domain.OptimizerService;
import com.martinetherton.routing.persistence.RouteAdviceDao;
import com.martinetherton.routing.persistence.RouteAdviceRequestDao;

public class RoutingServiceTest {

    @Test
    public void saveRouteAdviceRequestInvokedOnRoutingPersistenceDAO() {
        
        RouteAdviceRequest routeAdviceRequest = new RouteAdviceRequest();
        routeAdviceRequest.setId(42L);
        
        RouteAdviceRequestDao routeAdviceRequestDao = EasyMock.createMock(RouteAdviceRequestDao.class);
        JmsTemplate jmsTemplate = EasyMock.createMock(JmsTemplate.class);

        RoutingService routingService = new RoutingServiceImpl(routeAdviceRequestDao, jmsTemplate, null, null);

        routeAdviceRequestDao.storeRouteAdviceRequest(routeAdviceRequest);
        
        replay(routeAdviceRequestDao);
        routingService.triggerRouteAdviceCreationFor(routeAdviceRequest);
        verify(routeAdviceRequestDao);
    }
    
    @Test
    public void optimizerInvokedWithCorrectRouteRequestInformation() {
        
        RouteAdviceRequest routeAdviceRequest = new RouteAdviceRequest();
        routeAdviceRequest.setId(42L);
        routeAdviceRequest.setStartLongitude("23");
        routeAdviceRequest.setStartLatitude("44");
        routeAdviceRequest.setDestinationLongitude("22");
        routeAdviceRequest.setDestinationLatitude("45");
        
        RouteAdvice routeAdvice = new RouteAdvice();
        routeAdvice.setStart("23_44");
        routeAdvice.setDestination("22_45");
        
        RouteAdviceRequestDao routeAdviceRequestDao = createMock(RouteAdviceRequestDao.class);
        RouteAdviceDao routeAdviceDao = createMock(RouteAdviceDao.class);

        JmsTemplate jmsTemplate = createMock(JmsTemplate.class);
        OptimizerService optimizerService = createMock(OptimizerService.class);

        RoutingService routingService = new RoutingServiceImpl(routeAdviceRequestDao, jmsTemplate, optimizerService, routeAdviceDao);

        expect(routeAdviceRequestDao.findRouteAdviceRequestWithId(42L)).andReturn(routeAdviceRequest);
        OptimalRouteAdviceRequest optimalRouteAdviceRequest = new OptimalRouteAdviceRequest("23_44", "22_45");
        OptimalRouteAdvice optimalRouteAdvice = new OptimalRouteAdvice(new ArrayList<String>(), 0, 0, 0, 0);
        
        expect(optimizerService.findRouteAdviceFor(optimalRouteAdviceRequest)).andReturn(optimalRouteAdvice);
        routeAdviceDao.storeRouteAdvice(routeAdvice);        
        
        
        replay(routeAdviceRequestDao, optimizerService, routeAdviceDao);
        routingService.requestRouteAdviceFor(42L);
        verify(routeAdviceRequestDao, optimizerService, routeAdviceDao);
    }
    
}
