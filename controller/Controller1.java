package com.study.springboot202210sangwon.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {

    /*@GetMapping("/page1")  //@RequestMapping(value = "/page1", method = RequestMethod.GET) 를 줄인것
    public String page1(){   //String
        return "page1";  //html 파일명


    }*/
    @GetMapping("/page1")
    public ModelAndView page1(){
           ModelAndView mav = new ModelAndView();
           mav.setViewName("page1");
           mav.addObject("key", "value");
           return mav;
    }
    @GetMapping("/page2")
    public String page2(){
        return "page2";

    }

}
