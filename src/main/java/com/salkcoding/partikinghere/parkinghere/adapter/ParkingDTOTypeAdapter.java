package com.salkcoding.partikinghere.parkinghere.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.salkcoding.partikinghere.parkinghere.dto.ParkingDTO;

import java.io.IOException;

public class ParkingDTOTypeAdapter extends TypeAdapter<ParkingDTO> {

    @Override
    public void write(JsonWriter writer, ParkingDTO dto) throws IOException {
        writer.beginObject();
        writer.name("QUE_STATUS_NM");
        writer.value(dto.getQUE_STATUS_NM());
        writer.name("TEL");
        writer.value(dto.getTEL());
        writer.name("PARKING_TYPE");
        writer.value(dto.getPARKING_TYPE());
        writer.name("ADD_RATES");
        writer.value(dto.getADD_RATES());
        writer.name("BUS_ADD_RATES");
        writer.value(dto.getBUS_ADD_RATES());
        writer.name("LNG");
        writer.value(dto.getLNG());
        writer.name("ADDR");
        writer.value(dto.getADDR());
        writer.name("HOLIDAY_PAY_YN");
        writer.value(dto.getHOLIDAY_PAY_YN());
        writer.name("BUS_RATES");
        writer.value(dto.getBUS_RATES());
        writer.name("QUE_STATUS");
        writer.value(dto.getQUE_STATUS());
        writer.name("CUR_PARKING_TIME");
        writer.value(dto.getCUR_PARKING_TIME());
        writer.name("SH_TYPE");
        writer.value(dto.getSH_TYPE());
        writer.name("WEEKDAY_BEGIN_TIME");
        writer.value(dto.getWEEKDAY_BEGIN_TIME());
        writer.name("TIME_RATE");
        writer.value(dto.getTIME_RATE());
        writer.name("CAPACITY");
        writer.value(dto.getCAPACITY());
        writer.name("CUR_PARKING");
        writer.value(dto.getCUR_PARKING());
        writer.name("SH_CO");
        writer.value(dto.getSH_CO());
        writer.name("NIGHT_FREE_OPEN_NM");
        writer.value(dto.getNIGHT_FREE_OPEN_NM());
        writer.name("LAT");
        writer.value(dto.getLAT());
        writer.name("ADD_TIME_RATE");
        writer.value(dto.getADD_TIME_RATE());
        writer.name("SH_ETC");
        writer.value(dto.getSH_ETC());
        writer.name("RONUM");
        writer.value(dto.getRONUM());
        writer.name("PAY_YN");
        writer.value(dto.getPAY_YN());
        writer.name("PARKING_CODE");
        writer.value(dto.getPARKING_CODE());
        writer.name("RATES");
        writer.value(dto.getRATES());
        writer.name("WEEKEND_BEGIN_TIME");
        writer.value(dto.getWEEKEND_BEGIN_TIME());
        writer.name("WEEKDAY_END_TIME");
        writer.value(dto.getWEEKDAY_END_TIME());
        writer.name("PARKING_TYPE_NM");
        writer.value(dto.getPARKING_TYPE_NM());
        writer.name("SATURDAY_PAY_YN");
        writer.value(dto.getSATURDAY_PAY_YN());
        writer.name("OPERATION_RULE");
        writer.value(dto.getOPERATION_RULE());
        writer.name("BUS_ADD_TIME_RATE");
        writer.value(dto.getBUS_ADD_TIME_RATE());
        writer.name("PAY_NM");
        writer.value(dto.getPAY_NM());
        writer.name("PARKING_NAME");
        writer.value(dto.getPARKING_NAME());
        writer.name("WEEKEND_END_TIME");
        writer.value(dto.getWEEKEND_END_TIME());
        writer.name("DAY_MAXIMUM");
        writer.value(dto.getDAY_MAXIMUM());
        writer.name("SH_LINK");
        writer.value(dto.getSH_LINK());
        writer.name("HOLIDAY_PAY_NM");
        writer.value(dto.getHOLIDAY_PAY_NM());
        writer.name("SATURDAY_PAY_NM");
        writer.value(dto.getSATURDAY_PAY_NM());
        writer.name("HOLIDAY_END_TIME");
        writer.value(dto.getHOLIDAY_END_TIME());
        writer.name("FULLTIME_MONTHLY");
        writer.value(dto.getFULLTIME_MONTHLY());
        writer.name("GRP_PARKNM");
        writer.value(dto.getGRP_PARKNM());
        writer.name("OPERATION_RULE_NM");
        writer.value(dto.getOPERATION_RULE_NM());
        writer.name("NIGHT_FREE_OPEN");
        writer.value(dto.getNIGHT_FREE_OPEN());
        writer.name("BUS_TIME_RATE");
        writer.value(dto.getBUS_TIME_RATE());
        writer.name("HOLIDAY_BEGIN_TIME");
        writer.value(dto.getHOLIDAY_BEGIN_TIME());
        writer.endObject();
    }

