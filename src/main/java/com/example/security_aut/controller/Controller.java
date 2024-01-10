package com.example.security_aut.controller;

import com.example.security_aut.model.Application;
import com.example.security_aut.service.AppService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/apps")
@AllArgsConstructor
public class Controller {
    private AppService appService ;
    @GetMapping("/welcome")
    public String welcome(){
        return "Добро пожаловать на не защищенную страницу" ;
    }
    @GetMapping("/all-app")
    public List<Application> allApp(){
        return appService.applications();
    }
    @GetMapping("/{id}")
    public Application appById(@PathVariable int id){
        return appService.applicationById(id);

    }

}
