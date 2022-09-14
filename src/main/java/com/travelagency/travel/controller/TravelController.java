package com.travelagency.travel.controller;


import com.travelagency.travel.model.Travel;
import com.travelagency.travel.service.TravelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/travels")
@CrossOrigin("*")
public class TravelController {
    private final TravelService service;

    @GetMapping
    public List<Travel> getAllTravels(@RequestParam int page, @RequestParam int page_size) {
        return service.findAllTravels(page, page_size);
    }

    @GetMapping("/{id}")
    public Optional<Travel> getTravelById(@PathVariable Long id){
        return service.findTravelById(id);
    }

    @PostMapping
    public List<Travel> createTravels(@RequestBody List<Travel> travel){
        return service.saveTravel(travel);
    }

    @PutMapping
    public  Travel modifyTravel(@RequestBody Travel travels){
        return service.uptadeTravel(travels);
    }

    @DeleteMapping("/{id}")
    public String deleteTravelById(@PathVariable Long id){
        service.deleteTravelById(id);
        return "delete ok";
    }
}
