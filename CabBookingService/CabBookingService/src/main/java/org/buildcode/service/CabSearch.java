package org.buildcode.service;

import org.buildcode.Location;
import org.buildcode.model.Cab;

import java.util.List;

public interface CabSearch {

    List<Cab> searchByLocation(Location location);
}