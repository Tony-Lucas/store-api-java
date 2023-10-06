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

import com.devhall.storeapi.models.DeliverAdress;
import com.devhall.storeapi.services.DeliverAdressService;

import jakarta.validation.Valid;

@RequestMapping("/deliver-adress")
@RestController
@Validated
public class DeliverAdressController {
    
    @Autowired
    DeliverAdressService deliverAdressService;

    @GetMapping("/{id}")
    public ResponseEntity<DeliverAdress> getDeliverAdressById(@PathVariable Long id){
        DeliverAdress deliver_adress = this.deliverAdressService.getDeliverAdressById(id);
        return ResponseEntity.ok().body(deliver_adress);
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<DeliverAdress>> getAllDeliverAdressesByUser_id(@PathVariable Long user_id){
        List<DeliverAdress> deliver_adresses = this.deliverAdressService.getAllDeliverAdressesByUser_id(user_id);
        return ResponseEntity.ok().body(deliver_adresses);
    }

    @PostMapping
    public ResponseEntity<DeliverAdress> postDeliverAdress(@RequestBody @Valid DeliverAdress deliver_adress){
        DeliverAdress created_deliver_adress = this.deliverAdressService.createDeliverAdress(deliver_adress);
        return ResponseEntity.ok().body(created_deliver_adress);
    }

    @PutMapping
    public ResponseEntity<DeliverAdress> putDeliverAdress(@RequestBody @Valid DeliverAdress deliverAdress){
        DeliverAdress updated_deliver_adress = this.deliverAdressService.updateDeliverAdress(deliverAdress);
        return ResponseEntity.ok().body(updated_deliver_adress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeliverAdress(@PathVariable Long id){
        this.deliverAdressService.deleteDeliverAdress(id);
        return ResponseEntity.noContent().build();
    }
}
