package com.sergei.fruitshopapi.controllers;

import com.sergei.fruitshopapi.api.v1.model.VendorDTO;
import com.sergei.fruitshopapi.api.v1.model.VendorListDTO;
import com.sergei.fruitshopapi.servises.VendorServise;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"${vendor.root.path}"})
public class VendorController {
    private final VendorServise vendorServise;

    public VendorController(VendorServise vendorServise) {
        this.vendorServise = vendorServise;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorListDTO getAllVendors() {
        return vendorServise.getAllVendors();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    private VendorDTO getVendorsById(@PathVariable("id") Long id) {
        return vendorServise.getVendorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorServise.createNewVendor(vendorDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@PathVariable("id") Long id, @RequestBody VendorDTO vendorDTO) {
        return vendorServise.updateVendor(id, vendorDTO);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@PathVariable("id") Long id, @RequestBody VendorDTO vendorDTO) {
        return vendorServise.patchVendor(id, vendorDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable("id") Long id) {
        vendorServise.deleteVendorById(id);
    }
}
