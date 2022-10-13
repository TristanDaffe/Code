package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.MagicKeyForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/hello")
public class WelcomeController {

    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("titrePage", "La banane");
        model.addAttribute("magicKeyForm", new MagicKeyForm());
        return "integrated:welcome";
    }

    @RequestMapping(value="/send", method = RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="magicKeyForm") MagicKeyForm form){
        if(form.getMagicKey().isEmpty())
            return "integrated:keyError";
        else
            return "redirect:/inscription";
    }
}
