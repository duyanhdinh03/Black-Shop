package com.ivandang.hmshop.service;

import com.ivandang.hmshop.dto.CategoryDTO;
import com.ivandang.hmshop.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(CategoryDTO category);
    Category getCategoryById(long id);
    List<Category> getAllCategories();
    Category updateCategory(long categoryId, CategoryDTO category);
    void deleteCategory(long id);
}
