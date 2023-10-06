package com.devhall.storeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devhall.storeapi.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
