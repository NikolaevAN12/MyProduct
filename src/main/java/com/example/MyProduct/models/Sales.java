package com.example.MyProduct.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name = "sales")
@Entity
@Data
@AllArgsConstructor
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "document_name")
    @NotNull
    private String documentName;
    @Column(name = "count_sold")
    @NotNull
    private Integer countSold;
    @ManyToOne
    @JoinColumn(referencedColumnName  = "id")
    @NotNull
    private Product product;
}


