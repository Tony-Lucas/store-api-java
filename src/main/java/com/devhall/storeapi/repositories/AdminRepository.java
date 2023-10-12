package com.devhall.storeapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devhall.storeapi.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    
    Optional<Admin> findByUsername(String username);
}
