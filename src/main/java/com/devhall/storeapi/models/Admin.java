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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admins")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

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


}
