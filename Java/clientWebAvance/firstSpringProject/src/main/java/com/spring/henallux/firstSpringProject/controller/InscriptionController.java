package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.User;
import com.spring.henallux.firstSpringProject.sevice.HobbiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping(value="/inscription")
public class InscriptionController {
    private HobbiesService hobbiesService;

    @Autowired
    public InscriptionController(HobbiesService hobbiesService) {
        this.hobbiesService = hobbiesService;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("titrePage", "Congrats");
        model.addAttribute("user", new User());
        model.addAttribute("hobbies", hobbiesService.getHobbies());
        return "integrated:userInscription";
    }

    @RequestMapping(value="/send", method = RequestMethod.POST)
    public String getFormData(Model model,
                              @Valid @ModelAttribute(value="user") User user,
                              final BindingResult errors){
        if(!errors.hasErrors()) {
            model.addAttribute("titrePage", "Hello");
            return "integrated:gift";
        }
        else{
            model.addAttribute("titrePage", "Try again");
            model.addAttribute("user", new User());
            model.addAttribute("hobbies", hobbiesService.getHobbies());
            return "integrated:userInscription";
        }
    }
}
