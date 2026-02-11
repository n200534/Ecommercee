package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.request.CategoryRequestDTO;
import com.example.ecommerce.dto.response.CategoryResponseDTO;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO request) {

        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());

        Category saved = categoryRepository.save(category);

        return new CategoryResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getDescription()
        );
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(cat -> new CategoryResponseDTO(
                        cat.getId(),
                        cat.getName(),
                        cat.getDescription()
                ))
                .toList();
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }
}

