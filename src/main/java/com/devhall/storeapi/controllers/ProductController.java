package com.devhall.storeapi.controllers;

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

import com.devhall.storeapi.models.Product;
import com.devhall.storeapi.models.Product.CreateProduct;
import com.devhall.storeapi.models.Product.UpdateProduct;
import com.devhall.storeapi.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
@Validated
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product obj = productService.findProductById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Validated(CreateProduct.class)
    public ResponseEntity<Void> createProduct(@Valid @RequestBody Product obj){
        this.productService.createProduct(obj);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    @Validated(UpdateProduct.class)
    public ResponseEntity<Void> updateProduct(@Valid @PathVariable Long id,@RequestBody Product obj){
        obj.setId(id);
        this.productService.updateProduct(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        this.productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
