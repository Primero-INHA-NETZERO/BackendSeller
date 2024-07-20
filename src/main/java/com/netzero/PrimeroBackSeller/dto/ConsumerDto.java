package com.netzero.PrimeroBackSeller.dto;

import com.netzero.PrimeroBackSeller.domain.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class ConsumerDto {

    @Data
    @NoArgsConstructor
    public static class UserAddRequest {
        private String username;
    }

    @Getter
    public static class PurchaseInfoRequest {
        private Long consumerId;
    }

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class GetProductResponse {
        private List<ProductResponseDTO> productDtoList;
     }

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
     public static class ProductResponseDTO {
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
     }

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class GetPurchaseResponse {
        private List<PurchaseInfo> productDtoList;
    }

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PurchaseInfo {
        private Long id;
    }

}
