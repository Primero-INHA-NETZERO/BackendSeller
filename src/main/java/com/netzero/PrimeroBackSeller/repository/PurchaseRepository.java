package com.netzero.PrimeroBackSeller.repository;

import com.netzero.PrimeroBackSeller.domain.Product;
import com.netzero.PrimeroBackSeller.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
