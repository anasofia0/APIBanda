package com.ata.apiBanda.service;

import com.ata.apiBanda.mapper.CustomerMapper;
import com.ata.apiBanda.models.banda.Customer;
import com.ata.apiBanda.models.banda.LocalPhone;
import com.ata.apiBanda.models.bandaDto.CustomerDTO;
import com.ata.apiBanda.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void criarCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        LocalPhone localPhone = new LocalPhone();
        customer = CustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);
        customer.setLocalPhone(localPhone);
        this.customerRepository.save(customer);
    }

}
