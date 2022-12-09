package com.study.springboot202210sangwon.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller2 {
    @GetMapping("/controller/2")
    public String load(Model model) {
        model.addAttribute("name", "김준일");
        return "controller_test";
    }
}
