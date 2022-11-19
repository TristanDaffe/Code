package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.MagicKeyDataAccess;
import com.spring.henallux.firstSpringProject.model.MagicKeyForm;
import org.springframework.beans.factory.annotation.Autowired;
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
    private MagicKeyDataAccess magicKeyDataAccess;

    @Autowired
    public WelcomeController(MagicKeyDataAccess dataAccess){
        this.magicKeyDataAccess = dataAccess;
    }
    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model){
        model.addAttribute("title", "Test title");
        model.addAttribute("magicKeyForm", new MagicKeyForm());
        return "integrated:welcome";
    }
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(@ModelAttribute(value = "magicKeyForm") MagicKeyForm form){
        ArrayList<MagicKeyForm> magicKeys = magicKeyDataAccess.getAllMagicKeys();

        Boolean exist = false;
        int i = 0;
        while(i < magicKeys.size() && !exist){
            exist = magicKeys.get(i).getMagicKey().equals(form.getMagicKey());
            i++;
        }

        if(exist) {
            return "redirect:/inscription";
        } else {
            return "integrated:keyError";
        }

    }
}