    @Override
    public ParkingDTO read(JsonReader reader) throws IOException {
        ParkingDTO dto = new ParkingDTO();
        reader.beginObject();
        String fieldname = null;

        while (reader.hasNext()) {
            JsonToken token = reader.peek();

            if (token.equals(JsonToken.NAME)) {
                //get the current token
                fieldname = reader.nextName();
            }

            if ("QUE_STATUS_NM".equals(fieldname)) dto.setQUE_STATUS_NM(reader.nextString());
            if ("TEL".equals(fieldname)) dto.setTEL(reader.nextString());
            if ("PARKING_TYPE".equals(fieldname)) dto.setPARKING_TYPE(reader.nextString());
            if ("ADD_RATES".equals(fieldname)) dto.setADD_RATES(reader.nextString());
            if ("BUS_ADD_RATES".equals(fieldname)) dto.setBUS_ADD_RATES(reader.nextString());
            if ("LNG".equals(fieldname)) dto.setLNG(reader.nextString());
            if ("ADDR".equals(fieldname)) dto.setADDR(reader.nextString());
            if ("HOLIDAY_PAY_YN".equals(fieldname)) dto.setHOLIDAY_PAY_YN(reader.nextString());
            if ("BUS_RATES".equals(fieldname)) dto.setBUS_RATES(reader.nextString());
            if ("QUE_STATUS".equals(fieldname)) dto.setQUE_STATUS(reader.nextString());
            if ("CUR_PARKING_TIME".equals(fieldname)) dto.setCUR_PARKING_TIME(reader.nextString());
            if ("SH_TYPE".equals(fieldname)) dto.setSH_TYPE(reader.nextString());
            if ("WEEKDAY_BEGIN_TIME".equals(fieldname)) dto.setWEEKDAY_BEGIN_TIME(reader.nextString());
            if ("TIME_RATE".equals(fieldname)) dto.setTIME_RATE(reader.nextString());
            if ("CAPACITY".equals(fieldname)) dto.setCAPACITY(reader.nextString());
            if ("CUR_PARKING".equals(fieldname)) dto.setCUR_PARKING(reader.nextString());
            if ("SH_CO".equals(fieldname)) dto.setSH_CO(reader.nextString());
            if ("NIGHT_FREE_OPEN_NM".equals(fieldname)) dto.setNIGHT_FREE_OPEN_NM(reader.nextString());
            if ("LAT".equals(fieldname)) dto.setLAT(reader.nextString());
            if ("ADD_TIME_RATE".equals(fieldname)) dto.setADD_TIME_RATE(reader.nextString());
            if ("SH_ETC".equals(fieldname)) dto.setSH_ETC(reader.nextString());
            if ("RONUM".equals(fieldname)) dto.setRONUM(reader.nextString());
            if ("PAY_YN".equals(fieldname)) dto.setPAY_YN(reader.nextString());
            if ("PARKING_CODE".equals(fieldname)) dto.setPARKING_CODE(reader.nextLong());
            if ("RATES".equals(fieldname)) dto.setRATES(reader.nextString());
            if ("WEEKEND_BEGIN_TIME".equals(fieldname)) dto.setWEEKEND_BEGIN_TIME(reader.nextString());
            if ("WEEKDAY_END_TIME".equals(fieldname)) dto.setWEEKDAY_END_TIME(reader.nextString());
            if ("PARKING_TYPE_NM".equals(fieldname)) dto.setPARKING_TYPE_NM(reader.nextString());
            if ("SATURDAY_PAY_YN".equals(fieldname)) dto.setSATURDAY_PAY_YN(reader.nextString());
            if ("OPERATION_RULE".equals(fieldname)) dto.setOPERATION_RULE(reader.nextString());
            if ("BUS_ADD_TIME_RATE".equals(fieldname)) dto.setBUS_ADD_TIME_RATE(reader.nextString());
            if ("PAY_NM".equals(fieldname)) dto.setPAY_NM(reader.nextString());
            if ("PARKING_NAME".equals(fieldname)) dto.setPARKING_NAME(reader.nextString());
            if ("WEEKEND_END_TIME".equals(fieldname)) dto.setWEEKEND_END_TIME(reader.nextString());
            if ("DAY_MAXIMUM".equals(fieldname)) dto.setDAY_MAXIMUM(reader.nextString());
            if ("SH_LINK".equals(fieldname)) dto.setSH_LINK(reader.nextString());
            if ("HOLIDAY_PAY_NM".equals(fieldname)) dto.setHOLIDAY_PAY_NM(reader.nextString());
            if ("SATURDAY_PAY_NM".equals(fieldname)) dto.setSATURDAY_PAY_NM(reader.nextString());
            if ("HOLIDAY_END_TIME".equals(fieldname)) dto.setHOLIDAY_END_TIME(reader.nextString());
            if ("FULLTIME_MONTHLY".equals(fieldname)) dto.setFULLTIME_MONTHLY(reader.nextString());
            if ("GRP_PARKNM".equals(fieldname)) dto.setGRP_PARKNM(reader.nextString());
            if ("OPERATION_RULE_NM".equals(fieldname)) dto.setOPERATION_RULE_NM(reader.nextString());
            if ("NIGHT_FREE_OPEN".equals(fieldname)) dto.setNIGHT_FREE_OPEN(reader.nextString());
            if ("BUS_TIME_RATE".equals(fieldname)) dto.setBUS_TIME_RATE(reader.nextString());
            if ("HOLIDAY_BEGIN_TIME".equals(fieldname)) dto.setHOLIDAY_BEGIN_TIME(reader.nextString());

        }
        reader.endObject();
        return dto;
    }
}
