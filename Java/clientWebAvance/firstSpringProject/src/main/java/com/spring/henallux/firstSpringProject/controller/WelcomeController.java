package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.MagicKeyForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;


@Controller
@RequestMapping(value = "/hello")
public class WelcomeController {
    private ArrayList <String> correctWords = new ArrayList<>(Arrays.asList("one", "two", "three"));
    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("title", "Test title");
        model.addAttribute("magicKeyForm", new MagicKeyForm());
        return "integrated:welcome";
    }
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(@ModelAttribute(value = "magicKeyForm") MagicKeyForm form){
        if(correctWords.indexOf(form.getMagicKey()) != -1) {
            return "redirect:/inscription";
        } else {
            return "integrated:keyError";
        }

    }
}