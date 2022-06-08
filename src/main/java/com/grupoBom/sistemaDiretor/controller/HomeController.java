package com.grupoBom.sistemaDiretor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView getHome(){
        ModelAndView mv = new ModelAndView("home.html");
        return mv;
    }
}
