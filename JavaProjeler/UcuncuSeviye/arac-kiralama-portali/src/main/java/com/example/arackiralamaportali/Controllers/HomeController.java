package com.example.arackiralamaportali.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/")
public class HomeController {


    @GetMapping()
    public String index(Map<String, Object> map){
        ControllerTools.navbarAuth(map);
        return "index";
    }
}
