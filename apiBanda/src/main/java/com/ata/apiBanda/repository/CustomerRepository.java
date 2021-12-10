package com.ata.apiBanda.repository;

import com.ata.apiBanda.models.banda.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
