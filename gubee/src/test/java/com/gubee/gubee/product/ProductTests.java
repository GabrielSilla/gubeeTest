package com.gubee.gubee.product;

import com.gubee.gubee.core.service.ConfigService;
import com.gubee.gubee.core.service.ProductReaderService;
import com.gubee.gubee.model.dto.product.ProductDTO;
import com.gubee.gubee.model.dto.product.ProductFilterDTO;
import com.gubee.gubee.model.entity.product.Product;
import com.gubee.gubee.model.entity.stack.Stack;
import com.gubee.gubee.model.entity.targetMarket.TargetMarket;
import com.gubee.gubee.repository.product.ProductCustomRepository;
import com.gubee.gubee.repository.product.ProductRepository;
import com.gubee.gubee.service.product.ProductService;
import com.gubee.gubee.service.stack.StackService;
import com.gubee.gubee.service.targetMarket.TargetMarketService;
import com.gubee.gubee.util.JsonReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProductTests {
    @Mock
    ProductRepository repository;

    @Mock
    ProductCustomRepository productCustomRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void test_FilterWithValidName_ShouldReturnAll() {
        Product product = new Product();
        List<Product> productList = Arrays.asList(product);

        ProductFilterDTO filter = new ProductFilterDTO();
        filter.setProductName("Gubee");
        filter.setDescription("");
        filter.setStack(Collections.emptyList());
        filter.setTargetMarket(Collections.emptyList());

        Mockito.when(productService.getProductsByFilter(filter)).thenReturn(productList);
        List<Product> result = this.productService.getProductsByFilter(filter);
        Assert.isTrue(result.size() == 1, "Should have 1 items");
    }

    @Test
    public void test_FilterWithNullProperties_ShouldReturnData() {
        Product product = new Product();
        List<Product> productList = Arrays.asList(product);

        ProductFilterDTO filter = new ProductFilterDTO();
        filter.setProductName(null);
        filter.setDescription(null);
        filter.setStack(null);
        filter.setTargetMarket(null);

        Mockito.when(productService.getProductsByFilter(filter)).thenReturn(productList);
        List<Product> result = this.productService.getProductsByFilter(filter);
        Assert.isTrue(result.size() == 1, "Should have 1 items");
    }

    @Test
    public void test_FilterWithFilledLists_ShouldReturnData() {
        Product product = new Product();
        List<Product> productList = Arrays.asList(product);

        ProductFilterDTO filter = new ProductFilterDTO();
        filter.setProductName("");
        filter.setDescription("");
        filter.setStack(Arrays.asList(1, 2, 3));
        filter.setTargetMarket(Arrays.asList(1, 2, 3));

        Mockito.when(productService.getProductsByFilter(filter)).thenReturn(productList);
        List<Product> result = this.productService.getProductsByFilter(filter);
        Assert.isTrue(result.size() == 1, "Should have 1 items");
    }
}
