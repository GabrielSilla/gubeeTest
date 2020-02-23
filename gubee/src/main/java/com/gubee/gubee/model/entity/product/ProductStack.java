package com.gubee.gubee.model.entity.product;

import com.gubee.gubee.core.entity.AbstractEntity;
import com.gubee.gubee.model.entity.targetMarket.TargetMarket;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product_stack")
@Getter
@Setter
public class ProductStack extends AbstractEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    Product product;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "stack",
            joinColumns = @JoinColumn(name = "stack_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    TargetMarket targetMarket;
}
