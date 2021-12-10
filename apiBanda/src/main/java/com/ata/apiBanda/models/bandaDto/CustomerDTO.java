package com.ata.apiBanda.models.bandaDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String name;
    private String email;
    private LocalPhoneDTO localPhone;
    private Set<MobilePhoneDTO> mobilePhones;
    private String cpf;
    private Set<AddressDTO> addresses;
}
