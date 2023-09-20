package com.salkcoding.partikinghere.parkinghere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParkingSpotLeftController {

    @GetMapping("pleft")
    public String spotLeft(){
        return "spotLeftPage";
    }
}
