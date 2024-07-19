package com.netzero.PrimeroBackSeller.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String imageUrl;

    private String title;

    private String content;

    private Long price;

    private Long salePrice;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
