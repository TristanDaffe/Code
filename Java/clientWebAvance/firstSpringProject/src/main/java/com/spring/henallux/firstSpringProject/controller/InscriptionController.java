package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.User;
import com.spring.henallux.firstSpringProject.service.HobbiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/inscription")
@SessionAttributes({Constants.CURRENT_USER})
public class InscriptionController {
    private HobbiesService hobbiesService;

    @ModelAttribute(Constants.CURRENT_USER)
    public User user(){
        return new User();
    }

    @Autowired
    public InscriptionController(HobbiesService hobbiesService) {
        this.hobbiesService = hobbiesService;
    }


    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("title", "Test title");
        model.addAttribute("user", new User());
        model.addAttribute("hobbies", hobbiesService.getHobbies());
        return "integrated:userInscription";
    }
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(Model model,
                              @Valid @ModelAttribute(value = Constants.CURRENT_USER) User user,
                              final BindingResult errors){
        if(!errors.hasErrors()){
            return "redirect:/gift";
        } else{
            model.addAttribute("hobbies", hobbiesService.getHobbies());
            return "integrated:userInscription";
        }
    }
}