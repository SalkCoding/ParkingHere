package com.salkcoding.partikinghere.parkinghere.controller;

import com.salkcoding.partikinghere.parkinghere.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class SearchController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping("")
    public String mainIndex(Model model) {
        model.addAttribute("location", "서울시 공영 주차장");
        model.addAttribute("address", "서울시 공영 주차장");

        model.addAttribute("syncDate", parkingService.getSyncDate().toString());
        return "searchNearSpotPage";
    }

    @GetMapping("search")
    public String search(Model model) {
        model.addAttribute("location", "서울시 공영 주차장");
        model.addAttribute("address", "서울시 공영 주차장");

        model.addAttribute("syncDate", parkingService.getSyncDate().toString());
        return "searchNearSpotPage";
    }

    @GetMapping("search/{address}")
    public String search(Model model, @PathVariable String address) {
        String decoded = URLDecoder.decode(address, StandardCharsets.UTF_8);
        model.addAttribute("location", decoded);
        model.addAttribute("address", decoded);

        model.addAttribute("syncDate", parkingService.getSyncDate().toString());
        return "searchNearSpotPage";
    }

    @PostMapping("search")
    public String inputAddress(Model model, @RequestBody String body) {
        String address = body.split("=")[1];
        model.addAttribute("address", address);
        model.addAttribute("location", address);
        String encoded = URLEncoder.encode(address, StandardCharsets.UTF_8).replaceAll("\\+", " ");

        model.addAttribute("syncDate", parkingService.getSyncDate().toString());
        return "redirect:/search/" + encoded;
    }
}
