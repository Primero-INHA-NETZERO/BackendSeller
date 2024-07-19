package com.netzero.PrimeroBackSeller.controller;

import com.netzero.PrimeroBackSeller.apiPayload.BaseResponse;
import com.netzero.PrimeroBackSeller.domain.Seller;
import com.netzero.PrimeroBackSeller.dto.SellerDTO;
import com.netzero.PrimeroBackSeller.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.netzero.PrimeroBackSeller.dto.SellerDTO.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SellerController {

    private final SellerService sellerService;

    @GetMapping("/sellers/{sellerId}")
    public BaseResponse<?> getSeller(@PathVariable Long sellerId) {
        return BaseResponse.onSuccess(sellerService.getSeller(sellerId));
    }

    @GetMapping("/sellers")
    public BaseResponse<?> getSellerList() {
        List<Seller> sellers = sellerService.getSellerList();
        return BaseResponse.onSuccess(sellers);
    }

    public BaseResponse<?> createSeller() {

        return BaseResponse.onSuccess(null);
    }

    @PatchMapping("/sellers")
    public BaseResponse<?> updateSeller(@RequestBody UpdateSellerRequest updateSellerRequest) {
        return BaseResponse.onSuccess(sellerService.updateSeller(updateSellerRequest));
    }

    public BaseResponse<?> deleteSeller() {
        return BaseResponse.onSuccess(null);
    }
}
