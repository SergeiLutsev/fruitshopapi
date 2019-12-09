package com.sergei.fruitshopapi.repositories;

import com.sergei.fruitshopapi.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor,Long> {
    Vendor findByName(String name);
}
