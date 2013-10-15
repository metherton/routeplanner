package com.martinetherton.routing.flow;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.easymock.EasyMock;
import org.junit.Test;

import com.martinetherton.routing.domain.RouteAdviceRequest;
import com.martinetherton.routing.domain.RoutingService;

public class RoutingFlowActionsTest {

    @Test
    public void routingServiceRequestRouteAdviceInvoked() {

        RoutingService routingService = EasyMock.createMock(RoutingService.class);        
        RoutingFlowActions routingFlowActions = new RoutingFlowActions(routingService);
        
        
        RouteAdviceRequest routeAdviceRequest = new RouteAdviceRequest();
        routingService.triggerRouteAdviceCreationFor(routeAdviceRequest);
        
        replay(routingService);
        routingFlowActions.requestRouteAdvice(routeAdviceRequest);
        verify(routingService);
    }
    
}
