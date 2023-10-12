package com.devhall.storeapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devhall.storeapi.models.User;
import com.devhall.storeapi.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id){
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("asdasdasdasd"));
    }

    @Transactional
    public User createUser(User obj){
        obj.setId(null);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(5);
        String hashPassword = bCryptPasswordEncoder.encode(obj.getPassword());
        System.out.println(hashPassword);
        obj.setPassword(hashPassword);
        obj = this.userRepository.save(obj);
        return obj;
    }

    @Transactional
    public User updateUser(User obj){
        User newObj = findById(obj.getId());
        newObj.setName(obj.getName());
        return obj;
    }

    public void deleteUser(Long id){
        findById(id);
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel excluir");
        }
    }

}
