package com.gubee.gubee.model.entity.targetMarket;

import com.gubee.gubee.core.entity.AbstractEntity;
import com.gubee.gubee.model.entity.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "target_market")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TargetMarket extends AbstractEntity {
    @NotNull
    private String name;
}
