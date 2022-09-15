package com.travelagency.travel.security;



import com.travelagency.travel.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final RegistrationService userService;
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .cors()
            .and()
            .authorizeRequests()
            .antMatchers( GET, "/travels/**").permitAll()
            .antMatchers(POST, "/travels/**").hasAnyRole("ADMIN")
            .antMatchers(PUT, "/travels/**").hasAnyRole("ADMIN")
            .antMatchers(DELETE, "/travels/**").hasAnyRole("ADMIN")
            .antMatchers( GET, "/reservations/**").hasAnyRole("ADMIN","USER")
            .antMatchers(POST, "/reservations/**").hasAnyRole("ADMIN","USER")
            .antMatchers(PUT, "/reservations/**").hasAnyRole("ADMIN")
            .antMatchers(DELETE, "/reservations/**").hasAnyRole("ADMIN")
            .and()
            .formLogin()
            .loginPage("http://localhost:3000/login")
            .and()
            .logout()
            .permitAll()
            .and()
            .csrf()
            .disable()
            .httpBasic();
  }
  @Bean
  public AuthenticationSuccessHandler successHandler() {
    SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
    handler.setUseReferer(true);
    return handler;
  }
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(daoAuthenticationProvider());
  }
  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(bCryptPasswordEncoder);
    provider.setUserDetailsService(userService);
    return provider;
  }
  @Override
  @Bean
  protected UserDetailsService userDetailsService() {
    return userService;
  }
}
