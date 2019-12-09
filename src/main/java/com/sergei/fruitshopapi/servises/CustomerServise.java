package com.sergei.fruitshopapi.servises;

import com.sergei.fruitshopapi.api.v1.model.CustomerDTO;
import com.sergei.fruitshopapi.domain.Customer;

import java.util.List;

public interface CustomerServise {
    List<CustomerDTO> getAllCustomer();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomerById(Long id);
}
