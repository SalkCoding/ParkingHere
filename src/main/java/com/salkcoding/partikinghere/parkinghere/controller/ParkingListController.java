package com.salkcoding.partikinghere.parkinghere.controller;

import com.salkcoding.partikinghere.parkinghere.entity.Parking;
import com.salkcoding.partikinghere.parkinghere.service.ParkingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
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

        model.addAttribute("syncDate", parkingService.getSyncDate().toString());
        return "parkingListPage";
    }

    @PostMapping("/list")
    public String parkingListBySearchAddr(@RequestBody String input, Model model) {
        String decoded = URLDecoder.decode(input.split("=")[1], StandardCharsets.UTF_8);
        decoded = decoded.replaceAll(" ", "%");
        List<Parking> parkingList = parkingService.getParkingListByInput(decoded);
        model.addAttribute("data", parkingList);
        model.addAttribute("previousPage", null);
        model.addAttribute("nextPage", null);

        model.addAttribute("syncDate", parkingService.getSyncDate().toString());
        return "parkingListPage";
    }
}
