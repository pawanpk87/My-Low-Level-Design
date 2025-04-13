package org.buildcode.service;

import org.buildcode.Location;
import org.buildcode.Ride;
import org.buildcode.model.Cab;
import org.buildcode.model.Payment;
import org.buildcode.model.User;

public class RideServiceImpl implements RideService {

    @Override
    public Ride createRideRequest(User user, Location pickup, Location drop, Cab cab) {
        // create Ride
        return null;
    }

    @Override
    public Boolean cancelRide(String rideId) {
        // cancel Ride
        return null;
    }

    @Override
    public Boolean payment(Payment payment) {
        // payment
        return null;
    }
}
