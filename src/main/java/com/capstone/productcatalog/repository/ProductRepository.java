package com.capstone.productcatalog.repository;

import com.capstone.productcatalog.model.Category;
import com.capstone.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
    List<Product> findByNameContainingIgnoreCase(String keyword);
}
