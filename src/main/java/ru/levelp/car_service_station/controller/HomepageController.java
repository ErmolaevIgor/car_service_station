package ru.levelp.car_service_station.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({ ""})
public class HomepageController {

    @GetMapping("")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="welcome") String name, Model model) {
        model.addAttribute("name", name);
        return "homepage";
    }

}