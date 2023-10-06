package com.devhall.storeapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "deliver_adresses")
public class DeliverAdress {

    public interface CreateAdress {
    }

    public interface UpdateAdress {
    }

    public DeliverAdress(Long id, String zip_code, String street_adress, String complement, String area, String city,
            String state, Integer house_number, User user) {
        this.id = id;
        this.zip_code = zip_code;
        this.street_adress = street_adress;
        this.complement = complement;
        this.area = area;
        this.city = city;
        this.state = state;
        this.house_number = house_number;
        this.user = user;
    }

    public DeliverAdress() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "zip_code")
    @NotNull
    @NotEmpty
    @NotBlank
    private String zip_code;

    @Column(name = "street_adress")
    @NotNull
    @NotEmpty
    @NotBlank
    private String street_adress;

    @Column(name = "complement", nullable = true)
    private String complement;

    @Column(name = "area")
    @NotNull
    @NotEmpty
    @NotBlank
    private String area;

    @Column(name = "city")
    @NotNull
    @NotEmpty
    @NotBlank
    private String city;

    @Column(name = "state")
    @NotNull
    @NotEmpty
    @NotBlank
    private String state;

    @Column(name = "house_number")
    @NotNull
    @NotEmpty
    @NotBlank
    private Integer house_number;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZip_code() {
        return this.zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getStreet_adress() {
        return this.street_adress;
    }

    public void setStreet_adress(String street_adress) {
        this.street_adress = street_adress;
    }

    public String getComplement() {
        return this.complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getHouse_number() {
        return this.house_number;
    }

    public void setHouse_number(Integer house_number) {
        this.house_number = house_number;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
