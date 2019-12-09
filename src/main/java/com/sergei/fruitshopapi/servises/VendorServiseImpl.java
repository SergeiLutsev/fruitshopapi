package com.sergei.fruitshopapi.servises;

import com.sergei.fruitshopapi.api.v1.mapper.VendorMapper;
import com.sergei.fruitshopapi.api.v1.model.VendorDTO;
import com.sergei.fruitshopapi.api.v1.model.VendorListDTO;
import com.sergei.fruitshopapi.domain.Vendor;
import com.sergei.fruitshopapi.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiseImpl implements VendorServise {
    @Value("${vendor.root.path}")
    private String vendorRoot;
    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiseImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public VendorListDTO getAllVendors() {
        List<VendorDTO> dtoList = vendorRepository.findAll()
                .stream()
                .map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
                    vendorDTO.setVendor_url(vendorRoot + "/" + vendor.getId());
                    return vendorDTO;
                })
                .collect(Collectors.toList());
        return new VendorListDTO(dtoList);
    }

    @Override
    public VendorDTO getVendorById(Long id) {

        return vendorRepository.findById(id).map(vendor -> {
            VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
            vendorDTO.setVendor_url(vendorRoot + "/" + id);
            return vendorDTO;
        }).orElseThrow(ResponseNotFoundException::new);
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {

        VendorDTO vendorDTOsaved = vendorMapper.vendorToVendorDTO(vendorRepository.save(vendorMapper.vendorDTOtoVendor(vendorDTO)));
        vendorDTOsaved.setVendor_url(vendorRoot + "/" + vendorDTOsaved.getId());
        return vendorDTOsaved;
    }

    @Override
    public VendorDTO updateVendor(Long id, VendorDTO vendorDTO) {

        return vendorRepository.findById(id)
                .map(vendor -> {
                    Vendor vendorUpdate = vendorMapper.vendorDTOtoVendor(vendorDTO);
                    vendorUpdate.setId(id);
                    Vendor vendorSaved = vendorRepository.save(vendorUpdate);
                    VendorDTO vendorDTOsaved = vendorMapper.vendorToVendorDTO(vendorSaved);
                    vendorDTOsaved.setVendor_url(vendorRoot + "/" + id);
                    return vendorDTOsaved;
                }).orElseThrow(ResponseNotFoundException::new);
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        return vendorRepository.findById(id)
                .map(vendor -> {
                    if (vendorDTO.getName() != null) {
                        vendor.setName(vendorDTO.getName());
                    }
                    VendorDTO vendorDTOsaved = vendorMapper.vendorToVendorDTO(vendorRepository.save(vendor));
                    vendorDTOsaved.setVendor_url(vendorRoot + "/" + id);
                    return vendorDTOsaved;
                }).orElseThrow(ResponseNotFoundException::new);
    }

    @Override
    public void deleteVendorById(Long id) {
        vendorRepository.findById(id).orElseThrow(ResponseNotFoundException::new);
        vendorRepository.deleteById(id);
    }
}
