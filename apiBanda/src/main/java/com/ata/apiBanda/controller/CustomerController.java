package com.ata.apiBanda.controller;

import com.ata.apiBanda.models.banda.Customer;
import com.ata.apiBanda.models.bandaDto.CustomerDTO;
import com.ata.apiBanda.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> criarCustomer(@RequestBody CustomerDTO customerDTO) {
        this.customerService.criarCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
