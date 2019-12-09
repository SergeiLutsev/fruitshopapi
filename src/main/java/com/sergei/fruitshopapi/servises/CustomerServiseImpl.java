package com.sergei.fruitshopapi.servises;

import com.sergei.fruitshopapi.api.v1.mapper.CustomerMapper;
import com.sergei.fruitshopapi.api.v1.model.CustomerDTO;
import com.sergei.fruitshopapi.domain.Customer;
import com.sergei.fruitshopapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CustomerServiseImpl implements CustomerServise {

    @Value("${customer.root.path}")
    private String customerRoot;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    public CustomerServiseImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> {
                   CustomerDTO customerDTO= customerMapper.customerToCustomerTDO(customer);
                    customerDTO.setCustomer_url(customerRoot+"/"+customer.getId());
                    return customerDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {

        return customerRepository.findById(id).map(customer -> {
            CustomerDTO customerDTO=customerMapper.customerToCustomerTDO(customer);
            customerDTO.setCustomer_url(customerRoot+"/"+customer.getId());
            return customerDTO;
        }).orElseThrow(ResponseNotFoundException::new);
        
    }


    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        Customer customer=customerMapper.customerDTOtoCustomer(customerDTO);
        Customer SavedCustomer = customerRepository.save(customer);
        CustomerDTO newDto=customerMapper.customerToCustomerTDO(SavedCustomer);
        newDto.setCustomer_url(customerRoot+"/"+newDto.getId());
        return newDto;
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer=customerMapper.customerDTOtoCustomer(customerDTO);
        customer.setId(id);
        Customer SavedCustomer = customerRepository.save(customer);
        CustomerDTO newDto=customerMapper.customerToCustomerTDO(SavedCustomer);
        newDto.setCustomer_url(customerRoot+"/"+newDto.getId());
        return newDto;
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {
            if(customerDTO.getFirstName()!=null){
                customer.setFirstName(customerDTO.getFirstName());
            }
            if(customerDTO.getLastName()!=null){
                customer.setSecondName(customerDTO.getLastName());
            }
            CustomerDTO custDTO=customerMapper.customerToCustomerTDO(customerRepository.save(customer));
            custDTO.setCustomer_url(customerRoot+"/"+custDTO.getId());
            return custDTO;
        }).orElseThrow(ResponseNotFoundException::new);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.findById(id).orElseThrow(ResponseNotFoundException::new);
        customerRepository.deleteById(id);
    }
}
