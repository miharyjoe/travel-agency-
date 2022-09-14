package com.travelagency.travel.controller;

import com.travelagency.travel.model.Tarif;
import com.travelagency.travel.service.TarifService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tarifs")
@CrossOrigin("*")
public class TarifController {
    private final TarifService service;

    @GetMapping
    public List<Tarif> getAllTarifs(@RequestParam int page, @RequestParam int page_size) {
        return service.findAllTarif(page, page_size);
    }

    @GetMapping("/{id}")
    public Tarif getTarifById(@PathVariable Long id){
        return service.findTarifById(id);
    }

    @PostMapping
    public List<Tarif> createReservations(@RequestBody List<Tarif> tarifs){
        return service.saveTarif(tarifs);
    }

    @PutMapping
    public  Tarif modifyTarif(@RequestBody Tarif tarifs){
        return service.updateTarif(tarifs);
    }
}
