package com.netzero.PrimeroBackSeller.service;

import com.netzero.PrimeroBackSeller.apiPayload.exception.GeneralException;
import com.netzero.PrimeroBackSeller.domain.Consumer;
import com.netzero.PrimeroBackSeller.domain.Product;
import com.netzero.PrimeroBackSeller.domain.Purchase;
import com.netzero.PrimeroBackSeller.dto.ConsumerDto;
import com.netzero.PrimeroBackSeller.dto.ProductDto;
import com.netzero.PrimeroBackSeller.repository.ConsumerRepository;
import com.netzero.PrimeroBackSeller.repository.ProductRepository;
import com.netzero.PrimeroBackSeller.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsumerService {
    private static ConsumerRepository consumerRepository;
    private static ProductRepository productRepository;
    private static PurchaseRepository purchaseRepository;

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

    public void purchase(ProductDto.PurchaseRequest pr) {
        Optional<Consumer> consumer =  consumerRepository.findById(pr.getConsumerId());
        Optional<Product> product = productRepository.findById(pr.getProductId());
        if(consumer.get() == null || product.get() == null) {
            throw new GeneralException(null);
        }

        purchaseRepository.save(Purchase.builder()
                .consumer(consumer.get())
                .product(product.get())
                .build());
    }
}
