package com.salkcoding.partikinghere.parkinghere.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Entity
public class Parking {

    @Id
    Long code;

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @Column(name = "type")
    String type;

    @Column(name = "operateClassification")
    String operateClassification;

    @Column(name = "phoneNumber")
    String phoneNumber;

    @Column(name = "syncState")
    String syncState;

    @Column(name = "totalParkingSpot")
    String totalParkingSpot;

    @Column(name = "paidOrFree")
    String paidOrFree;

    @Column(name = "nightOpen")
    String nightOpen;

    @Column(name = "openWeekdayTime")
    Integer openWeekdayTime;

    @Column(name = "closeWeekdayTime")
    Integer closeWeekdayTime;

    @Column(name = "openWeekendTime")
    Integer openWeekendTime;

    @Column(name = "closeWeekendTime")
    Integer closeWeekendTime;

    @Column(name = "openHolidayTime")
    Integer openHolidayTime;

    @Column(name = "closeHolidayTime")
    Integer closeHolidayTime;

    @Column(name = "lastSyncTime")
    String lastSyncTime;

    @Column(name = "paidOrFreeOnWeekend")
    String paidOrFreeOnWeekend;

    @Column(name = "paidOrFreeOnHoliday")
    String paidOrFreeOnHoliday;

    @Column(name = "subscribePrice")
    Integer subscribePrice;

    @Column(name = "managementNumber")
    String managementNumber;

    @Column(name = "defaultParkingPrice")
    Integer defaultParkingPrice;

    @Column(name = "defaultParkingTime")
    Integer defaultParkingTime;

    @Column(name = "additionalParkingPrice")
    Integer additionalParkingPrice;

    @Column(name = "additionalParkingTime")
    Integer additionalParkingTime;

    @Column(name = "maxPriceOnDay")
    Integer maxPriceOnDay;

    @Column(name = "latitude")
    Float latitude;

    @Column(name = "longitude")
    Float longitude;

    public Parking() {

    }
}
