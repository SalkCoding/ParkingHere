package com.salkcoding.partikinghere.parkinghere.service;

import com.google.gson.*;
import com.salkcoding.partikinghere.parkinghere.adapter.ParkingDTOTypeAdapter;
import com.salkcoding.partikinghere.parkinghere.constants.UnitConstants;
import com.salkcoding.partikinghere.parkinghere.dto.ParkingDTO;
import com.salkcoding.partikinghere.parkinghere.entity.Parking;
import com.salkcoding.partikinghere.parkinghere.repository.ParkingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class DataUpdateService {

    @Autowired
    private ParkingRepository parkingRepository;

    @Async
    void updatePage(int page) {
        log.info("Fetching page " + page);
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(ParkingDTO.class, new ParkingDTOTypeAdapter());
        Gson gson = builder.create();

        JsonElement jsonElement = JsonParser.parseString(getOpenStreamUrl(
                "http://data.seoul.go.kr/dataList/dataView.do?onepagerow=" + UnitConstants.dataFetchAmount
                        + "&srvType=S&infId=OA-21709&serviceKind=1&pageNo=" + page
                        + "&gridTotalCnt=17496&ssUserId=SAMPLE_VIEW&strWhere=&strOrderby=&filterCol=&txtFilter="
        ));
        if (jsonElement == null || jsonElement.isJsonNull()) {
            log.warn("Page " + page + " is null.");
            return;
        }
        JsonObject jsonObject = jsonElement.getAsJsonObject();

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
        log.info("Completed page " + page);
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
