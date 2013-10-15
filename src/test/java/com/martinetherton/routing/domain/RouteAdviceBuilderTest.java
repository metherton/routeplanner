package com.martinetherton.routing.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

public class RouteAdviceBuilderTest {

    @Test
    public void routeAdviceFieldsSetCorrectlyByBuilder() {
        RouteAdviceRequest rar = new RouteAdviceRequest();
        List<RouteAdviceLeg> raLegs = new ArrayList<RouteAdviceLeg>();
        
        RouteAdvice routeAdvice = new RouteAdvice.Builder().start("begin")
                                                            .destination("end")
                                                            .routeAdviceRequest(rar)
                                                            .routeAdviceLegs(raLegs).build();
        
        assertThat(routeAdvice.getStart(), is("begin"));
        assertThat(routeAdvice.getDestination(), is("end"));
        assertThat(routeAdvice.getRouteAdviceRequest(), is(rar));
        assertThat(routeAdvice.getRouteAdviceLegs(), is(raLegs));
    }
    
}
