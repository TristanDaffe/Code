package com.spring.henallux.firstSpringProject.model;
import javax.validation.constraints.*;


public class User {

    @NotNull
    @Size(min=4, max=15)
    private String name;

    @NotNull
    @Min(value = 1)
    @Max(value = 12)
    private Integer age;
    private Boolean male;
    private String hobby;


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getMale() {
        return male;
    }

    public String getHobby() {
        return hobby;
    }
}
