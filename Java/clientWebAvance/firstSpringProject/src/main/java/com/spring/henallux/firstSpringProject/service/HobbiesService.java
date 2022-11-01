package com.spring.henallux.firstSpringProject.service;

import com.spring.henallux.firstSpringProject.model.Hobby;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class HobbiesService {
    private ArrayList<Hobby> hobbies;
    public HobbiesService(){
        hobbies = new ArrayList<>();
        hobbies.add(new Hobby("e12", "Sport"));
        hobbies.add(new Hobby("e13", "Nature"));
        hobbies.add(new Hobby("e14", "Sport"));
        hobbies.add(new Hobby("e15", "Reading"));
    }

    public void setHobbies(ArrayList<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public ArrayList<Hobby> getHobbies() {
        return hobbies;
    }
}
