package com.salkcoding.partikinghere.parkinghere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParkingSpotLeftController {

    /*
    TODO Post로 받으면 검색에서 넘어온거이므로 주소 검색 (1)
    TODO Get으로 받으면 주차장 정보에서 넘어온거이므로 코드 검색 (1)
    TODO 10분마다 주차장 정보 받아와서 DB 업데이트 해주기 (2)
    TODO 주차장 정보쪽에 검색 기능 추가하기 (숫자만 받으면 코드로 검색, 일반 문자열이면 이름 검색 이름은 where = 해보고 null이면 like 해보기) (3)
    */
    @GetMapping("pleft/{code}")
    public String spotLeft(){
        return "spotLeftPage";
    }
}
