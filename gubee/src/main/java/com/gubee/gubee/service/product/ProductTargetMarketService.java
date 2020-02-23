package com.gubee.gubee.service.product;

import com.gubee.gubee.model.entity.product.ProductTargetMarket;
import com.gubee.gubee.repository.product.ProductTargetMarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTargetMarketService {

    final ProductTargetMarketRepository productTargetMarketRepository;

    @Autowired
    public ProductTargetMarketService(ProductTargetMarketRepository productTargetMarketRepository) {
        this.productTargetMarketRepository = productTargetMarketRepository;
    }

    public void saveAll(List<ProductTargetMarket> productTargetMarkets) {
        productTargetMarketRepository.saveAll(productTargetMarkets);
    }
}
