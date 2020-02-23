package com.gubee.gubee.repository.targetMarket;

import com.gubee.gubee.model.entity.targetMarket.TargetMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetMarketRepository extends JpaRepository<TargetMarket, Integer> {
}
