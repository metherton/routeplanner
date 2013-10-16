package com.martinetherton.routing.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.bmtargoss.semafors.optimizer.domain.RouteRequest;

@Entity
@Table(name="route_advice")
public class RouteAdvice implements Serializable {

    
    private RouteAdvice(Builder builder) {
        start = builder.start;
        destination = builder.destination;
        routeAdviceRequest = builder.routeAdviceRequest;
        routeAdviceLegs = builder.routeAdviceLegs;
    }
    
    
    public static class Builder {

        public Builder() {
            
        }
        
        private String start;
        private String destination;
        private List<RouteAdviceLeg> routeAdviceLegs;
        private RouteAdviceRequest routeAdviceRequest;
        
        public Builder start(String val) {
            start = val;
            return this;
        }

        public Builder destination(String val) {
            destination = val;
            return this;
        }
        
        
        public RouteAdvice build() {
            return new RouteAdvice(this);
        }

        public Builder routeAdviceRequest(RouteAdviceRequest val) {
            routeAdviceRequest = val;
            return this;
        }

        public Builder routeAdviceLegs(List<RouteAdviceLeg> val) {
            routeAdviceLegs = val;
            return this;
        }
        
        
    }

    public RouteAdvice() {
        
    }
        
    
    @Id
    @Column(name="id", columnDefinition = "bigint")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "route_request_id", nullable = false, updatable = false)
    private RouteAdviceRequest routeAdviceRequest;    
    
    @Column(name="start", columnDefinition = "char")
    @Size(min=1, max=20, message = "The first name must be between 1 and 20 characters long.")
    private String start;

    @Column(name="destination", columnDefinition = "char")
    @Size(min=1, max=20, message = "The first name must be between 1 and 20 characters long.")
    private String destination;
   
    @OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name="route_advice_id")
    private List<RouteAdviceLeg> routeAdviceLegs;    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RouteAdviceRequest getRouteAdviceRequest() {
        return routeAdviceRequest;
    }
    
    public void setRouteAdviceRequest(RouteAdviceRequest routeAdviceRequest) {
        this.routeAdviceRequest = routeAdviceRequest;
    }
    
    public String getStart() {
        return start;
    }
 
    public void setStart(String start) {
        this.start = start;
    }    
   
    public String getDestination() {
        return destination;
    }
 
    public void setDestination(String destination) {
        this.destination = destination;
    }      
    
    public List<RouteAdviceLeg> getRouteAdviceLegs() {
        return routeAdviceLegs;
    }
 
    public void setRouteAdviceLegs(List<RouteAdviceLeg> routeAdviceLegs) {
        this.routeAdviceLegs = routeAdviceLegs;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((destination == null) ? 0 : destination.hashCode());
        result = prime * result + ((start == null) ? 0 : start.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RouteAdvice other = (RouteAdvice) obj;
        if (destination == null) {
            if (other.destination != null)
                return false;
        } else if (!destination.equals(other.destination))
            return false;
        if (start == null) {
            if (other.start != null)
                return false;
        } else if (!start.equals(other.start))
            return false;
        return true;
    }          
    
}
