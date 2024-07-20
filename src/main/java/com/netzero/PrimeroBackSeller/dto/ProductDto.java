package com.netzero.PrimeroBackSeller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
    public static class PurchaseListRequest {
        List<PurchaseRequest> purchaseRequestList;
    }

    @Getter
    public static class PurchaseRequest {
        private Long productId;
        private Long consumerId;
    }

}

