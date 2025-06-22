package com.himanshu.controller;

import com.himanshu.model.Customer;
import com.himanshu.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
        try {
            String encodedPassword = this.passwordEncoder.encode(customer.getPwd());
            customer.setPwd(encodedPassword);
            return ResponseEntity.ok(customerRepository.save(customer));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
