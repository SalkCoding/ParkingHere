package com.salkcoding.partikinghere.parkinghere.repository;

import com.salkcoding.partikinghere.parkinghere.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ParkingRepository extends JpaRepository<Parking, Long> {

    @Query(value = "select * from parking limit :pageAmount offset :startIdx", nativeQuery = true)
    List<Parking> findSubList(int startIdx, int pageAmount);

    @Query(value = "select * from parking where parking_name like concat('%',:input,'%') or addr like concat('%',:input,'%')", nativeQuery = true)
    List<Parking> findByInput(String input);
}
