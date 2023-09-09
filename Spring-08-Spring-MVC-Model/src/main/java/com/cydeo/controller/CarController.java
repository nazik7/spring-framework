package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/info") //localhost:8080/car/info?make=Honda&model=Civic
    public String carInfo(@RequestParam String make,Integer year, Model model){
        System.out.println(make);
        model.addAttribute("make", make);
        model.addAttribute("year",year);
        return "car-info";
    }

    @RequestMapping("/info2") //localhost:8080/car/info2  --> can put query parameter or just leave, and default value will shown
    public String carInfo2(@RequestParam(value = "make",required = false, defaultValue = "Tesla") String make,Model model){
        System.out.println(make);
        model.addAttribute("make", make);
        //model.addAttribute("year",year);
        return "car-info";
    }
}
