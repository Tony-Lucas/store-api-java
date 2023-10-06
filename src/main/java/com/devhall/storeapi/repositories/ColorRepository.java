package com.devhall.storeapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devhall.storeapi.models.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color,Long> {
    
    List<Color> findByUser_id(Long user_id);

}
