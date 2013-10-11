package com.martinetherton.routing.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.routing.domain.RouteAdvice;
import com.martinetherton.routing.domain.RouteAdviceRequest;

@Repository
@Transactional
public class RouteAdviceDaoImpl implements RouteAdviceDao {

    private final SessionFactory sessionFactory;
    
    @Autowired
    public RouteAdviceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }        
    
    public void storeRouteAdvice(RouteAdvice routeAdvice) {
        currentSession().merge(routeAdvice);

    }

    public RouteAdvice findRouteAdviceWithId(int id) {
        return (RouteAdvice)currentSession().get(RouteAdvice.class, id);
    }

    @Override
    public RouteAdvice findRouteAdviceFor(RouteAdviceRequest routeAdviceRequest) {
        return (RouteAdvice)currentSession().createCriteria(RouteAdvice.class).add(Restrictions.eq("routeAdviceRequest", routeAdviceRequest)).list().get(0);
    }

}
