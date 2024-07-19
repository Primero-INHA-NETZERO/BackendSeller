package com.netzero.PrimeroBackSeller.repository;


import com.netzero.PrimeroBackSeller.domain.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
    List<Consumer> findByUsername(String username);

}
