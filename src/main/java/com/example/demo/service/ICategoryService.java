package com.example.demo.service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();

    CategoryDTO saveCategory(CategoryDTO categoryDTO);
}
