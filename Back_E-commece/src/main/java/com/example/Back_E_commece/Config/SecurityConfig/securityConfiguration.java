package com.example.Back_E_commece.Config.SecurityConfig;

import org.apache.catalina.Authenticator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class securityConfiguration {
    private final JwtAuthenticationFiller jwtAuthenticationFiller;
    public securityConfiguration(JwtAuthenticationFiller jwtAuthenticationFiller) {
        this.jwtAuthenticationFiller = jwtAuthenticationFiller;
    }

    @Bean
    public SecurityFilterChain securityFillterChain(HttpSecurity http)
    {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling( ex -> ex
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.setStatus(HttpStatus.FORBIDDEN.value());

                        })

                        ).authorizeHttpRequests(auth -> auth.requestMatchers("/V1/auth/Registrar").permitAll()
                        .requestMatchers(HttpMethod.POST, "/V1/avaliacoes").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                ).addFilterBefore(jwtAuthenticationFiller, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
    {
        return config.getAuthenticationManager();
    }




}

