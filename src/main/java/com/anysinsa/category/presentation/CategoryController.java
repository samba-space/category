package com.anysinsa.category.presentation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.anysinsa.category.domain.Category;
import com.anysinsa.category.domain.CategoryQueryRepository;

@RestController
public class CategoryController {

    private final CategoryQueryRepository categoryQueryRepository;

    public CategoryController(CategoryQueryRepository categoryQueryRepository) {
        this.categoryQueryRepository = categoryQueryRepository;
    }

    @GetMapping(path = "/api/v1/categories")
    public ResponseEntity<List<Category>> findCategories() {
        return ResponseEntity.ok().body(categoryQueryRepository.findAll());
    }

    @GetMapping(path = "/api/v1/categories/health")
    public String health() {
        return "ok-man-4";
    }
}
