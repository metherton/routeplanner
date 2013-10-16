package com.martinetherton.routing.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.martinetherton.routing.domain.RouteAdviceRequest;

@Repository
@Transactional
public class RouteAdviceRequestDaoImpl implements RouteAdviceRequestDao {

    private final SessionFactory sessionFactory;
    
    @Autowired
    public RouteAdviceRequestDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
  //  @Override
    public void storeRouteAdviceRequest(RouteAdviceRequest routeAdviceRequest) {
        currentSession().merge(routeAdviceRequest);
        
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

//    @Override
    public RouteAdviceRequest findRouteAdviceRequestWithId(Long id) {
        return (RouteAdviceRequest)currentSession().get(RouteAdviceRequest.class, id);
    }

	@Override
	public List<RouteAdviceRequest> findAllRouteAdviceRequests() {
		List<RouteAdviceRequest> results = (List<RouteAdviceRequest>)currentSession().createCriteria(RouteAdviceRequest.class).list();
		System.out.println(results.size());
		return results;
	}    
    
}
