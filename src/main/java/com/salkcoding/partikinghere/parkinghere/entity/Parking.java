package com.salkcoding.partikinghere.parkinghere.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Entity
public class Parking {

    @Id
    @Column(name = "parking_code")
    Long parkingCode;

    @Column(name = "parking_name")
    String parkingName;

    @Column(name = "addr")
    String addr;

    @Column(name = "parking_type")
    String parkingType;

    @Column(name = "operation_rule_nm")
    String operationRuleNm;

    @Setter
    @Column(name = "tel")
    String tel;

    @Column(name = "que_status_nm")
    String queStatusNm;

    @Column(name = "capacity")
    Integer capacity;

    @Column(name = "cur_parking")
    Integer curParking;

    @Column(name = "pay_nm")
    String payNm;

    @Column(name = "day_maximum")
    Integer dayMaximum;

    @Column(name = "add_rates")
    Integer addRates;

    @Column(name = "bus_add_rates")
    Integer busAddRates;

    @Column(name = "lat")
    Float lat;

    @Column(name = "lng")
    Float lng;

    @Column(name = "holiday_pay_yn")
    String holidayPayYn;

    @Column(name = "bus_rates")
    String busRates;

    @Column(name = "que_status")
    Integer queStatus;

    @Column(name = "cur_parking_time")
    String curParkingTime;

    @Column(name = "sh_type")
    String shType;

    @Column(name = "weekday_begin_time")
    Integer weekdayBeginTime;

    @Column(name = "time_rate")
    Integer timeRate;

    @Column(name = "sh_co")
    String shCo;

    @Column(name = "night_free_open_nm")
    String nightFreeOpenNm;

    @Column(name = "add_time_rate")
    Integer addTimeRate;

    @Column(name = "sh_etc")
    String shEtc;

    @Column(name = "rates")
    Integer rates;

    @Column(name = "weekend_begin_time")
    Integer weekendBeginTime;

    @Column(name = "weekday_end_time")
    Integer weekdayEndTime;

    @Column(name = "parking_type_nm")
    String parkingTypeNm;

    @Column(name = "saturday_pay_yn")
    String saturdayPayYn;

    @Column(name = "operation_rule")
    Integer operationRule;

    @Column(name = "bus_add_time_rate")
    Integer busAddTimeRate;

    @Column(name = "weekend_end_time")
    Integer weekendEndTime;

    @Column(name = "pay_yn")
    String payYn;

    @Column(name = "sh_link")
    String shLink;

    @Column(name = "holiday_pay_nm")
    String holidayPayNm;

    @Column(name = "saturday_pay_nm")
    String saturdayPayNm;

    @Column(name = "holiday_end_time")
    Integer holidayEndTime;

    @Column(name = "fulltime_monthly")
    Integer fulltimeMonthly;

    @Column(name = "grp_parknm")
    Integer grpParknm;

    @Column(name = "night_free_open")
    String nightFreeOpen;

    @Column(name = "bus_time_rate")
    Integer busTimeRate;

    @Column(name = "holiday_begin_time")
    Integer holidayBeginTime;

    public Parking() {

    }
}
