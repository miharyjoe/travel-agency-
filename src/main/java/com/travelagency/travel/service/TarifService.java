package com.travelagency.travel.service;

import com.travelagency.travel.model.Tarif;
import com.travelagency.travel.repository.TarifRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TarifService {
    private final TarifRepository repository;

    public List<Tarif> saveTarif(List<Tarif> tarif){
        return repository.saveAll(tarif);
    }

    public Tarif updateTarif(Tarif reservation){
        return repository.save(reservation);
    }
    public List<Tarif> findAllTarif(int page, int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return repository.findAll(pageable).toList();
    }

    public Tarif findTarifById(Long id){
        return repository.getReferenceById(id);
    }
}
