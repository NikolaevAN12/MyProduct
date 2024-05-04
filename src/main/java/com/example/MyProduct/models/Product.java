package com.example.MyProduct.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Product {

    private Long id;
    private String title;
    private String description;
    private int price;
    private boolean available;
}


