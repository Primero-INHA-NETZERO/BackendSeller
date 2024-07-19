package com.netzero.PrimeroBackSeller.repository;

import com.netzero.PrimeroBackSeller.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    List<Product> findAll();

    List<Product> findByTitle(String title);

    @Query("SELECT p FROM Product p WHERE p.title LIKE %:keyword%")
    List<Product> searchByKeyword(@Param("keyword") String keyword);
}
