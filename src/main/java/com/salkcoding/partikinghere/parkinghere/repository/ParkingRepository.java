package com.salkcoding.partikinghere.parkinghere.repository;

import com.salkcoding.partikinghere.parkinghere.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingRepository extends JpaRepository<Parking, Long> {

    @Query(value = "select * from parking limit :pageAmount offset :startIdx", nativeQuery = true)
    List<Parking> findSubList(int startIdx, int pageAmount);

}
