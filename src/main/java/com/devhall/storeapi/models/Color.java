package com.devhall.storeapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "colors")
public class Color {

    public Color() {
    }

    public Color(Long id, String hex, String rgb, Product product) {
        this.id = id;
        this.hex = hex;
        this.rgb = rgb;
        this.product = product;
    }

    public interface CreateColor {
    }

    public interface UpdateColor {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hex")
    @NotNull(groups = { CreateColor.class, UpdateColor.class })
    private String hex;

    @Column(name = "rgb")
    @NotNull(groups = { CreateColor.class, UpdateColor.class })
    private String rgb;

    @ManyToOne()
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    private Product product;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHex() {
        return this.hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getRgb() {
        return this.rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    public Product getProducts() {
        return this.product;
    }

    public void setProducts(Product products) {
        this.product = products;
    }

}
