package org.buildcode.service;

import org.buildcode.Location;
import org.buildcode.model.Cab;
import org.buildcode.repository.CabRepository;

import java.util.List;

public class CabSearchImpl implements CabSearch {
    private final CabRepository cabRepository;

    public CabSearchImpl(CabRepository cabRepository) {
        this.cabRepository = cabRepository;
    }

    @Override
    public List<Cab> searchByLocation(Location location) {
        return cabRepository.getByLocation(location);
    }
}