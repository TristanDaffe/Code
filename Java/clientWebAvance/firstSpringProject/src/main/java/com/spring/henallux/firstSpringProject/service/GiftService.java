package com.spring.henallux.firstSpringProject.service;

import org.springframework.stereotype.Service;

@Service
public class GiftService {

    public String chooseGift(String hobby, int age){
        String output = "you will receive a ";

        if(age < 5){
            output += " a puzzle ";
        }
        else{
            if(age < 10){
                output += " a DVD ";
            }
            else{
                output += " a book";
            }
        }

        output += " about "+ hobby +" !";
        return output;
    }
}
