package com.devhall.storeapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devhall.storeapi.models.Color;
import com.devhall.storeapi.services.ColorService;

import jakarta.validation.Valid;

@RequestMapping("/color")
@RestController
@Validated
public class ColorController {
    
    @Autowired
    private ColorService colorService;

    @GetMapping("/byUser/{user_id}")
    public ResponseEntity<List<Color>> getAllColorsByUser_id(@PathVariable Long user_id){
        List<Color> colors = this.colorService.getAllColorsByUser_id(user_id);
        return ResponseEntity.ok().body(colors);
    }
    
    @PostMapping
    public ResponseEntity<Color> createColor(@RequestBody @Valid Color color){
        Color obj = this.colorService.createColor(color);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping
    public ResponseEntity<Color> updateColor(@RequestBody Color color){
        Color obj = this.colorService.updateColor(color);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColor(@PathVariable Long id){
        this.colorService.deleteColor(id);
        return ResponseEntity.noContent().build();
    }
}
