package com.gubee.gubee.resource.targetMarket;

import com.gubee.gubee.service.targetMarket.TargetMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("target-market")
public class TargetMarketResource {

    final TargetMarketService targetMarketService;

    @Autowired
    public TargetMarketResource(TargetMarketService targetMarketService) {
        this.targetMarketService = targetMarketService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTargetMarkets() {
        return ResponseEntity.ok(targetMarketService.getAll());
    }
}

