package com.example.arackiralamaportali.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;

public class ControllerTools {

    public static void navbarAuth(Map<String,Object> map){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getName().equals("anonymousUser")){
            map.put("adminname", auth.getName());
            map.put("authority",auth.getAuthorities().toArray()[0]);
        }
    }
}
