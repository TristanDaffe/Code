package com.spring.henallux.firstSpringProject.sevice;

import com.spring.henallux.firstSpringProject.model.Hobby;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HobbiesService {
    private ArrayList<Hobby> hobbies;

    public HobbiesService() {
        hobbies = new ArrayList<Hobby>();
        hobbies.add(new Hobby("sport", "Sport"));
        hobbies.add(new Hobby("reading", "Reading"));
        hobbies.add(new Hobby("nature", "Nature"));
        hobbies.add(new Hobby("music", "Music"));
    }

    public void setHobbies(ArrayList<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public ArrayList<Hobby> getHobbies() {
        return hobbies;
    }
}
