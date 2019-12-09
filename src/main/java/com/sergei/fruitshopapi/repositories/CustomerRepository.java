package com.sergei.fruitshopapi.repositories;

import com.sergei.fruitshopapi.api.v1.model.CustomerDTO;
import com.sergei.fruitshopapi.domain.Customer;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
     Optional<Customer> findById(Long id);

}
