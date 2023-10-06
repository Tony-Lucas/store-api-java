package com.devhall.storeapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devhall.storeapi.models.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
    
    List<Favorite> findAllFavoritesByUser_id(Long user_id);
    Optional<Favorite> findByProduct_id(Long product_id);
}
