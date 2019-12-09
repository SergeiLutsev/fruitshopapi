package com.sergei.fruitshopapi.repositories;

import com.sergei.fruitshopapi.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);
}
