package com.project.insulintracker.resources;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/blood_glucose_levels")
public class blood_glucose_levelsResource {

    @GetMapping("")
    public String getAllCategories (HttpServletRequest request){
        int userId =(Integer) request.getAttribute("userId");
        return "Authenticated! UserId: " + userId;
    }

}
