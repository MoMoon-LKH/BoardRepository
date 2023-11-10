package com.momoon.board.category.service;

import com.momoon.board.category.domain.Category;
import com.momoon.board.category.repository.CategoryRepository;
import com.momoon.board.common.exception.NotFoundDomainException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundDomainException("해당 카테고리를 찾을 수 없습니다"));
    }

}
