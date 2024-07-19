package com.netzero.PrimeroBackSeller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class ProductDto {
    @Data
    @NoArgsConstructor
    public static class SearchRequest {
        private String keyword;
    }

    @Getter
    public static class CreateProductRequest {
        private Long sellerId;
        private String content;
        private String title;
        private Long price;
        private Long salePrice;

    @Data
    @NoArgsConstructor
    public static class PurchaseRequest {
        private Long productId;
        private Long consumerId;
    }
}
