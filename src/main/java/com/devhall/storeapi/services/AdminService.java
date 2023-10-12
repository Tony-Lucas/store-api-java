package com.devhall.storeapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devhall.storeapi.models.Admin;
import com.devhall.storeapi.repositories.AdminRepository;

import jakarta.transaction.Transactional;

@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;

    public Admin findAdminById(Long id){
        Optional<Admin> admin = this.adminRepository.findById(id);
        return admin.orElseThrow(() -> new RuntimeException("Admin não encontrado"));
    }

    public Admin findByUsername(String username){
        Optional<Admin> admin = this.adminRepository.findByUsername(username);
        return admin.orElseThrow(() -> new RuntimeException("Admin não encontrado"));
    }

    @Transactional
    public Admin createAdmin(Admin obj){
        obj.setId(null);
        Admin admin = this.adminRepository.save(obj);
        return admin;
    }

    @Transactional
    public Admin updateAdmin(Admin obj){
        Admin newAdmin = findAdminById(obj.getId());
        newAdmin.setName(obj.getName());
        return newAdmin;
    }

    public void deleteAdmin(Long id){
        findAdminById(id);
        try {
            this.adminRepository.deleteById(id);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
