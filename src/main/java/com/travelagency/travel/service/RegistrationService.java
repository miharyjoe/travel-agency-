package com.travelagency.travel.service;



import com.travelagency.travel.model.Users;
import com.travelagency.travel.repository.UsersRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService implements UserDetailsService {

    private final UsersRepo usersRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final static String User_error = "user with email %s not found";
    public String getPassword(String email) {
        return usersRepo.findUsersByEmailIs(email).get().getPassword();
    }
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return usersRepo.findByEmail(name)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(User_error, name)));
    }

    public String signUp(Users appUser) {
        boolean exist = usersRepo.findByEmail(appUser.getEmail())
                .isPresent();
        if (exist) {
            throw new IllegalStateException("email already taken please add number");
        }
        String encryptpassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encryptpassword);
        usersRepo.save(appUser);
        return "encryptpassword";
    }

}
