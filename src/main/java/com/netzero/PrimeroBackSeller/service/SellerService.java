package com.netzero.PrimeroBackSeller.service;

import com.netzero.PrimeroBackSeller.apiPayload.code.status.ErrorStatus;
import com.netzero.PrimeroBackSeller.apiPayload.exception.SellerException;
import com.netzero.PrimeroBackSeller.domain.Seller;
import com.netzero.PrimeroBackSeller.dto.SellerDTO;
import com.netzero.PrimeroBackSeller.dto.SellerDTO.CreateSellerRequest;
import com.netzero.PrimeroBackSeller.dto.SellerDTO.UpdateSellerRequest;
import com.netzero.PrimeroBackSeller.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SellerService {
    private final SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Long getSeller(Long id) {
        Seller seller = sellerRepository.findById(id).orElseThrow(()-> new SellerException(ErrorStatus._NOT_FOUND_SELLER));
        return seller.getId();
    }

    @Transactional(readOnly = true)
    public List<Seller> getSellerList() {
        return sellerRepository.findAll();
    }

    public Long updateSeller(UpdateSellerRequest updateSellerRequest) {
        Seller seller = sellerRepository.findById(updateSellerRequest.getSellerId()).orElseThrow(()-> new SellerException(ErrorStatus._NOT_FOUND_SELLER));
        Seller updatedSeller = sellerRepository.save(seller);
        return updatedSeller.getId();
    }

    public Long createSeller(CreateSellerRequest createSellerRequest) {
        Seller seller = Seller.builder()
                .username(createSellerRequest.getUsername())
                .build();
        sellerRepository.save(seller);
        return seller.getId();
    }

    public void deleteSeller(Long sellerId) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(()-> new SellerException(ErrorStatus._NOT_FOUND_SELLER));
        sellerRepository.delete(seller);
    }
}
