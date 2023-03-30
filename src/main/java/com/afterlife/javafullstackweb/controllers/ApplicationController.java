package com.afterlife.javafullstackweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping(value = "/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping(value = "/dashboard")
    public String getDashboard(){return "index";}

}

