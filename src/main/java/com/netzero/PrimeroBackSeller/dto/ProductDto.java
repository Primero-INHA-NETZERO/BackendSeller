package com.netzero.PrimeroBackSeller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class ProductDto {
    @Data
    @NoArgsConstructor
    public static class SearchRequest {
        private String keyword;
    }

    @Data
    @NoArgsConstructor
    public static class PurchaseRequest {
        private Long productId;
        private Long consumerId;
    }
}
