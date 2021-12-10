package com.ata.apiBanda.mapper;

import com.ata.apiBanda.models.banda.Address;
import com.ata.apiBanda.models.banda.Customer;
import com.ata.apiBanda.models.banda.LocalPhone;
import com.ata.apiBanda.models.banda.MobilePhone;
import com.ata.apiBanda.models.bandaDto.AddressDTO;
import com.ata.apiBanda.models.bandaDto.CustomerDTO;
import com.ata.apiBanda.models.bandaDto.LocalPhoneDTO;
import com.ata.apiBanda.models.bandaDto.MobilePhoneDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerDTOToCustomer(CustomerDTO customerDTO);

    Set<Customer> custormersDTOToCustomers(Set<CustomerDTO> customersDTO);
    Address addressDTOToAddress(AddressDTO addressDTO);

    Set<Address> addressesDTOToAddresses(Set<AddressDTO> addressesDTO);

    LocalPhone localPhoneDTOToLocalPhone(LocalPhoneDTO localPhoneDTO);

    MobilePhone mobilePhoneDTOToMobilePhone(MobilePhoneDTO mobilePhoneDTO);

    Set<MobilePhone> mobilePhonesDTOToMobilePhones(Set<MobilePhoneDTO> mobilePhonesDTO);
}
