package com.netzero.PrimeroBackSeller.controller;

import com.netzero.PrimeroBackSeller.apiPayload.BaseResponse;


import com.netzero.PrimeroBackSeller.service.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    @PostMapping(
            value = "/products",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}
    )
    public BaseResponse<Long> createProduct(
            @RequestPart(name = "sellerId") Long sellerId,
            @RequestPart(name = "content") String content,
            @RequestPart(name = "title") String title,
            @RequestPart(name = "price") Long price,
            @RequestPart(name = "salePrice") Long salePrice,
            @RequestPart(name = "thumbnailImage", required = false) MultipartFile thumbnailImage,
            @RequestPart(name = "detailImage", required = false) MultipartFile detailImage
    ) {
        return BaseResponse.onSuccess(productService.createProduct(sellerId, content, title, price, salePrice, thumbnailImage, detailImage));
    }

    @DeleteMapping("/products/{productId}")
    public BaseResponse<?> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return BaseResponse.onSuccess(null);
    }
}
