package com.sergei.fruitshopapi.controllers;

import com.sergei.fruitshopapi.api.v1.model.CustomerDTO;
import com.sergei.fruitshopapi.api.v1.model.CustomerListDTO;
import com.sergei.fruitshopapi.servises.CustomerServise;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${customer.root.path}")
public class CustomerController {
    private final CustomerServise customerServise;

    public CustomerController(CustomerServise customerServise) {
        this.customerServise = customerServise;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getAllCustomers() {
        return new CustomerListDTO(customerServise.getAllCustomer());
    }

    @GetMapping({"/{custId}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById(@PathVariable("custId") Long id) {
        return customerServise.getCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO){
        return customerServise.createNewCustomer(customerDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDTO customerDTO){
        return customerServise.updateCustomer(id,customerDTO);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO patchCustomer(@PathVariable("id") Long id, @RequestBody CustomerDTO customerDTO){
        return  customerServise.patchCustomer(id, customerDTO);
    }

    @DeleteMapping({"{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id") Long id){
        customerServise.deleteCustomerById(id);
    }
}