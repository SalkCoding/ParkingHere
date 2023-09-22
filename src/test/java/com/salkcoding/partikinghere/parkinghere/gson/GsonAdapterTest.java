package com.salkcoding.partikinghere.parkinghere.gson;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.salkcoding.partikinghere.parkinghere.adapter.ParkingDTOTypeAdapter;
import com.salkcoding.partikinghere.parkinghere.dto.ParkingDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class GsonAdapterTest {

    @Test
    public void toJsonAndFromJson_given_ParkingDTO() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(ParkingDTO.class, new ParkingDTOTypeAdapter());
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        ParkingDTO dto = new ParkingDTO();
        dto.setPARKING_CODE(1L);
        dto.setADDR("");
        dto.setTEL("null");

        String json = gson.toJson(dto);
        ParkingDTO result = gson.fromJson(json, ParkingDTO.class);

        assertEquals(1, result.getPARKING_CODE());
        assertEquals("", result.getADDR());
    }
}
