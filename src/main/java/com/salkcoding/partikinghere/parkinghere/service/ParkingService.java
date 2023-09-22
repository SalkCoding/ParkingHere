package com.salkcoding.partikinghere.parkinghere.service;

import com.google.gson.*;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeolocationApi;
import com.salkcoding.partikinghere.parkinghere.adapter.ParkingDTOTypeAdapter;
import com.salkcoding.partikinghere.parkinghere.constants.UnitConstants;
import com.salkcoding.partikinghere.parkinghere.dto.ParkingDTO;
import com.salkcoding.partikinghere.parkinghere.entity.Parking;
import com.salkcoding.partikinghere.parkinghere.repository.ParkingRepository;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

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
    @Async
    @Transactional
    public void updateData() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(ParkingDTO.class, new ParkingDTOTypeAdapter());
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        log.info("Database data being updated...");
        for (int page = 1; page <= 176; page++) {
            log.info("Fetching page " + page);
            JsonObject jsonObject = JsonParser.parseString(getOpenStreamUrl(
                    "http://data.seoul.go.kr/dataList/dataView.do?onepagerow=" + UnitConstants.dataFetchAmount
                            + "&srvType=S&infId=OA-21709&serviceKind=1&pageNo=" + page
                            + "&gridTotalCnt=17496&ssUserId=SAMPLE_VIEW&strWhere=&strOrderby=&filterCol=&txtFilter="
            )).getAsJsonObject();

            JsonArray array = jsonObject.get("list").getAsJsonArray();
            if (array == null || array.isEmpty())
                throw new IllegalStateException("page: " + page + " is null or empty");

            for (JsonElement element : array) {
                if (element == null || element.isJsonNull())
                    continue;
                if (element.getAsJsonObject().get("PARKING_CODE").getAsString().equals("null")) continue;
                ParkingDTO dto = gson.fromJson(element, ParkingDTO.class);
                if (dto == null) continue;
                Parking parking = dto.toEntity();
                parkingRepository.save(parking);
            }
        }
        log.info("Database data update completed.");
        syncDate = Date.from(Instant.now());
    }

    private String getOpenStreamUrl(String urlToRead) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlToRead);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            log.error(e.toString());
        }
        return result.toString();
    }

}
