package com.salkcoding.partikinghere.parkinghere.service;

import com.salkcoding.partikinghere.parkinghere.constants.UnitConstants;
import com.salkcoding.partikinghere.parkinghere.entity.Parking;
import com.salkcoding.partikinghere.parkinghere.repository.ParkingRepository;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private DataUpdateService dataUpdateService;

    @Getter
    private Date syncDate = Date.from(Instant.now());

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

    @Scheduled(fixedDelay = 1200000)//20분마다
    @Transactional
    public void updateData() {
        log.info("Database data being updated...");
        for (int page = 1; page <= 176; page++) {
            dataUpdateService.updatePage(page);
        }
        log.info("Database data update completed.");
        syncDate = Date.from(Instant.now());
    }

}
