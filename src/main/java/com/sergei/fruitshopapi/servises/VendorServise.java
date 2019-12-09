package com.sergei.fruitshopapi.servises;

import com.sergei.fruitshopapi.api.v1.model.VendorDTO;
import com.sergei.fruitshopapi.api.v1.model.VendorListDTO;
import com.sergei.fruitshopapi.domain.Vendor;

public interface VendorServise {
    VendorListDTO getAllVendors();
    VendorDTO getVendorById(Long id);
    VendorDTO createNewVendor(VendorDTO vendorDTO);
    VendorDTO updateVendor(Long id,VendorDTO vendorDTO);
    VendorDTO patchVendor(Long id,VendorDTO vendorDTO);
    void deleteVendorById(Long id);
}
