package com.martinetherton.routing.persistence;

import java.util.List;

import com.martinetherton.routing.domain.RouteAdviceRequest;

public interface RouteAdviceRequestDao {

    public void storeRouteAdviceRequest(RouteAdviceRequest routeAdviceRequest);

    public RouteAdviceRequest findRouteAdviceRequestWithId(Long id);

	public List<RouteAdviceRequest> findAllRouteAdviceRequests();

}
