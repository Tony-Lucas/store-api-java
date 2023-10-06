package com.devhall.storeapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devhall.storeapi.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
    
    List<Contact> findByUser_id(Long id);
}
