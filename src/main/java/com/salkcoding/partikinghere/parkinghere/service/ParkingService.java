package com.salkcoding.partikinghere.parkinghere.service;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeolocationApi;
import com.salkcoding.partikinghere.parkinghere.constants.UnitConstants;
import com.salkcoding.partikinghere.parkinghere.entity.Parking;
import com.salkcoding.partikinghere.parkinghere.repository.ParkingRepository;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    public List<Parking> getParkingList(int page) {
        int start = (page - 1) * UnitConstants.dataShowOffset;
        List<Parking> parkingList = parkingRepository.findSubList(start, UnitConstants.dataShowOffset);
        parkingList.forEach(parking -> {
            if (parking.getTel().isEmpty()) parking.setTel(null);
        });
        return parkingList;
    }

    public List<Parking> getParkingListByInput(String input) {
        List<Parking> parkingList = parkingRepository.findByInput(input);
        parkingList.forEach(parking -> {
            if (parking.getTel().isEmpty()) parking.setTel(null);
        });
        return parkingList;
    }

    public Parking getParkingInfoByCode(Long code) {
        Parking info = parkingRepository.findById(code).orElse(null);
        if (info == null) throw new IllegalArgumentException("Invalid parking_code " + code);
        return info;
    }


    @Nullable
    public Integer getNextPage(int page) {
        int next = page + 1;
        return isCorrectPageIndex(next) ? next : null;
    }

    @Nullable
    public Integer getPreviousPage(int page) {
        int previous = page - 1;
        return isCorrectPageIndex(previous) ? previous : null;
    }

    private boolean isCorrectPageIndex(int page) {
        int start = (page - 1) * UnitConstants.dataShowOffset;
        return 0 <= start && start <= parkingRepository.count();
    }

}
