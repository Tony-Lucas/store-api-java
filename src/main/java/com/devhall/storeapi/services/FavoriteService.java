package com.devhall.storeapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devhall.storeapi.models.Favorite;
import com.devhall.storeapi.repositories.FavoriteRepository;

import jakarta.transaction.Transactional;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public Favorite findById(Long id){
        Optional<Favorite> favorite = this.favoriteRepository.findById(id);
        return favorite.orElseThrow(() -> new RuntimeException("Not found favorite"));
    }

    public Boolean VerifyIsFavorite(Long product_id) {

        Optional<Favorite> favorite = this.favoriteRepository.findByProduct_id(product_id);
        return favorite.isPresent();
    }

    @Transactional
    public Favorite createFavorite(Favorite favorite) {

        favorite.setId(null);
        Favorite createdFavorite = this.favoriteRepository.save(favorite);
        return createdFavorite;
    }

    public void deleteFavorite(Long id){
        findById(id);
        try {
            this.favoriteRepository.deleteById(id);
        } catch (Exception e) {
            
        }
    }

}
