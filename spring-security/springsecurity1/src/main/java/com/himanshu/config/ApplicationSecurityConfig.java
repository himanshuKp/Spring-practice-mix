package com.himanshu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationSecurityConfig {

    @Bean
    public SecurityFilterChain securityFIlterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((requests) -> {
                    requests.requestMatchers("/myAccount","/myBalance","/myCards","/myLoans").authenticated()
                            .requestMatchers("/notices","/contact").permitAll();
                })
                .formLogin(FormLoginConfigurer::disable)
                .httpBasic(HttpBasicConfigurer::disable)
                .build();
    }
}
