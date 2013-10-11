package com.martinetherton.routing.persistence;

import com.martinetherton.routing.domain.RouteAdviceRequest;

public interface RouteAdviceRequestDao {

    public void storeRouteAdviceRequest(RouteAdviceRequest routeAdviceRequest);

    public RouteAdviceRequest findRouteAdviceRequestWithId(int id);

}
