package com.devhall.storeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devhall.storeapi.models.Product;
import java.util.Optional;



public interface ProductRepository extends JpaRepository<Product,Long> {
   
    Optional<Product> findById(Long id);

}
