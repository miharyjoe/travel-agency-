package com.travelagency.travel.controller;

import com.travelagency.travel.model.Reservation;
import com.travelagency.travel.service.ReservationService;
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
@RequestMapping("/reservations")
@CrossOrigin("*")
public class ReservationController {
    private final ReservationService service;

    @GetMapping
    public List<Reservation> getAllReservations(@RequestParam int page, @RequestParam int page_size) {
        return service.findAllReservations(page, page_size);
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id){
        return service.findReserationById(id);
    }

    @PostMapping
    public List<Reservation> createReservations(@RequestBody List<Reservation> reservations){
        return service.saveReservation(reservations);
    }

    @PutMapping
    public  Reservation modifyReservation(@RequestBody Reservation reservations){
        return service.updateReservation(reservations);
    }

    @DeleteMapping("/{id}")
    public String deleteReservationById(@PathVariable Long id){
        service.deleteReservationById(id);
        return "delete ok";
    }
}
