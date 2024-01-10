package com.example.security_aut.service;

import com.example.security_aut.model.Application;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;
@Service

public class AppService {
    private List<Application> applications ;
    @PostConstruct
    public void loadAppInBd (){
        Faker faker = new Faker();
        applications= IntStream.rangeClosed(1,100)
                .mapToObj(i-> Application.builder()
                        .id(i)
                        .name(faker.app().name())
                        .author(faker.app().author())
                        .version(faker.app().version())
                        .build())
                .toList();

    }
    public List<Application> applications (){
        return applications ;
    }
    public Application applicationById(int id){
        return applications.stream()
                .filter(application -> application.getId()==id)
                .findFirst()
                .orElse(null);

    }
}
