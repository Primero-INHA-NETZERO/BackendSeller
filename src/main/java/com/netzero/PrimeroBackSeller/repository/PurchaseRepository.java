package com.netzero.PrimeroBackSeller.repository;

import com.netzero.PrimeroBackSeller.domain.Product;
import com.netzero.PrimeroBackSeller.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query
    List<Purchase> findByConsumerId(Long id);

}
