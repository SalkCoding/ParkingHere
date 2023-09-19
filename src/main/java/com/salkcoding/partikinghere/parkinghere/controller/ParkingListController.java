package com.salkcoding.partikinghere.parkinghere.controller;

import com.salkcoding.partikinghere.parkinghere.entity.Parking;
import com.salkcoding.partikinghere.parkinghere.service.ParkingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
public class ParkingListController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping("list/{page}")
    public String parkingList(@PathVariable int page, Model model) {
        List<Parking> parkingList = parkingService.getParkingList(page);
        model.addAttribute("data", parkingList);
        model.addAttribute("previousPage", parkingService.getPreviousPage(page));
        model.addAttribute("nextPage", parkingService.getNextPage(page));
        return "parkingListPage";
    }
}
