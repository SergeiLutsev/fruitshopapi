package com.sergei.fruitshopapi.servises;

import com.sergei.fruitshopapi.api.v1.model.CategoryDTO;
import com.sergei.fruitshopapi.domain.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryByName(String name);
}
