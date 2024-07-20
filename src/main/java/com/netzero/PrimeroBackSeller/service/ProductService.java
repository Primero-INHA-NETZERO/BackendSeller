package com.netzero.PrimeroBackSeller.service;

import com.netzero.PrimeroBackSeller.apiPayload.code.status.ErrorStatus;
import com.netzero.PrimeroBackSeller.apiPayload.exception.GeneralException;
import com.netzero.PrimeroBackSeller.domain.Product;
import com.netzero.PrimeroBackSeller.domain.Seller;

import com.netzero.PrimeroBackSeller.dto.ProductDto;
import com.netzero.PrimeroBackSeller.repository.ProductRepository;
import com.netzero.PrimeroBackSeller.repository.SellerRepository;
import com.netzero.PrimeroBackSeller.s3.AmazonS3Manager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;
    private final AmazonS3Manager s3Manager;

    public Long createProduct(Long sellerId, String title, String content, Long price, Long salePrice, MultipartFile thumbnatil, MultipartFile detail) {
        String thumbnailImageUrl = null;
        if (thumbnatil != null) {
            thumbnailImageUrl = s3Manager.uploadRecreationThumbnailImage(thumbnatil);
        }
        String detailUrl = null;
        if (thumbnatil != null) {
            detailUrl = s3Manager.uploadRecreationThumbnailImage(detail);
        }

        Seller seller = sellerRepository.findById(sellerId).orElseThrow(()-> new GeneralException(ErrorStatus._NOT_FOUND_SELLER));
        Product product = Product.builder()
                .content(content)
                .seller(seller)
                .title(title)
                .price(price)
                .salePrice(salePrice)
                .imageUrl(thumbnailImageUrl)
                .detailImageUrl(detailUrl)
                .build();
        productRepository.save(product);
        return product.getId();
    }

    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(()-> new GeneralException(ErrorStatus._NOT_FOUND_PRODUCT));
        productRepository.save(product);
    }
}
