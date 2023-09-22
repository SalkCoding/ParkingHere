package com.salkcoding.partikinghere.parkinghere.dto;

import com.salkcoding.partikinghere.parkinghere.entity.Parking;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ParkingDTO {

    private String QUE_STATUS_NM;
    private String TEL;
    private String PARKING_TYPE;
    private String ADD_RATES;
    private String BUS_ADD_RATES;
    private String LNG;
    private String ADDR;
    private String HOLIDAY_PAY_YN;
    private String BUS_RATES;
    private String QUE_STATUS;
    private String CUR_PARKING_TIME;
    private String SH_TYPE;
    private String WEEKDAY_BEGIN_TIME;
    private String TIME_RATE;
    private String CAPACITY;
    private String CUR_PARKING;
    private String SH_CO;
    private String NIGHT_FREE_OPEN_NM;
    private String LAT;
    private String ADD_TIME_RATE;
    private String SH_ETC;
    private String RONUM;
    private String PAY_YN;
    private Long PARKING_CODE;
    private String RATES;
    private String WEEKEND_BEGIN_TIME;
    private String WEEKDAY_END_TIME;
    private String PARKING_TYPE_NM;
    private String SATURDAY_PAY_YN;
    private String OPERATION_RULE;
    private String BUS_ADD_TIME_RATE;
    private String PAY_NM;
    private String PARKING_NAME;
    private String WEEKEND_END_TIME;
    private String DAY_MAXIMUM;
    private String SH_LINK;
    private String HOLIDAY_PAY_NM;
    private String SATURDAY_PAY_NM;
    private String HOLIDAY_END_TIME;
    private String FULLTIME_MONTHLY;
    private String GRP_PARKNM;
    private String OPERATION_RULE_NM;
    private String NIGHT_FREE_OPEN;
    private String BUS_TIME_RATE;
    private String HOLIDAY_BEGIN_TIME;

    public Parking toEntity() {
        return new Parking(
                PARKING_CODE,
                PARKING_NAME,
                ADDR,
                PARKING_TYPE,
                OPERATION_RULE_NM,
                TEL,
                QUE_STATUS_NM,
                parseIntOrNull(CAPACITY),
                parseIntOrNull(CUR_PARKING),
                PAY_NM,
                parseIntOrNull(DAY_MAXIMUM),
                parseIntOrNull(ADD_RATES),
                parseIntOrNull(BUS_ADD_RATES),
                parseFloatOrNull(LAT),
                parseFloatOrNull(LNG),
                HOLIDAY_PAY_YN,
                BUS_RATES,
                parseIntOrNull(QUE_STATUS),
                CUR_PARKING_TIME,
                SH_TYPE,
                parseIntOrNull(WEEKDAY_BEGIN_TIME),
                parseIntOrNull(TIME_RATE),
                SH_CO,
                NIGHT_FREE_OPEN_NM,
                parseIntOrNull(ADD_TIME_RATE),
                SH_ETC,
                parseIntOrNull(RATES),
                parseIntOrNull(WEEKEND_BEGIN_TIME),
                parseIntOrNull(WEEKDAY_END_TIME),
                PARKING_TYPE_NM,
                SATURDAY_PAY_YN,
                parseIntOrNull(OPERATION_RULE),
                parseIntOrNull(BUS_ADD_TIME_RATE),
                parseIntOrNull(WEEKEND_END_TIME),
                PAY_YN,
                SH_LINK,
                HOLIDAY_PAY_NM,
                SATURDAY_PAY_NM,
                parseIntOrNull(HOLIDAY_END_TIME),
                parseIntOrNull(FULLTIME_MONTHLY),
                parseIntOrNull(GRP_PARKNM),
                NIGHT_FREE_OPEN,
                parseIntOrNull(BUS_TIME_RATE),
                parseIntOrNull(HOLIDAY_BEGIN_TIME)
        );
    }

    private Integer parseIntOrNull(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException ignored) {
            return null;
        }
    }

    private Float parseFloatOrNull(String string) {
        try {
            return Float.parseFloat(string);
        } catch (NumberFormatException ignored) {
            return null;
        }
    }

}
