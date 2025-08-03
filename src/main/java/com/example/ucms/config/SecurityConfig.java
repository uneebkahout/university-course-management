package com.example.ucms.config;

import com.example.ucms.security.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private  final JwtAuthFilter jwtAuthFilter;

@Bean

public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
   http
           .csrf(csrf -> csrf.disable())
           .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
           .authorizeHttpRequests(auth -> auth
                   .requestMatchers("/api/auth/**").permitAll()
                   .anyRequest().authenticated()

           )
           .addFilterBefore(jwtAuthFilter , UsernamePasswordAuthenticationFilter.class)
           .formLogin(form -> form.disable());


    return  http.build();
}



}
