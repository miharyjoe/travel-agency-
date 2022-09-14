package com.travelagency.travel.service;

import com.travelagency.travel.model.Activity;
import com.travelagency.travel.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@AllArgsConstructor
public class ActivityService {
    private final ActivityRepository repository;

    public List<Activity> findAllActivity(int page, int pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);
        return repository.findAll(pageable).toList();
    }

    public Activity findActivityById(Long id){
        return repository.getReferenceById(id);
    }

    public List<Activity> saveActivity(List<Activity> activity){
        return repository.saveAll(activity);
    }

    public Activity uptadeActivity(Activity activity){
        return  repository.save(activity);
    }

    public void deleteActivityById(Long id){
        Activity activity = repository.getReferenceById(id);
        repository.delete(activity);
    }
}
