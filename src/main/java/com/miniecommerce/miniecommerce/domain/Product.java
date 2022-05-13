package com.miniecommerce.miniecommerce.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.cache.annotation.Cacheable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@GenericGenerator(name = "UUID", strategy = "com.miniecommerce.miniecommerce.util.PrimaryKeyGenerator")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Cacheable
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @EqualsAndHashCode.Include
    private String id;

    private String name;

    private String description;

    private double price;
}
