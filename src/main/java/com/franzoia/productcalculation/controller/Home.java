package com.franzoia.productcalculation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class Home {

    @RequestMapping("/")
    public String home() {
        return "";
    }

}