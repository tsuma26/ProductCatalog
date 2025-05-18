package com.capstone.productcatalog.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
public class Product {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob // Use @Lob for potentially large text fields
    private String description;
    private double price;
    private String imageUrl; // Store URL to the image
    private String specifications; // Store as a single string, or create a separate table if needed for complex specs.

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
