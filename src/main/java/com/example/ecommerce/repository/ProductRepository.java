package com.example.ecommerce.repository;

import com.example.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/// Repository will get all the functionality from JPA
/// JPA is a framework for persisting objects
/// The first argument inside <> is the class and the second is the primary key
public interface ProductRepository extends JpaRepository<Product, Long> {

    /// SELECT * FROM product WHERE name = ?
    List<Product> findByName(String name);

    /// SELECT * FROM product WHERE price BETWEEN ?1 AND ?2
    List<Product> findByPriceBetween(Double min, Double price);

    /// SELECT * FROM product WHERE price <= ?
    List<Product> findByPriceLessThan(Double price);

}
