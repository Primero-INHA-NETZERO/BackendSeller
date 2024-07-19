package com.netzero.PrimeroBackSeller.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private String detailImageUrl;

    private String title;

    private String content;
    private String category;
    private Long price;
    private Integer rate;
    private Integer viewCount;

    private Long salePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    @JsonIgnore
    private Seller seller;

    @OneToMany(mappedBy = "product")
    List<Purchase> purchaseList = new ArrayList<>();
}
