package com.miniecommerce.miniecommerce.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="user")
@Cacheable
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @EqualsAndHashCode.Include
    private String id;

    private String name;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="productuser", joinColumns={@JoinColumn(name="userId")}, inverseJoinColumns={@JoinColumn(name="productId")})
    private List<Product> favorites;
}
