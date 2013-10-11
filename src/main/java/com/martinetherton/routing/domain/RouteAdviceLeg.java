package com.martinetherton.routing.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="route_advice_leg")
public class RouteAdviceLeg implements Serializable {

    public RouteAdviceLeg() {
        
    }
    
    @Id
    @Column(name="route_advice_leg_id", columnDefinition = "bigint")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int routeAdviceLegId;
    
    @ManyToOne
    @JoinColumn(name = "route_advice_id", nullable = false, updatable = false)
    private RouteAdvice routeAdvice;
    
    @Column(name="location", columnDefinition = "varchar")
    @Size(min=1, max=255, message = "The first name must be between 1 and 50 characters long.")
    private String location;
    
    @Column(name="sort_order", columnDefinition = "bigint")
    private int sortOrder;    
    
    public int getRouteAdviceLegId() {
        return routeAdviceLegId;
    }

    public void setRouteAdviceLegId(int routeAdviceLegId) {
    
        this.routeAdviceLegId = routeAdviceLegId;
    }

    public RouteAdvice getRouteAdvice() {
        
        return routeAdvice;
    }

    public void setRouteAdvice(RouteAdvice routeAdvice) {
        this.routeAdvice = routeAdvice;
    }    

    public int getSortOrder() {
        
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
    
        this.sortOrder = sortOrder;
    }
    
    
    public String getLocation() {
        return location;
    }
 
    public void setLocation(String location) {
        this.location = location;
    }        
    
}
