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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="route_request")
public class RouteAdviceRequest implements Serializable {

    @Column(name="status", columnDefinition = "tinyint")
    private int status;

    @Override
    public String toString() {
        return "RouteAdviceRequest [id=" + id + ", startLatitude="
                + startLatitude + ", startLongitude=" + startLongitude
                + ", destinationLatitude=" + destinationLatitude
                + ", destinationLongitude=" + destinationLongitude + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(String startLatitude) {
        this.startLatitude = startLatitude;
    }

    public String getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(String startLongitude) {
        this.startLongitude = startLongitude;
    }

    public String getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(String destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public String getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(String destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }

    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    @OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name="route_request_id")
    private List<RouteAdviceLeg> routeAdviceLegs;      
    
    @Id
    @Column(name="id", columnDefinition = "bigint")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="start_latitude", columnDefinition = "char")
    @Size(min=1, max=20, message = "The first name must be between 1 and 20 characters long.")
    private String startLatitude;

    @Column(name="start_longitude", columnDefinition = "char")
    @Size(min=1, max=20, message = "The first name must be between 1 and 20 characters long.")
    private String startLongitude;

    @Column(name="destination_latitude", columnDefinition = "char")
    @Size(min=1, max=20, message = "The first name must be between 1 and 20 characters long.")
    private String destinationLatitude;

    @Column(name="destination_longitude", columnDefinition = "char")
    @Size(min=1, max=20, message = "The first name must be between 1 and 20 characters long.")
    private String destinationLongitude;
  
    @Column(name="start", columnDefinition = "char")
    @Size(min=1, max=20, message = "The first name must be between 1 and 20 characters long.")
    private String start;

    @Column(name="destination", columnDefinition = "char")
    @Size(min=1, max=20, message = "The first name must be between 1 and 20 characters long.")
    private String destination;    
    

    public List<RouteAdviceLeg> getRouteAdviceLegs() {
        return routeAdviceLegs;
    }
 
    public void setRouteAdviceLegs(List<RouteAdviceLeg> routeAdviceLegs) {
        this.routeAdviceLegs = routeAdviceLegs;
    }    
    
//    @OneToOne
//    @JoinColumn(name="route_advice_id")
//    public RouteAdvice routeAdvice;
    
}
