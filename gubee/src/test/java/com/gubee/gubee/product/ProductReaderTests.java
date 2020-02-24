package com.gubee.gubee.product;

import com.gubee.gubee.core.service.ConfigService;
import com.gubee.gubee.core.service.ProductReaderService;
import com.gubee.gubee.model.dto.product.ProductDTO;
import com.gubee.gubee.model.entity.product.Product;
import com.gubee.gubee.model.entity.stack.Stack;
import com.gubee.gubee.model.entity.targetMarket.TargetMarket;
import com.gubee.gubee.service.product.ProductService;
import com.gubee.gubee.service.stack.StackService;
import com.gubee.gubee.service.targetMarket.TargetMarketService;
import com.gubee.gubee.util.JsonReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProductReaderTests {

    @InjectMocks
    ProductReaderService productReaderService;

    @Mock
    StackService stackService;

    @Mock
    TargetMarketService targetMarketService;

    @Mock
    ConfigService configService;

    @Mock
    ProductService productService;

    @Test
    public void test_ReadJsonData_ShouldGetAllItems() throws IOException {
        List<ProductDTO> products = JsonReader.readProductJson();
        Assert.notEmpty(products, "Should have at least 3 items");
    }

    @Test
    public void test_PersistRepeatedJsonData_ShouldExcludeRepeatedProduct() throws IOException {
        ProductDTO productDTO1 = new ProductDTO("Product", "Test", Arrays.asList("Test1", "Test2"), Arrays.asList("Test1", "Test2"));
        ProductDTO productDTO2 = new ProductDTO("Product", "Test", Arrays.asList("Test1", "Test2"), Arrays.asList("Test1", "Test2"));
        List<ProductDTO> productDTOList = Arrays.asList(productDTO1, productDTO2);

        Stack stack1 = new Stack("Test1");
        Stack stack2 = new Stack("Test2");
        List<Stack> stacks = Arrays.asList(stack1, stack2);

        TargetMarket targetMarket1 = new TargetMarket("Test1");
        TargetMarket targetMarket2 = new TargetMarket("Test2");
        List<TargetMarket> targetMarkets = Arrays.asList(targetMarket1, targetMarket2);

        List<Product> productList = productReaderService.persistProduct(productDTOList, stacks, targetMarkets);
        Assert.isTrue(productList.size() == 1, "Should remove the duplicate item");
    }
}
