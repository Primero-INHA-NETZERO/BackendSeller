package com.netzero.PrimeroBackSeller.service;

import com.netzero.PrimeroBackSeller.apiPayload.code.status.ErrorStatus;
import com.netzero.PrimeroBackSeller.apiPayload.exception.GeneralException;
import com.netzero.PrimeroBackSeller.domain.Product;
import com.netzero.PrimeroBackSeller.domain.Seller;

import com.netzero.PrimeroBackSeller.dto.ProductDto;
import com.netzero.PrimeroBackSeller.repository.ProductRepository;
import com.netzero.PrimeroBackSeller.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;

    public Long createProduct(ProductDto.CreateProductRequest createProductRequest) {
        Seller seller = sellerRepository.findById(createProductRequest.getSellerId()).orElseThrow(()-> new GeneralException(ErrorStatus._NOT_FOUND_SELLER));
        Product product = Product.builder()
                .content(createProductRequest.getContent())
                .seller(seller)
                .title(createProductRequest.getTitle())
                .price(createProductRequest.getPrice())
                .salePrice(createProductRequest.getSalePrice())
                .build();
        productRepository.save(product);
        return product.getId();
    }

    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(()-> new GeneralException(ErrorStatus._NOT_FOUND_PRODUCT));
        productRepository.save(product);
    }
}
