package com.example.productservice_proxy.controllers;

import com.example.productservice_proxy.dtos.CategoryDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {
    @GetMapping
    public String getAllCategories() {
        return "Getting all the categories";
    }
    @GetMapping("/{id}")
        public String getSingleCategory(@PathVariable("id") Long categoryId) {
        return "Getting single category with id: " + categoryId;
    }
    @PostMapping
    public String addNewCategory(@RequestBody CategoryDto categorydto) {
        return "Adding new Category: " + categorydto;
    }
}