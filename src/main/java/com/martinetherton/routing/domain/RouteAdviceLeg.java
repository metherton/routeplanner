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
    @Column(name="id", columnDefinition = "bigint")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "route_advice_id", nullable = false, updatable = false)
    private RouteAdvice routeAdvice;
    
    @Column(name="location", columnDefinition = "char")
    @Size(min=1, max=20, message = "The first name must be between 1 and 20 characters long.")
    private String location;
    
    @Column(name="sort_order", columnDefinition = "bigint")
    private int sortOrder;    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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