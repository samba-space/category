package com.anysinsa.category.presentation;

import java.util.List;

import com.anysinsa.category.application.dto.CategoryResponseDTO;
import com.anysinsa.common.handler.GlobalExceptionHandler;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.anysinsa.category.domain.Category;
import com.anysinsa.category.domain.CategoryQueryRepository;

@Observed
@RestController
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryQueryRepository categoryQueryRepository;

    public CategoryController(CategoryQueryRepository categoryQueryRepository) {
        this.categoryQueryRepository = categoryQueryRepository;
    }

    @GetMapping(path = "/api/v1/categories")
    public ResponseEntity<List<Category>> findCategories() {
        logger.info("findCategories");
        return ResponseEntity.ok().body(categoryQueryRepository.findAll());
    }

    @GetMapping(path = "/api/v1/categories/{id}")
    public ResponseEntity<CategoryResponseDTO> findCategoryById(@PathVariable Long id) {
        logger.info("findCategories::{}", id);
        if (id == 6L) {
            throw new RuntimeException("Error 발생");
        }
        Category category = categoryQueryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("카테고리를 찾을 수 없습니다."));
        return ResponseEntity.ok().body(new CategoryResponseDTO(category.getId(), category.getName()));
    }

    @GetMapping(path = "/api/v1/categories/health")
    public String health() {
        return "health-category";
    }
}
