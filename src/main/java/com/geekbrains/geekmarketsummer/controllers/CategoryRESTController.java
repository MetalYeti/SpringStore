package com.geekbrains.geekmarketsummer.controllers;

import com.geekbrains.geekmarketsummer.entites.Category;
import com.geekbrains.geekmarketsummer.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryRESTController implements CategoryClient{

    CategoryService categoryService;

    @Autowired
    public CategoryRESTController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @Override
    public Category getCategory(@PathVariable Integer id) {
        return categoryService.getAllCategories().get(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
