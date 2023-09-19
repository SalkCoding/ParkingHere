package com.salkcoding.partikinghere.parkinghere.service;

import com.salkcoding.partikinghere.parkinghere.constants.UnitConstants;
import com.salkcoding.partikinghere.parkinghere.entity.Parking;
import com.salkcoding.partikinghere.parkinghere.repository.ParkingRepository;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    public List<Parking> getParkingList(int page) {
        int start = (page - 1) * UnitConstants.dataShowOffset;
        return parkingRepository.findSubList(start, UnitConstants.dataShowOffset);
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
