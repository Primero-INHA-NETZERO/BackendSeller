package com.netzero.PrimeroBackSeller.controller;

import com.netzero.PrimeroBackSeller.apiPayload.BaseResponse;
import com.netzero.PrimeroBackSeller.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    public BaseResponse<?> getProduct() {
        return BaseResponse.onSuccess(null);
    }

    public BaseResponse<?> getProductList() {
        return BaseResponse.onSuccess(null);
    }

    public BaseResponse<?> createProduct() {
        return BaseResponse.onSuccess(null);
    }

    public BaseResponse<?> updateSeller() {
        return BaseResponse.onSuccess(null);
    }

    public BaseResponse<?> deleteProduct() {
        return BaseResponse.onSuccess(null);
    }
}
