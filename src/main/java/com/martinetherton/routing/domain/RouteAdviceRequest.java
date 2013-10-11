package com.martinetherton.routing.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="route_request")
public class RouteAdviceRequest implements Serializable {

    @Override
    public String toString() {

        return "RouteAdviceRequest [id=" + routeRequestId + ", startLatitude="
                + startLatitude + ", startLongitude=" + startLongitude
                + ", destinationLatitude=" + destinationLatitude
                + ", destinationLongitude=" + destinationLongitude + "]";
    }

    public int getRouteRequestId() {
    
        return routeRequestId;
    }

    public void setRouteRequestId(int routeRequestId) {
    
        this.routeRequestId = routeRequestId;
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

    @Id
    @Column(name="route_request_id", columnDefinition = "bigint")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int routeRequestId;

    @Column(name="start_latitude", columnDefinition = "varchar")
    @Size(min=1, max=255, message = "The first name must be between 1 and 50 characters long.")
    private String startLatitude;

    @Column(name="start_longitude", columnDefinition = "varchar")
    @Size(min=1, max=255, message = "The first name must be between 1 and 50 characters long.")
    private String startLongitude;

    @Column(name="destination_latitude", columnDefinition = "varchar")
    @Size(min=1, max=255, message = "The first name must be between 1 and 50 characters long.")
    private String destinationLatitude;

    @Column(name="destination_longitude", columnDefinition = "varchar")
    @Size(min=1, max=255, message = "The first name must be between 1 and 50 characters long.")
    private String destinationLongitude;
    
    
}
