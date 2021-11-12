package com.ata.apiBanda.models.bandaDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String name;
    private String email;
    private Set<PhoneContactDTO> phoneContact;
    private String cpf;
    private Set<AddressDTO> address;
}
