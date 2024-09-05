package org.buildcode.service;

import org.buildcode.Location;
import org.buildcode.Ride;
import org.buildcode.model.Cab;
import org.buildcode.model.Payment;
import org.buildcode.model.User;

public interface RideService {

    Ride createRideRequest(User user, Location pickup, Location drop, Cab cab);

    Boolean cancelRide(String rideId);

    Boolean payment(Payment payment);
}