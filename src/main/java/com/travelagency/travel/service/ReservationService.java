package com.travelagency.travel.service;

import com.travelagency.travel.model.Activity;
import com.travelagency.travel.model.Reservation;
import com.travelagency.travel.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;

    public List<Reservation> saveReservation(List<Reservation> reservations){
        return repository.saveAll(reservations);
    }

    public Reservation updateReservation(Reservation reservation){
        return repository.save(reservation);
    }
    public List<Reservation> findAllReservations(int page, int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return repository.findAll(pageable).toList();
    }

    public Reservation findReserationById(Long id){
        return repository.getReferenceById(id);
    }
    public void deleteReservationById(Long id){
        Reservation reservation = repository.getReferenceById(id);
        repository.delete(reservation);
    }
}
