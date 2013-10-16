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
    
}
