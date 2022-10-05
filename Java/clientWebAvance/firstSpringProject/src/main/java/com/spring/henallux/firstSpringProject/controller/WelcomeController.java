package com.spring.henallux.firstSpringProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/hello")
public class WelcomeController {
    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("titrePage", "La banane");
//        return "welcome";
        return "integrated:welcome";
    }
}
