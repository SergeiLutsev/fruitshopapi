package com.sergei.fruitshopapi.controllers;

import com.sergei.fruitshopapi.api.v1.model.CategoryDTO;
import com.sergei.fruitshopapi.api.v1.model.CategoryListDTO;
import com.sergei.fruitshopapi.servises.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${category.root.path}")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories(){
            return new CategoryListDTO(categoryService.getAllCategories());
    }
    @GetMapping({"/{name}"})
    @ResponseStatus(HttpStatus.OK)
    public  CategoryDTO getCategoryByName(@PathVariable("name") String name){
        return  categoryService.getCategoryByName(name);
    }
}
