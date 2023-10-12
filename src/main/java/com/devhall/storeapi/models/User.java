package com.devhall.storeapi.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = User.TABLE_NAME)
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public interface CreateUser {
    }

    public interface UpdateUser {
    }

    public static final String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull(groups = { CreateUser.class, UpdateUser.class },message = "not accepts null")
    @NotEmpty(groups = { CreateUser.class, UpdateUser.class },message = "not accepts empty string")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @NotNull(groups = CreateUser.class,message = "not accepts null")
    @NotEmpty(groups = CreateUser.class,message = "not accepts empty string")
    private String email;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "password", nullable = false,length = 100)
    @NotNull(groups = { CreateUser.class, UpdateUser.class },message = "not accepts null")
    @NotEmpty(groups = { CreateUser.class, UpdateUser.class },message = "not accepts empty string")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites = new ArrayList<Favorite>();

    @OneToMany(mappedBy = "user")
    private List<DeliverAdress> deliver_adresses = new ArrayList<DeliverAdress>();

    @OneToMany(mappedBy = "user")
    private List<Contact> contacts = new ArrayList<Contact>();

}

