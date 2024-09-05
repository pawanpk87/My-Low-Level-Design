package org.buildcode;

import org.buildcode.model.Cab;
import org.buildcode.model.Driver;
import org.buildcode.model.Payment;
import org.buildcode.model.User;
import org.buildcode.repository.CabRepository;
import org.buildcode.repository.InMemoryCabRepository;
import org.buildcode.service.CabSearch;
import org.buildcode.service.CabSearchImpl;
import org.buildcode.service.RideService;
import org.buildcode.service.RideServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CabRepository cabRepository = new InMemoryCabRepository();
        CabSearch cabSearch = new CabSearchImpl(cabRepository);

        // user
        User user = new User();

        // user location
        Location pickup = new Location();
        Location drop = new Location();

        // search
        List<Cab> cabs = cabSearch.searchByLocation(pickup);

        // user select cab
        Cab userSelectedCab = cabs.get(0);

        RideService rideService = new RideServiceImpl();

        // user request ride
        Ride ride = rideService.createRideRequest(user, pickup, drop, userSelectedCab);

        // driver receives notification via NotificationService)
        Driver driver = new Driver();

        // driver accept request
        driver.acceptRide(ride);

        // ride completed

        // user do the payment via PaymentService
        Payment payment = new Payment();
        rideService.payment(payment);
    }
}