package org.buildcode.repository;

import org.buildcode.Location;
import org.buildcode.model.Cab;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCabRepository implements CabRepository {
    private final List<Cab> cabs;

    public InMemoryCabRepository() {
        cabs = new ArrayList<>();
    }

    @Override
    public void save(Cab cab) {
        cabs.add(cab);
    }

    @Override
    public Cab get(String id) {
        return cabs.stream()
                .filter(cab -> cab.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException("No cab found for give id: " + id));
    }

    @Override
    public List<Cab> getByLocation(Location location) {
        return cabs.stream()
                .filter(cab -> cab.getLocation().isEqual(location))
                .toList();
    }
}
