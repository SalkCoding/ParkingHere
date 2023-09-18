package com.salkcoding.partikinghere.parkinghere.repository;

import com.salkcoding.partikinghere.parkinghere.entity.Parking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingRepository extends CrudRepository<Parking,Long> {
    @Override
    List<Parking> findAll();
}
