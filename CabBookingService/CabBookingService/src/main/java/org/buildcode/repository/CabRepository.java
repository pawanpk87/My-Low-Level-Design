package org.buildcode.repository;

import org.buildcode.Location;
import org.buildcode.model.Cab;

import java.util.List;

public interface CabRepository {

    void save(Cab cab);

    Cab get(String id);

    List<Cab> getByLocation(Location location);
}