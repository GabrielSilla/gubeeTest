package com.gubee.gubee.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "config")
@Getter
@Setter
public class Config extends AbstractEntity {
    @Column(name = "config_key")
    public String key;

    @Column(name = "config_value")
    public String value;
}
