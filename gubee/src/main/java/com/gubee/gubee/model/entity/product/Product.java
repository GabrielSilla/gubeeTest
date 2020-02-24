package com.gubee.gubee.model.entity.product;

import com.gubee.gubee.core.entity.AbstractEntity;
import com.gubee.gubee.model.dto.product.ProductDTO;
import com.gubee.gubee.model.entity.stack.Stack;
import com.gubee.gubee.model.entity.targetMarket.TargetMarket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractEntity {

    @NotNull
    @NotBlank
    @Column(name = "name")
    public String productName;

    @NotNull
    @NotBlank
    public String description;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="product_stack",
            joinColumns=@JoinColumn(name="product_id"),
            inverseJoinColumns=@JoinColumn(name="stack_id"))
    public List<Stack> stack;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="product_target_market",
            joinColumns=@JoinColumn(name="product_id"),
            inverseJoinColumns=@JoinColumn(name="target_market_id"))
    public List<TargetMarket> targetMarket;

    public Product(ProductDTO productDTO, List<Stack> stacks, List<TargetMarket> targetMarkets) {
        this.setProductName(productDTO.getProductName());
        this.setDescription(productDTO.getDescription());
        this.setStack(stacks);
        this.setTargetMarket(targetMarkets);
    }
}
