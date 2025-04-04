package com.example.internship;

public class RoutesRequest {
    private   String origin;
    private   String destination;
    private   int maxFlights;

    public int getMaxFlights() {
        return maxFlights;
    }

    public void setMaxFlights(int maxFlights) {
        this.maxFlights = maxFlights;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}

