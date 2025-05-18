package com.capstone.productcatalog.service;

import com.capstone.productcatalog.exception.ProductException;
import com.capstone.productcatalog.model.Category;
import com.capstone.productcatalog.model.Product;
import com.capstone.productcatalog.repository.CategoryRepository;
import com.capstone.productcatalog.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public CatalogService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> productsByCategoryName(String categoryName) {
        try {
            Category category = categoryRepository.findByName(categoryName);
            if (category == null) {
                throw new ProductException(HttpStatus.NOT_FOUND,"Category not found");
            }
            return productRepository.findByCategory(category);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Product getProductById(Long id){
        try {
            Optional<Product> productOptional = productRepository.findById(id);
            if (productOptional.isEmpty()) {
                throw new ProductException(HttpStatus.NOT_FOUND, "Product not found");
            }
            return productOptional.get();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  List<Product> getProductsByKeyword(String keyword){
        try {
            return productRepository.findByNameContainingIgnoreCase(keyword);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
