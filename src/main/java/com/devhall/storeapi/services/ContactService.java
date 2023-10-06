package com.devhall.storeapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devhall.storeapi.models.Contact;
import com.devhall.storeapi.repositories.ContactRepository;

import jakarta.transaction.Transactional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAllContactByUser_id(Long user_id) {
        List<Contact> contacts = this.contactRepository.findByUser_id(user_id);
        return contacts;
    }

    public Contact findContactById(Long id) {
        Optional<Contact> contact = this.contactRepository.findById(id);
        return contact.orElseThrow(() -> new RuntimeException("Contato nao encontrado"));
    }

    @Transactional
    public Contact createContact(Contact obj) {
        obj.setId(null);
        obj = this.contactRepository.save(obj);
        return obj;
    }

    @Transactional
    public Contact updateContact(Contact obj) {
        Contact newObj = findContactById(obj.getId());
        newObj.setPhone_number(obj.getPhone_number());
        newObj = this.contactRepository.save(newObj);
        return newObj;
    }

    public void deleteContact(Long id) {
        findContactById(id);
        try {
            this.contactRepository.deleteById(id);
        } catch (Exception e) {

        }
    }

}
