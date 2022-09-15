package com.travelagency.travel.service;


import com.travelagency.travel.model.Travel;
import com.travelagency.travel.repository.TravelRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TravelService {
    private final TravelRepository repository;

    public List<Travel> findAllTravels(int page, int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return repository.findAll(pageable).toList();
    }
    public List<Travel> findTravelByDescription(String descrip){
        if(descrip== null || descrip.isEmpty()) {
            return null;
        }
        String output = descrip.substring(0).toLowerCase();
        return repository.findByDescriptionContaining(output);
    }
    public Optional<Travel> findTravelById(Long id){
        return repository.findById(id);
    }

    public List<Travel> saveTravel(List<Travel> travels){
        return repository.saveAll(travels);
    }

    public Travel uptadeTravel(Travel travel){
        return  repository.save(travel);
    }

    public void deleteTravelById(Long id){
        Travel travel = repository.getReferenceById(id);
        repository.delete(travel);
    }
}
