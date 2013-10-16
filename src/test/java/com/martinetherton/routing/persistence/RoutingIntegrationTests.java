package com.martinetherton.routing.persistence;

import org.hamcrest.Matchers;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.routing.domain.RouteAdviceRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:dataSourceTest-context.xml", "classpath:semafors-frontend-test-servlet.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class RoutingIntegrationTests {
  
    @Autowired
    private SessionFactory sessionFactory;    
    
    @Autowired
    private RouteAdviceRequestDao routeAdviceRequestDao;
    
    @Test
    public void testDbConnection() {
        RouteAdviceRequest routeAdviceRequest = routeAdviceRequestDao.findRouteAdviceRequestWithId(7L);
        Assert.assertThat(routeAdviceRequest.getStartLatitude(), Matchers.is("1"));
    }

}
