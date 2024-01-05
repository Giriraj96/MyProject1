package com.example.productservice_proxy.services;

public interface ICategoryService {
    String getAllCategories();

    String getSingleCategory(Long categoryId);

    String addNewCategory();

    String updateCategory(Long categoryId);

    String deleteCategory(Long categoryId);
}
