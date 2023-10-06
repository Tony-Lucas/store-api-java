package com.devhall.storeapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devhall.storeapi.models.Product;
import com.devhall.storeapi.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
    
    @Autowired
    public ProductRepository productRepository;

    public Product findProductById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new RuntimeException(
            "produto não encontrado" + id
        ));
    }

    @Transactional
    public Product createProduct(Product obj){
        obj.setId(null);
        obj = this.productRepository.save(obj);
        return obj;
    }

    @Transactional
    public Product updateProduct(Product obj){
        Product newObj = findProductById(obj.getId());
        newObj.setName(obj.getName());
        newObj.setDescription(obj.getDescription());
        newObj.setImg_name(obj.getImg_name());
        newObj.setImg_url(obj.getImg_url());
        newObj.setPrice(obj.getPrice());
        newObj.setResale_price(obj.getResale_price());
        newObj = this.productRepository.save(newObj);
        return newObj;
    }

    public void deleteProduct(Long id){
        findProductById(id);
        try {
            this.productRepository.deleteById(id);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
