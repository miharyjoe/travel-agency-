package com.travelagency.travel.service;


import com.travelagency.travel.model.Roles;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationForm {
    private final String email;
    private final String password;
    private final Roles roles;
}
