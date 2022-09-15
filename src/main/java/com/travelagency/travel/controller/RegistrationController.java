package com.travelagency.travel.controller;

import com.travelagency.travel.service.RegistrationForm;
import com.travelagency.travel.service.UsersRegistration;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@CrossOrigin("*")
@RestController
public class RegistrationController {
    private UsersRegistration usersRegistration;
    @PostMapping(value = "/signup" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String register(@RequestBody RegistrationForm request) {
        return usersRegistration.register(request);
    }
}