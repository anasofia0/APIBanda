package com.ata.apiBanda.models.bandaDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
