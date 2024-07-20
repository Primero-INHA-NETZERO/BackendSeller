package com.netzero.PrimeroBackSeller.service;

import com.netzero.PrimeroBackSeller.apiPayload.code.status.ErrorStatus;
import com.netzero.PrimeroBackSeller.apiPayload.exception.ConsumerException;
import com.netzero.PrimeroBackSeller.apiPayload.exception.GeneralException;
import com.netzero.PrimeroBackSeller.apiPayload.exception.PurchaseException;
import com.netzero.PrimeroBackSeller.domain.Consumer;
import com.netzero.PrimeroBackSeller.domain.Product;
import com.netzero.PrimeroBackSeller.domain.Purchase;
import com.netzero.PrimeroBackSeller.dto.ConsumerDto;
import com.netzero.PrimeroBackSeller.dto.ProductDto;
import com.netzero.PrimeroBackSeller.repository.ConsumerRepository;
import com.netzero.PrimeroBackSeller.repository.ProductRepository;
import com.netzero.PrimeroBackSeller.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsumerService {
    private final ConsumerRepository consumerRepository;
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;

    public void addUser(ConsumerDto.UserAddRequest userAddRequest) {
        consumerRepository.save(Consumer.builder()
                .username(userAddRequest.getUsername())
                .build());
    }

    @Transactional(readOnly = true)
    public ConsumerDto.GetProductResponse getProduct() {
        List<Product> productList = productRepository.findsAlldsf();
        List<ConsumerDto.ProductResponseDTO> productDtoList = productList.stream().map((a)->ConsumerDto.ProductResponseDTO.builder().id(
                a.getId())
                .price(a.getPrice())
                .rate(a.getRate())
                .content(a.getContent())
                .title(a.getTitle())
                .imageUrl(a.getImageUrl())
                .category(a.getCategory())
                .viewCount(a.getViewCount())
                .detailImageUrl(a.getDetailImageUrl())
                .salePrice(a.getSalePrice()).build()).toList();

        return ConsumerDto.GetProductResponse.builder()
                .productDtoList(productDtoList)
                .build();
    }

    public ConsumerDto.GetProductResponse searchProduct(ProductDto.SearchRequest searchRequest) {
        List<Product> productList = new ArrayList<>();

        productList = productRepository.searchByKeyword(searchRequest.getKeyword());
        List<ConsumerDto.ProductResponseDTO> productDtoList = productList.stream().map((a)->ConsumerDto.ProductResponseDTO.builder().id(
                        a.getId())
                .price(a.getPrice())
                .rate(a.getRate())
                .content(a.getContent())
                .title(a.getTitle())
                .imageUrl(a.getImageUrl())
                .category(a.getCategory())
                .viewCount(a.getViewCount())
                .detailImageUrl(a.getDetailImageUrl())
                .salePrice(a.getSalePrice()).build()).toList();
        return ConsumerDto.GetProductResponse.builder()
                .productDtoList(productDtoList)
                .build();
    }


    public Long purchase(ProductDto.PurchaseRequest pr) {
        Consumer consumer =  consumerRepository.findById(pr.getConsumerId()).orElseThrow(()->{
            throw new PurchaseException(ErrorStatus._BAD_REQUEST);
        });
//        System.out.println("1");
        Product product = productRepository.findById(pr.getProductId()).orElseThrow(() -> {
            throw new ConsumerException(ErrorStatus._BAD_REQUEST);
        });

        return purchaseRepository.save(Purchase.builder()
                .consumer(consumer)
                .product(product)
                .build()).getId();
    }

    public ConsumerDto.GetProductResponse searchByCategory(ProductDto.SearchRequest searchRequest) {
        List<Product> productList = new ArrayList<>();

        productList = productRepository.searchByCategory(searchRequest.getKeyword());
        List<ConsumerDto.ProductResponseDTO> productDtoList = productList.stream().map((a)->ConsumerDto.ProductResponseDTO.builder().id(
                        a.getId())
                .price(a.getPrice())
                .rate(a.getRate())
                .content(a.getContent())
                .title(a.getTitle())
                .imageUrl(a.getImageUrl())
                .category(a.getCategory())
                .viewCount(a.getViewCount())
                .detailImageUrl(a.getDetailImageUrl())
                .salePrice(a.getSalePrice()).build()).toList();
        return ConsumerDto.GetProductResponse.builder()
                .productDtoList(productDtoList)
                .build();
    }

    public List<Purchase> getPurchaseInfo(ConsumerDto.PurchaseInfoRequest purchaseInfoRequest) {
        Consumer consumer = consumerRepository.findById(purchaseInfoRequest.getConsumerId()).orElseThrow(()-> new ConsumerException(ErrorStatus._BAD_REQUEST));
        return consumer.getPurchaseList();
    }
}
