package com.himanshukandpal.thymeleafSecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user1 = User.builder()
                .username("usera")
                .password("{noop}usera")
                .authorities("EMPLOYEE")
                .build();

        UserDetails user2 = User.builder()
                .username("userb")
                .password("{noop}userb")
                .authorities("EMPLOYEE", "MANAGER")
                .build();

        UserDetails user3 = User.builder()
                .username("userc")
                .password("{noop}userc")
                .authorities("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
}
