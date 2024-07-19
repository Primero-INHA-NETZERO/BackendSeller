package com.netzero.PrimeroBackSeller.controller;

import com.netzero.PrimeroBackSeller.apiPayload.BaseResponse;

import com.netzero.PrimeroBackSeller.dto.ProductDto;
import com.netzero.PrimeroBackSeller.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public BaseResponse<Long> createProduct(@RequestBody ProductDto.CreateProductRequest createProductRequest) {
        return BaseResponse.onSuccess(productService.createProduct(createProductRequest));
    }

    @DeleteMapping("/products/{productId}")
    public BaseResponse<?> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return BaseResponse.onSuccess(null);
    }
}
