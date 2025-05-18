package com.capstone.productcatalog.controller;

import com.capstone.productcatalog.model.Product;
import com.capstone.productcatalog.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/catalog")
class CatalogController {
    private final CatalogService catalogService;

    CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // 2.1 Browsing Products by Category
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Product>> viewProductsByCategory(@PathVariable String categoryName, Model model) {
        List<Product> result = catalogService.productsByCategoryName(categoryName);
        return ResponseEntity.ok(result);
    }

    // 2.2 Product Details
    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> viewProductDetails(@PathVariable Long productId) throws Exception {
        Product result = catalogService.getProductById(productId);
        return ResponseEntity.ok(result);
    }

    // 2.3 Search
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("keyword") String keywor, Model model) {
        List<Product> products = catalogService.getProductsByKeyword(keywor);
        return ResponseEntity.ok(products);
    }

}