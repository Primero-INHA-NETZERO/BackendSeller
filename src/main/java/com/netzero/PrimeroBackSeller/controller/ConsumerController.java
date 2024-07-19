package com.netzero.PrimeroBackSeller.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.netzero.PrimeroBackSeller.apiPayload.BaseResponse;
import com.netzero.PrimeroBackSeller.dto.ConsumerDto;
import com.netzero.PrimeroBackSeller.dto.ProductDto;
import com.netzero.PrimeroBackSeller.service.ConsumerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/consumer")
public class ConsumerController {

    private static ConsumerService consumerService;

    @PostMapping("/add")
    public BaseResponse<?> addConsumer(@RequestBody ConsumerDto.UserAddRequest userAddRequest) {
        consumerService.addUser(userAddRequest);
        return BaseResponse.onSuccess(null);
    }

    @PostMapping("/purchase")
    public BaseResponse<?> purchase(List<ProductDto.PurchaseRequest> purchaseRequestList) {
        for(ProductDto.PurchaseRequest pr: purchaseRequestList) {
            consumerService.purchase(pr);
        }

        return BaseResponse.onSuccess(null);
    }

}
