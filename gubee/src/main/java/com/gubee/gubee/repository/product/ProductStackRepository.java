package com.gubee.gubee.repository.product;

import com.gubee.gubee.model.entity.product.ProductStack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStackRepository extends JpaRepository<ProductStack, Integer> {
}
