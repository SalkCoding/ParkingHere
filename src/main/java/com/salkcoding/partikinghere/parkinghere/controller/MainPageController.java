package com.salkcoding.partikinghere.parkinghere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("")
    public String indexPage(Model model){
        model.addAttribute("location","경기도 수원시 고색동 대원아파트");
        return "welcomePage";
    }

}
