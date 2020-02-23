package com.gubee.gubee.repository.product;

import com.gubee.gubee.model.entity.product.ProductTargetMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTargetMarketRepository extends JpaRepository<ProductTargetMarket, Integer> {
}
