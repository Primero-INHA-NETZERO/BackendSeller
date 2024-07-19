package com.netzero.PrimeroBackSeller.dto;


import lombok.Getter;

public class SellerDTO {

    @Getter
    public static class CreateSellerRequest {
        private String username;
    }

    @Getter
    public static class UpdateSellerRequest {
        private Long sellerId;
        private String username;
    }
}
