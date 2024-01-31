package com.Inventory_Management_System.Inventory_Management_System.repository;

import com.Inventory_Management_System.Inventory_Management_System.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query ("FROM Product P WHERE P.quantity >= ?1 AND P.quantity <= ?2 AND P.price >=?3 AND P.price <= ?4")
    List<Product> advanceSearchWithoutName( Integer minQuantity, Integer maxQuantity, Double minPrice, Double maxPrice);
    @Query ("FROM Product P WHERE P.productName LIKE ?1 AND P.quantity >= ?2 AND P.quantity <= ?3 AND P.price >=?4 AND P.price <= ?5")
    List<Product> advanceSearchWithName( String productName,Integer minQuantity, Integer maxQuantity, Double minPrice, Double maxPrice);

}
