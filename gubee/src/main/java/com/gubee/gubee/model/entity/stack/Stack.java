package com.gubee.gubee.model.entity.stack;

import com.gubee.gubee.core.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "stack")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stack extends AbstractEntity {
    @NotNull
    private String name;
}
