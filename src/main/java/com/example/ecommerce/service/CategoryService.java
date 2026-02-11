package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.CategoryRequestDTO;
import com.example.ecommerce.dto.response.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    CategoryResponseDTO createCategory(CategoryRequestDTO request);

    List<CategoryResponseDTO> getAllCategories();

    CategoryResponseDTO getCategoryById(Long id);
}

