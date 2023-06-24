package com.final2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/review")
    public String review(Model model){
        model.addAttribute("message", "Hello, Review!");
        return "review";
    }
}
