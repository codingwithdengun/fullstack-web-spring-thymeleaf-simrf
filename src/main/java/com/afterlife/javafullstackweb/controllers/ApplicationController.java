package com.afterlife.javafullstackweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping(value = "/login")
    public String getLogin(){
        return "security/login";
    }

    @GetMapping(value = "/ims/dashboard")
    public String getDashboard(){return "dashboard/index";}

    @GetMapping(value = "/ims/daftar")
    public String getRegister(){ return "security/register";}

    @GetMapping(value = "/ims/lupa-password")
    public String getForgotPassword(){return "security/forgot_password";}
}

