package com.devhall.storeapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "admins")
public class Admin {

    public Admin() {
    }

    public Admin(Long id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public interface CreateAdmin {
    }

    public interface UpdateAdmin {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    @NotNull(groups = { CreateAdmin.class, UpdateAdmin.class })
    @NotEmpty(groups = { CreateAdmin.class, UpdateAdmin.class })
    private String name;

    @Column(name = "username", unique = true, nullable = false)
    @NotNull(groups = CreateAdmin.class)
    @NotEmpty(groups = CreateAdmin.class)
    private String username;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "password", unique = true, nullable = false)
    @NotNull(groups = { CreateAdmin.class, UpdateAdmin.class })
    @NotEmpty(groups = { CreateAdmin.class, UpdateAdmin.class })
    private String password;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
