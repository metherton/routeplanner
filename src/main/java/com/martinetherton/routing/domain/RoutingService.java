package com.martinetherton.routing.domain;

public interface RoutingService {

    public void triggerRouteAdviceCreationFor(RouteAdviceRequest routeAdviceRequest);

    public void requestRouteAdviceFor(int routeAdviceRequestId);

    public RouteAdvice routeAdviceFor(RouteAdviceRequest routeAdviceRequest);

}
