package com.martinetherton.routing.domain;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.easymock.EasyMock;
import org.junit.Test;

public class RouteAdviceRequestHandlerTest {

    @Test
    public void requestRouteAdviceRelaysCallToRoutingServiceWhenReceived() {
        RoutingService routingService = createMock(RoutingService.class);
        RouteAdviceRequestHandlerImpl routeAdviceRequestHandler = new RouteAdviceRequestHandlerImpl(routingService);
        
        routingService.requestRouteAdviceFor(42L);
        
        replay(routingService);
        routeAdviceRequestHandler.processRouteAdviceRequest("42");
        verify(routingService);
    }
}
