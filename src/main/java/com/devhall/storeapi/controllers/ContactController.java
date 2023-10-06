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

import com.devhall.storeapi.models.Contact;
import com.devhall.storeapi.services.ContactService;

import jakarta.validation.Valid;

@RequestMapping("/contact")
@RestController
@Validated
public class ContactController {

    @Autowired
    private ContactService contactService;
    
    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<Contact>> getAllContactByUserId(@PathVariable Long user_id){

        List<Contact> obj = this.contactService.findAllContactByUser_id(user_id);

        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact){

        Contact newContact = this.contactService.createContact(contact);

        return ResponseEntity.ok().body(newContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@Valid @RequestBody Contact contact,@PathVariable Long id){

        Contact newContact = this.contactService.updateContact(contact);

        return ResponseEntity.ok().body(newContact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id){

        this.contactService.deleteContact(id);

        return ResponseEntity.noContent().build();
    }

}
