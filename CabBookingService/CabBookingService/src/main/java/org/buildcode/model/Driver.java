package org.buildcode.model;

import org.buildcode.Ride;

public class Driver extends Person {
    private String id;
    private Account account;

    public void acceptRide(Ride ride) {
        ride.acceptRide();
    }

    public void rejectRide(Ride ride) {
        ride.rejectRide();
    }
}
