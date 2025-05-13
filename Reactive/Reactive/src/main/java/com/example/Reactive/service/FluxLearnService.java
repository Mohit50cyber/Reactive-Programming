package com.example.Reactive.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class FluxLearnService {

    public void fluxTestingService(){

        System.out.println("Flux Testing bhai");
    }
    //all operators example goes here
    //creating flux
    public Flux<String> getFlux(){
        return Flux.just("mohit", "singh", "vishal", "tom", "harry", "preet","niggaass").log();
    }

    public Flux<String> fruitsFlux(){
        List<String> fruitNames = List.of("Mango","orange");
        return Flux.fromIterable(fruitNames).log();
    }

    //map
    public Flux<String> mapExampleFlux(){
        Flux<String> capsFlux = getFlux().map(name -> name.toUpperCase());
        return capsFlux;
    }

    //filter
    public Flux<String> filterExampleFlux(){
        return getFlux().filter(name->name.length()>5).log();
    }


}
