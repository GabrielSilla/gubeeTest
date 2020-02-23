package com.gubee.gubee.model.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDTO {
    public String productName;
    public String description;
    public List<String> targetMarket;
    public List<String> stack;
}