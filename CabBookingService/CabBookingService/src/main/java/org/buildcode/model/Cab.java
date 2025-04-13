package org.buildcode.model;

import org.buildcode.Location;
import org.buildcode.enums.CabStatus;
import org.buildcode.enums.CabType;

public class Cab {
    private String id;
    private CabType cabType;
    private Location location;
    private Driver driver;
    private CabStatus status;

    public String getId() {
        return this.id;
    }

    public void book() {
        this.status = CabStatus.BOOKED;
    }

    public void cancelBooking() {
        this.status = CabStatus.AVAILABLE;
    }

    public Location getLocation() {
        return this.location;
    }

    public void updateLocation(Location location) {
        this.location = location;
    }
}