package com.study.springboot202210sangwon.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller1 {

    @GetMapping("/page1")  //@RequestMapping(value = "/page1", method = RequestMethod.GET) 를 줄인것
    public String page1(){
        return "page1";  //html 파일명

    }
    @GetMapping("/page2")
    public String page2(){
        return "page2";

    }

}
