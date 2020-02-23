package com.gubee.gubee.service.targetMarket;

import com.gubee.gubee.model.entity.targetMarket.TargetMarket;
import com.gubee.gubee.repository.targetMarket.TargetMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetMarketService {

    final TargetMarketRepository targetMarketRepository;

    @Autowired
    public TargetMarketService(TargetMarketRepository targetMarketRepository) {
        this.targetMarketRepository = targetMarketRepository;
    }

    public List<TargetMarket> getAll() { return targetMarketRepository.findAll(); }
    public List<TargetMarket> saveAll(List<TargetMarket> targetMarkets) { return targetMarketRepository.saveAll(targetMarkets); }
}
