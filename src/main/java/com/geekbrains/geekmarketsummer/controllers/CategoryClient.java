package com.geekbrains.geekmarketsummer.controllers;

import com.geekbrains.geekmarketsummer.entites.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface CategoryClient {
    @RequestMapping("/get-category/{id}")
    Category getCategory(@PathVariable Integer id);

    @RequestMapping("/get-categories")
    List<Category> getAllCategories();
}