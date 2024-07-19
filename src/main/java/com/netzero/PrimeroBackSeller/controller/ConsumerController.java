package com.netzero.PrimeroBackSeller.controller;

import com.netzero.PrimeroBackSeller.dto.ConsumerDto;
import com.netzero.PrimeroBackSeller.service.ConsumerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/consumer")
public class ConsumerController {

    private static ConsumerService consumerService;

    @PostMapping("/add")
    public ResponseEntity<?> addConsumer(@RequestBody ConsumerDto.UserAddRequest userAddRequest) {
        consumerService.addUser(userAddRequest);
        return null;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchase() {
        return null;
    }

}
