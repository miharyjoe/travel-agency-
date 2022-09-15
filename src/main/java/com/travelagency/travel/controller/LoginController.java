package com.travelagency.travel.controller;


import com.travelagency.travel.service.RegistrationForm;
import com.travelagency.travel.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@CrossOrigin("*")
@RestController
@EqualsAndHashCode
public class LoginController {
    private RegistrationService registrationService;

    @PostMapping(value = "/login" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String login(@RequestBody RegistrationForm users) {
        if(users.getPassword()  != registrationService.getPassword(users.getEmail())){
            return "connexion NON faite";
        }
        else {
            registrationService.loadUserByUsername(users.getEmail());
            return "connexion non faite";
        }
    }
}
