package com.netzero.PrimeroBackSeller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

public class ProductDto {
    @Data
    @NoArgsConstructor
    public static class SearchRequest {
        private String keyword;
    }
}
