package com.ata.apiBanda.mapper;

import com.ata.apiBanda.models.banda.Address;
import com.ata.apiBanda.models.banda.Customer;
import com.ata.apiBanda.models.banda.LocalPhone;
import com.ata.apiBanda.models.banda.MobilePhone;
import com.ata.apiBanda.models.bandaDto.AddressDTO;
import com.ata.apiBanda.models.bandaDto.CustomerDTO;
import com.ata.apiBanda.models.bandaDto.LocalPhoneDTO;
import com.ata.apiBanda.models.bandaDto.MobilePhoneDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerDTOToCustomer(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setCpf(customerDTO.getCpf());
        customer.setLocalPhone(localPhoneDTOToLocalPhone(customerDTO.getLocalPhone()));
        customer.setMobilePhones(mobilePhonesDTOToMobilePhones(customerDTO.getMobilePhones()));
        customer.setAddresses(addressesDTOToAddresses(customerDTO.getAddresses()));

        return customer;
    }

    @Override
    public Set<Customer> custormersDTOToCustomers(Set<CustomerDTO> customersDTO) {
        if (customersDTO == null) {
            return null;
        }

        Set<Customer> customers = new HashSet<Customer>();

        for (CustomerDTO customerDTO : customersDTO) {
            customers.add(customerDTOToCustomer(customerDTO));
        }

        return customers;
    }

    @Override
    public Address addressDTOToAddress(AddressDTO addressDTO) {

        Address address = new Address();

        address.setStreet(addressDTO.getStreet());
        address.setNumber(addressDTO.getNumber());
        address.setZipcode(addressDTO.getZipcode());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        address.setCustomers(custormersDTOToCustomers(addressDTO.getCustomers()));

        return address;
    }

    @Override
    public Set<Address> addressesDTOToAddresses(Set<AddressDTO> addressesDTO) {
        if (addressesDTO == null) {
            return null;
        }

        Set<Address> addresses = new HashSet<Address>();

        for (AddressDTO addressDTO : addressesDTO) {
            addresses.add(addressDTOToAddress(addressDTO));
        }

        return addresses;
    }

    @Override
    public LocalPhone localPhoneDTOToLocalPhone(LocalPhoneDTO localPhoneDTO) {
        if (localPhoneDTO == null) {
            return null;
        }

        LocalPhone localPhone = new LocalPhone();

        Set<Customer> customers = new HashSet<Customer>();
        for(Long id : localPhoneDTO.getCustomerIds()) {
            Customer customer = new Customer();
            customer.setId(id);
            customers.add(customer);
        }

        localPhone.setNumber(localPhoneDTO.getNumber());
        localPhone.setCustomers(customers);

        return localPhone;
    }

    @Override
    public MobilePhone mobilePhoneDTOToMobilePhone(MobilePhoneDTO mobilePhoneDTO) {
        if (mobilePhoneDTO == null) {
            return null;
        }

        MobilePhone mobilePhone = new MobilePhone();

        Customer customer = new Customer();
        customer.setId(mobilePhoneDTO.getCustomerId());
        mobilePhone.setCustomer(customer);

        mobilePhone.setNumber(mobilePhoneDTO.getNumber());

        return mobilePhone;
    }

    @Override
    public Set<MobilePhone> mobilePhonesDTOToMobilePhones(Set<MobilePhoneDTO> mobilePhonesDTO) {
        if (mobilePhonesDTO == null) {
            return null;
        }

        Set<MobilePhone> mobilePhones = new HashSet<MobilePhone>();

        for (MobilePhoneDTO mobilePhoneDTO : mobilePhonesDTO) {
            mobilePhones.add(mobilePhoneDTOToMobilePhone(mobilePhoneDTO));
        }

        return mobilePhones;
    }
}
