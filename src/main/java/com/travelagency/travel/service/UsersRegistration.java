package com.travelagency.travel.service;

import com.travelagency.travel.model.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersRegistration {
    private EmailChecker emailChecker;
    private RegistrationService registrationService;
    public String register(RegistrationForm request) {

        boolean validEmail = emailChecker.test(request.getEmail());

        if(!validEmail) {
            throw new IllegalStateException("email not valid");
        }
        return  registrationService.signUp(
                new Users(
                        request.getEmail(),
                        request.getPassword(),
                        request.getRoles()
                )
        );
    }
}
