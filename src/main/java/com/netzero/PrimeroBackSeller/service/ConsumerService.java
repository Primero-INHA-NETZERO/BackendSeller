package com.netzero.PrimeroBackSeller.service;

import com.netzero.PrimeroBackSeller.domain.Consumer;
import com.netzero.PrimeroBackSeller.domain.Product;
import com.netzero.PrimeroBackSeller.dto.ConsumerDto;
import com.netzero.PrimeroBackSeller.dto.ProductDto;
import com.netzero.PrimeroBackSeller.repository.ConsumerRepository;
import com.netzero.PrimeroBackSeller.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerService {
    private static ConsumerRepository consumerRepository;
    private static ProductRepository productRepository;

    public void addUser(ConsumerDto.UserAddRequest userAddRequest) {
        consumerRepository.save(Consumer.builder()
                .username(userAddRequest.getUsername())
                .build());
    }

    public ConsumerDto.GetProductResponse getProduct() {
        List<Product> productList = new ArrayList<>();

        productList = productRepository.findAll();
        return ConsumerDto.GetProductResponse.builder()
                .productList(productList)
                .build();
    }

    public ConsumerDto.GetProductResponse searchProduct(ProductDto.SearchRequest searchRequest) {
        List<Product> productList = new ArrayList<>();

        productList = productRepository.searchByKeyword(searchRequest.getKeyword());
        return ConsumerDto.GetProductResponse.builder()
                .productList(productList)
                .build();
    }
}
