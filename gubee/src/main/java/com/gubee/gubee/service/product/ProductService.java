package com.gubee.gubee.service.product;

import com.gubee.gubee.core.service.ProductReaderService;
import com.gubee.gubee.model.dto.product.ProductDTO;
import com.gubee.gubee.model.dto.product.ProductFilterDTO;
import com.gubee.gubee.model.entity.product.Product;
import com.gubee.gubee.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.gubee.gubee.util.FunctionUtils.isNullOrEmpty;

@Service
public class ProductService {

    final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) throws IOException {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByFilter(ProductFilterDTO productDTO) {
        return productRepository.findProductsByFilter(isNullOrEmpty(productDTO.getProductName()) ? "" : productDTO.getProductName(),
                                                      isNullOrEmpty(productDTO.getDescription()) ? "" : productDTO.getDescription(),
                                                      isNullOrEmpty(productDTO.getStack()) ? null : productDTO.getStack(),
                                                      isNullOrEmpty(productDTO.getTargetMarket()) ? null : productDTO.getTargetMarket());
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> saveAll(List<Product> productList) { return productRepository.saveAll(productList); }
}
