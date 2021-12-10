package com.ata.apiBanda.models.bandaDto;

import com.ata.apiBanda.models.banda.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private String street;
    private int number;
    private int zipcode;
    private String city;
    private String state;
    private String country;
    private Set<CustomerDTO> customers;

}
