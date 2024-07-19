package com.netzero.PrimeroBackSeller.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@DynamicUpdate
@Getter
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

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

    @OneToMany(mappedBy = "product")
    List<Purchase> purchaseList = new ArrayList<>();
}
