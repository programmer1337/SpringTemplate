package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public ModelAndView homePage(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("appName", appName);

        return modelAndView;
    }

    @GetMapping("/test")
    public ModelAndView test(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error-page");

        modelAndView.addObject("errorNumber", "404");
        modelAndView.addObject("errorText", "Page not found");

        return modelAndView;
    }
}