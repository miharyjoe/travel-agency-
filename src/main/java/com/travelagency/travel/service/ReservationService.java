package com.travelagency.travel.service;

import com.travelagency.travel.model.Reservation;
import com.travelagency.travel.model.Travel;
import com.travelagency.travel.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;

    public Reservation updateReservation(Reservation reservation){
        return repository.save(reservation);
    }
    public List<Reservation> findAllReservations(int page, int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return repository.findAll(pageable).toList();
    }

    public List<Reservation> saveReservation(List<Reservation> reservations){

        return repository.saveAll(reservations);
    }
    public Optional<Reservation> findReserationById(Long id){
        return repository.findById(id);
    }
    public void deleteReservationById(Long id){
        Reservation reservation = repository.getReferenceById(id);
        repository.delete(reservation);
    }
}
