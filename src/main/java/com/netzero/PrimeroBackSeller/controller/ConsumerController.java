package com.netzero.PrimeroBackSeller.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.netzero.PrimeroBackSeller.apiPayload.BaseResponse;
import com.netzero.PrimeroBackSeller.domain.Purchase;
import com.netzero.PrimeroBackSeller.dto.ConsumerDto;
import com.netzero.PrimeroBackSeller.dto.ProductDto;
import com.netzero.PrimeroBackSeller.service.ConsumerService;
import com.netzero.PrimeroBackSeller.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1/consumer")
@RequiredArgsConstructor
public class ConsumerController {

    private final ConsumerService consumerService;

    @PostMapping("/add")
    public BaseResponse<?> addConsumer(@RequestBody ConsumerDto.UserAddRequest userAddRequest) {
        consumerService.addUser(userAddRequest);
        return BaseResponse.onSuccess(null);
    }

    @PostMapping("/purchase")
    public BaseResponse<?> purchase(@RequestBody ProductDto.PurchaseListRequest purchaseRequestList) {
        List<Long> purchaseId = new ArrayList<>();
        for(ProductDto.PurchaseRequest pr: purchaseRequestList.getPurchaseRequestList()) {
            purchaseId.add(consumerService.purchase(pr));
        }

        return BaseResponse.onSuccess(purchaseId);
    }

    @PostMapping("/purchase/info")
    public BaseResponse<?> purchaseInfo(@RequestBody ConsumerDto.PurchaseInfoRequest purchaseInfoRequest) {
        List<Purchase> purchaseList = consumerService.getPurchaseInfo(purchaseInfoRequest);

        List<ConsumerDto.PurchaseInfo> purchaseInfo = purchaseList.stream().map((a)->{
            return ConsumerDto.PurchaseInfo.builder()
                    .id(a.getId())
                    .build();
        }).toList();

        return BaseResponse.onSuccess(ConsumerDto.GetPurchaseResponse.builder().productDtoList(purchaseInfo).build());
    }

    @PostMapping("/search")
    public BaseResponse<?> search(ProductDto.SearchRequest searchRequest) {
        ConsumerDto.GetProductResponse gpr = consumerService.searchProduct(searchRequest);

        return BaseResponse.onSuccess(gpr);
    }

    @PostMapping("/category")
    public BaseResponse<?> category(@PathVariable ProductDto.SearchRequest searchRequest) {
        ConsumerDto.GetProductResponse gpr = consumerService.searchByCategory(searchRequest);

        return BaseResponse.onSuccess(gpr);
    }

    @GetMapping("/product/all")
    public BaseResponse<?> getProduct() {
        return BaseResponse.onSuccess(consumerService.getProduct());
    }
}
