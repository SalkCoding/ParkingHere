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
    Long parking_code;

    @Column(name = "parking_name")
    String parking_name;

    @Column(name = "addr")
    String addr;

    @Column(name = "parking_type")
    String parking_type;

    @Column(name = "operation_rule_nm")
    String operation_rule_nm;

    @Column(name = "tel")
    String tel;

    @Column(name = "que_status_nm")
    String que_status_nm;

    @Column(name = "capacity")
    Integer capacity;

    @Column(name = "cur_parking")
    Integer cur_parking;

    @Column(name = "pay_nm")
    String pay_nm;

    @Column(name = "day_maximum")
    Integer day_maximum;

    @Column(name = "add_rates")
    Integer add_rates;

    @Column(name = "bus_add_rates")
    Integer bus_add_rates;

    @Column(name = "lat")
    Float lat;

    @Column(name = "lng")
    Float lng;

    @Column(name = "holiday_pay_yn")
    String holiday_pay_yn;

    @Column(name = "bus_rates")
    String bus_rates;

    @Column(name = "que_status")
    Integer que_status;

    @Column(name = "cur_parking_time")
    String cur_parking_time;

    @Column(name = "sh_type")
    String sh_type;

    @Column(name = "weekday_begin_time")
    Integer weekday_begin_time;

    @Column(name = "time_rate")
    Integer time_rate;

    @Column(name = "sh_co")
    String sh_co;

    @Column(name = "night_free_open_nm")
    String night_free_open_nm;

    @Column(name = "add_time_rate")
    Integer add_time_rate;

    @Column(name = "sh_etc")
    String sh_etc;

    @Column(name = "rates")
    Integer rates;

    @Column(name = "weekend_begin_time")
    Integer weekend_begin_time;

    @Column(name = "weekday_end_time")
    Integer weekday_end_time;

    @Column(name = "parking_type_nm")
    String parking_type_nm;

    @Column(name = "saturday_pay_yn")
    String saturday_pay_yn;

    @Column(name = "operation_rule")
    Integer operation_rule;

    @Column(name = "bus_add_time_rate")
    Integer bus_add_time_rate;

    @Column(name = "weekend_end_time")
    Integer weekend_end_time;

    @Column(name = "pay_yn")
    String pay_yn;

    @Column(name = "sh_link")
    String sh_link;

    @Column(name = "holiday_pay_nm")
    String holiday_pay_nm;

    @Column(name = "saturday_pay_nm")
    String saturday_pay_nm;

    @Column(name = "holiday_end_time")
    Integer holiday_end_time;

    @Column(name = "fulltime_monthly")
    Integer fulltime_monthly;

    @Column(name = "grp_parknm")
    Integer grp_parknm;

    @Column(name = "night_free_open")
    String night_free_open;

    @Column(name = "bus_time_rate")
    Integer bus_time_rate;

    @Column(name = "holiday_begin_time")
    Integer holiday_begin_time;

    public Parking() {

    }
}
