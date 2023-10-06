package com.devhall.storeapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devhall.storeapi.models.Favorite;
import com.devhall.storeapi.services.FavoriteService;

import jakarta.validation.Valid;

@RequestMapping("/favorite")
@RestController
@Validated
public class FavoriteController {
    
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/{product_id}")
    public ResponseEntity<Boolean> verifyIsFavorite(@PathVariable Long product_id){
        Boolean favorite = this.favoriteService.VerifyIsFavorite(product_id);
        return ResponseEntity.ok().body(favorite);
    }

    @PostMapping
    public ResponseEntity<Void> postFavorite(@RequestBody @Valid Favorite favorite){
        this.favoriteService.createFavorite(favorite);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable Long id){
        this.deleteFavorite(id);
        return ResponseEntity.noContent().build();
    }

}
