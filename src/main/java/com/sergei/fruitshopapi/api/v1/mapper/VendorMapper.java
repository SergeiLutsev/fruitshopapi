package com.sergei.fruitshopapi.api.v1.mapper;

import com.sergei.fruitshopapi.api.v1.model.VendorDTO;
import com.sergei.fruitshopapi.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {

    @Mapping(source = "id", target = "id")
    VendorDTO  vendorToVendorDTO(Vendor vendor);
    @Mapping(source = "id", target = "id")
    Vendor vendorDTOtoVendor(VendorDTO vendorDTO);
}
