package com.martinetherton.routing.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.martinetherton.routing.domain.RouteAdviceRequest;
import com.martinetherton.routing.domain.RoutingService;

@Component
public class RoutingFlowActions {

    private RoutingService routingService;

    @Autowired
    public RoutingFlowActions(RoutingService routingService) {
        this.routingService = routingService;
    }
    
    public Long requestRouteAdvice(RouteAdviceRequest routeAdviceRequest) {
        routingService.triggerRouteAdviceCreationFor(routeAdviceRequest);
        return routeAdviceRequest.getId();
    }
    
    public RouteAdviceRequest showRouteAdvice(RouteAdviceRequest routeAdviceRequest) {
        System.out.println("requested route advice for " + routeAdviceRequest.getId());
       // routingService.initiateRequest(routeAdviceRequest);
  //      return routingService.routeAdviceFor(routeAdviceRequest);
        return routeAdviceRequest;
    }    
}
