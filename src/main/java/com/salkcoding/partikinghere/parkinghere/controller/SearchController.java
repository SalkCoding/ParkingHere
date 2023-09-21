package com.salkcoding.partikinghere.parkinghere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class SearchController {

    @GetMapping("")
    public String mainIndex(Model model) {
        model.addAttribute("location", "서울시 공영 주차장");
        model.addAttribute("address", "서울시 공영 주차장");
        return "searchNearSpotPage";
    }

    @GetMapping("search")
    public String search(Model model) {
        model.addAttribute("location", "서울시 공영 주차장");
        model.addAttribute("address", "서울시 공영 주차장");
        return "searchNearSpotPage";
    }

    @GetMapping("search/{address}")
    public String search(Model model, @PathVariable String address) {
        model.addAttribute("location", address);
        model.addAttribute("address", address);
        return "searchNearSpotPage";
    }

    @PostMapping("search")
    public String inputAddress(Model model, String address) {
        model.addAttribute("address", address);
        model.addAttribute("location", address);
        String encoded = URLEncoder.encode(address, StandardCharsets.UTF_8).replaceAll("\\+", " ");
        return "redirect:/search/" + encoded;
    }
}
