package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.User;
import com.spring.henallux.firstSpringProject.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/gift")
@SessionAttributes({Constants.CURRENT_USER})
public class GiftController {

    private GiftService giftService;

    @Autowired
    public GiftController(GiftService giftService){
        this.giftService = giftService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String home (Model model,
                       @ModelAttribute(value= Constants.CURRENT_USER) User user){
        model.addAttribute("titrePage", "KDO");
        model.addAttribute("gift", giftService.chooseGift(user.getHobby(), user.getAge()));

        return "integrated:gift";
    }
}
