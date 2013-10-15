package com.martinetherton.routing.domain;

import java.util.List;

import javax.faces.model.DataModel;


public interface RoutingService {

    public void triggerRouteAdviceCreationFor(RouteAdviceRequest routeAdviceRequest);

    public void requestRouteAdviceFor(int routeAdviceRequestId);

    public RouteAdvice routeAdviceFor(RouteAdviceRequest routeAdviceRequest);
    
    public List<RouteAdviceRequest> findAllRouteAdviceRequests();

}
