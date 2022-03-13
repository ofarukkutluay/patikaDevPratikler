package com.example.arackiralamaportali.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping()
    public String index(Model model){
        model.addAttribute("baslik","Araç Kiralama portalına hoşgeldiniz!");
        return "index";
    }
}
