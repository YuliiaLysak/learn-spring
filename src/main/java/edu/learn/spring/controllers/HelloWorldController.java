package edu.learn.spring.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Greetings to all!";
    }

    @GetMapping("/calc/sum")
    public int sum(@RequestParam("a") int a, @RequestParam("b") int b) {
        return a + b;
    }

    @GetMapping("/calc/mult")
    public int mult(@RequestParam("a") int a, @RequestParam("b") int b) {
        return a * b;
    }

    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable("name") String name) {
        if (name.length() < 3) {
            throw new RuntimeException("Name is too short");
        }
        return "Greeting, " + name;
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleError(Exception e) {
        return e.getMessage();
    }
}
