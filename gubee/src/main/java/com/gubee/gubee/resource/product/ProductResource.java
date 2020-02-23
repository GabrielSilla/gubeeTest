package com.gubee.gubee.resource.product;

import com.gubee.gubee.model.dto.product.ProductFilterDTO;
import com.gubee.gubee.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductResource {

    final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/filter")
    public ResponseEntity<?> filterProducts(ProductFilterDTO productFilterDTO) {
        return ResponseEntity.ok(productService.getProductsByFilter(productFilterDTO));
    }
}
