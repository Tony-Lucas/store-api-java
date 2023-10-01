package com.devhall.storeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devhall.storeapi.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
