package com.salkcoding.partikinghere.parkinghere.controller;

import com.salkcoding.partikinghere.parkinghere.entity.Parking;
import com.salkcoding.partikinghere.parkinghere.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParkingSpotLeftController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping("pleft/{code}")
    public String spotLeftByCode(@PathVariable Long code, Model model) {
        Parking parking = parkingService.getParkingInfoByCode(code);
        model.addAttribute("location", parking.getParkingName());
        model.addAttribute("address", parking.getAddr());
        return "spotLeftPage";
    }

}
