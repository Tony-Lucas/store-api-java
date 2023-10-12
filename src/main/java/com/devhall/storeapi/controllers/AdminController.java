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

import com.devhall.storeapi.models.Admin;
import com.devhall.storeapi.services.AdminService;

import jakarta.validation.Valid;

@RequestMapping("/admin")
@RestController
@Validated
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @GetMapping("/{username}")
    public ResponseEntity<Admin> getAdminByUsername(@PathVariable String username){
        Admin admin = this.adminService.findByUsername(username);
        return ResponseEntity.ok().body(admin);
    }

    @PostMapping
    public ResponseEntity<Admin> postAdmin(@RequestBody @Valid Admin obj){
        Admin admin = this.adminService.createAdmin(obj);
        return ResponseEntity.ok().body(admin);
    }

    @PutMapping
    public ResponseEntity<Admin> putAdmin(@RequestBody @Valid Admin obj){
        Admin admin = this.adminService.updateAdmin(obj);
        return ResponseEntity.ok().body(admin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id){
        this.adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
