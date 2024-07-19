package com.netzero.PrimeroBackSeller.dto;

import com.netzero.PrimeroBackSeller.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class ConsumerDto {

    @Data
    @NoArgsConstructor
    public static class UserAddRequest {
        private String username;
    }

    @Data
    @NoArgsConstructor
    public static class PurchaseInfoRequest {
        private Long consumerId;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class GetProductResponse {
        private List<Product> productList;
     }

}
