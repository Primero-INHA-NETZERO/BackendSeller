package com.netzero.PrimeroBackSeller.dto;

import lombok.Getter;

public class ProductDTO {

    @Getter
    public static class CreateProductRequest {
        private String title;
        private String content;
        private Long price;
        private Long salePrice;
        private Long sellerId;
    }
}
