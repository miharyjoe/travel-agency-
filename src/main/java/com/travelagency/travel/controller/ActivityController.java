package com.travelagency.travel.controller;

import com.travelagency.travel.model.Activity;
import com.travelagency.travel.service.ActivityService;
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

@RestController
@AllArgsConstructor
@RequestMapping("/activities")
@CrossOrigin("*")
public class ActivityController {
    private final ActivityService service;

    @GetMapping
    public List<Activity> getAllActivities(@RequestParam int page, @RequestParam int page_size) {
        return service.findAllActivity(page, page_size);
    }

    @GetMapping("/{id}")
    public Activity getActivityById(@PathVariable Long id){
        return service.findActivityById(id);
    }

    @PostMapping
    public List<Activity> createActivities(@RequestBody List<Activity> activities){
        return service.saveActivity(activities);
    }

    @PutMapping
    public  Activity modifyActivity(@RequestBody Activity activity){
        return service.uptadeActivity(activity);
    }

    @DeleteMapping("/{id}")
    public String deleteActivityById(@PathVariable Long id){
        service.deleteActivityById(id);
        return "delete ok";
    }
}
