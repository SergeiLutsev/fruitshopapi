package com.sergei.fruitshopapi.api.v1.mapper;

import com.sergei.fruitshopapi.api.v1.model.CustomerDTO;
import com.sergei.fruitshopapi.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
    @Mappings({@Mapping(source = "id", target = "id"),
            @Mapping(source = "firstName",target = "firstName"),
            @Mapping(source = "secondName", target = "lastName")})
    CustomerDTO customerToCustomerTDO(Customer customer);

    @Mappings({
            @Mapping(source = "lastName",target = "secondName")
    })
    Customer customerDTOtoCustomer(CustomerDTO customerDTO);
}
