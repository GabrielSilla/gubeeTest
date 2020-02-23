package com.gubee.gubee.service.product;

import com.gubee.gubee.model.entity.product.ProductStack;
import com.gubee.gubee.repository.product.ProductStackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductStackService {

    final ProductStackRepository productStackRepository;

    @Autowired
    public ProductStackService(ProductStackRepository productStackRepository) {
        this.productStackRepository = productStackRepository;
    }

    public void saveAll(List<ProductStack> productStackList) {
        productStackRepository.saveAll(productStackList);
    }
}
