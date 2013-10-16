package com.martinetherton.routing.domain;

import static java.lang.Integer.parseInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteAdviceRequestHandlerImpl implements RouteAdviceRequestHandler {

    private RoutingService routingService;

    @Autowired
    public RouteAdviceRequestHandlerImpl(RoutingService routingService) {
        this.routingService = routingService;
    }

    public void processRouteAdviceRequest(String routeRequestAdviceId) {
        routingService.requestRouteAdviceFor(Long.parseLong(routeRequestAdviceId));
    }

}
