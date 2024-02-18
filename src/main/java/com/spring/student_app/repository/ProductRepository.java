package com.spring.student_app.repository;

import com.spring.student_app.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByNameContains(String mc);
    List<Product> findByPriceGreaterThan(double price);
    @Query("select p from Product p where p.price>:x")
    List<Product> searchByPrice(@Param("x") double price);

}
