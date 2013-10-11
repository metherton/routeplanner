package com.martinetherton.routing.persistence;

import com.martinetherton.routing.domain.RouteAdvice;
import com.martinetherton.routing.domain.RouteAdviceRequest;

public interface RouteAdviceDao {

    public void storeRouteAdvice(RouteAdvice routeAdvice);

    public RouteAdvice findRouteAdviceWithId(int id);

    public RouteAdvice findRouteAdviceFor(RouteAdviceRequest routeAdviceRequest);
    
    
}
