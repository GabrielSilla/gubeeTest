package com.gubee.gubee.core.service;

import com.gubee.gubee.core.entity.Config;
import com.gubee.gubee.model.dto.product.ProductDTO;
import com.gubee.gubee.model.entity.product.Product;
import com.gubee.gubee.model.entity.stack.Stack;
import com.gubee.gubee.model.entity.targetMarket.TargetMarket;
import com.gubee.gubee.service.product.ProductService;
import com.gubee.gubee.service.stack.StackService;
import com.gubee.gubee.service.targetMarket.TargetMarketService;
import com.gubee.gubee.util.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductReaderService {

    final ProductService productService;
    final StackService stackService;
    final TargetMarketService targetMarketService;
    final ConfigService configService;
    @Autowired
    public ProductReaderService(@Lazy ProductService productService, StackService stackService,
                                TargetMarketService targetMarketService, ConfigService configService) throws IOException {
        this.productService = productService;
        this.stackService = stackService;
        this.targetMarketService = targetMarketService;
        this.configService = configService;
        readProductsFromJson();
    }

    public List<ProductDTO> readProductsFromJson() throws IOException {
        Config config = configService.findConfigByKey("JSON_READED");

        if(config != null && "0".equals(config.getValue())) {
            List<ProductDTO> products = JsonReader.readProductJson();
            List<Product> productList = persistAllData(products);
            config.setValue("1");
            configService.updateConfig(config);
        }
        return null;
    }

    public List<Product> persistAllData(List<ProductDTO> products) {
        List<Stack> stacks = persistStacks(products);
        List<TargetMarket> targetMarkets = persistTargetMarkets(products);
        return productService.saveAll(persistProduct(products, stacks, targetMarkets));
    }

    public List<Stack> persistStacks(List<ProductDTO> products) {
        List<String> allStacks = new ArrayList<>();
        products.forEach(product -> {
            allStacks.addAll(product.stack.stream().filter(s -> !allStacks.contains(s)).collect(Collectors.toList()));
        });

        return stackService.saveAll(allStacks.stream()
                .map(stack -> new Stack(stack)).collect(Collectors.toList()));
    }

    public List<TargetMarket> persistTargetMarkets(List<ProductDTO> products) {
        List<String> allTargetMarkets = new ArrayList<>();
        products.forEach(product -> {
            allTargetMarkets.addAll(product.targetMarket.stream().filter(s -> !allTargetMarkets.contains(s)).collect(Collectors.toList()));
        });

        return targetMarketService.saveAll(allTargetMarkets.stream()
                .map(targetMarket -> new TargetMarket(targetMarket)).collect(Collectors.toList()));
    }

    public List<Product> persistProduct(List<ProductDTO> products, List<Stack> stacks, List<TargetMarket> targetMarkets) {
        List<Product> allProducts = new ArrayList<>();

        products.forEach(productDTO -> {
            List<Product> repeated = allProducts.stream().filter(product ->
                    product.getProductName().equalsIgnoreCase(productDTO.getProductName())).collect(Collectors.toList());
            if (repeated != null && !repeated.isEmpty()) {
                Product repeatedProduct = repeated.get(0);
                List<String> existentStack = repeatedProduct.getStack().stream().map(stack -> stack.getName()).collect(Collectors.toList());
                List<String> existentTargetMarkets = repeatedProduct.getTargetMarket().stream().map(targetMarket -> targetMarket.getName()).collect(Collectors.toList());

                List<Stack> productStacks = stacks.stream().filter(stack ->
                        productDTO.getStack().contains(stack.getName())
                        && !existentStack.contains(stack.getName())).collect(Collectors.toList());

                List<TargetMarket> productTargetMarket = targetMarkets.stream().filter(targetMarket ->
                        productDTO.getTargetMarket().contains(targetMarket.getName())
                                && !existentTargetMarkets.contains(targetMarket.getName())).collect(Collectors.toList());

                repeatedProduct.getStack().addAll(productStacks);
                repeatedProduct.getTargetMarket().addAll(productTargetMarket);
            } else {
                List<Stack> productStacks = stacks.stream().filter(stack ->
                        productDTO.getStack().contains(stack.getName())).collect(Collectors.toList());
                List<TargetMarket> productTargetMarket = targetMarkets.stream().filter(targetMarket ->
                        productDTO.getTargetMarket().contains(targetMarket.getName())).collect(Collectors.toList());
                allProducts.add(new Product(productDTO, productStacks, productTargetMarket));
            }
        });

        return allProducts;
    }
}
