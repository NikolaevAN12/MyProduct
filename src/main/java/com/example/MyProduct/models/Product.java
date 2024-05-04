package com.example.MyProduct.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "products")
@Entity
@Data
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    @NotNull
    private String title;
    @Column(name = "description", columnDefinition = "text")
    @NotNull
    private String description;
    @Column(name = "price")
    @NotNull
    private double price;
    @NotNull
    @Column(name = "available")
    private boolean available;
}


