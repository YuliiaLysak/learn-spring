package edu.learn.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SessionController {
    public Person person = new Person(null, null, null, new ArrayList<>());

    @GetMapping("/getCurrent")
    public Person getCurrent() {
        return person;
    }

    @GetMapping("/setInformation")
    public void setInformation(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        person.setFirstName(firstName);
        person.setLastName(lastName);
    }

    @GetMapping("/addPhone")
    public void addPhone(@RequestParam("phone") String phone) {
        person.getPhoneNumbers().add(phone);
    }

    @GetMapping("/removePhone")
    public void removePhone(@RequestParam("phone") String phone) {
        person.getPhoneNumbers().remove(phone);
    }
}



