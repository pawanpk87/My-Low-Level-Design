package org.buildcode;

import org.buildcode.enums.RideStatus;
import org.buildcode.model.Driver;

public class Ride {
    private String id;
    private Location pickup;
    private Location drop;
    private Driver driver;
    private RideStatus status;

    public void acceptRide() {
        this.status = RideStatus.ACCEPTED;
    }

    public void rejectRide() {
        this.status = RideStatus.REJECTED;
    }
}