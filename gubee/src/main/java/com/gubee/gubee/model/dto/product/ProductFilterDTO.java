package com.gubee.gubee.model.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductFilterDTO {
    public String productName;
    public String description;
    public List<Integer> targetMarket;
    public List<Integer> stack;
}
