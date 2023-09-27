package com.devhall.storeapi.models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

@Entity
@Table(name = "products")
public class Product {

    public Product() {
    }

    public Product(Long id, String name, String description, String resale_price, String price, String img_name,
            String img_url, List<Color> colors) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.resale_price = resale_price;
        this.price = price;
        this.img_name = img_name;
        this.img_url = img_url;
        this.colors = colors;
    }

    public interface CreateProduct {
    }

    public interface UpdateProduct {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull(groups = { CreateProduct.class, UpdateProduct.class })
    @NotEmpty(groups = { CreateProduct.class, UpdateProduct.class })
    private String name;

    @Column(name = "description")
    @Null(groups = { CreateProduct.class, UpdateProduct.class })
    @NotEmpty(groups = { CreateProduct.class, UpdateProduct.class })
    private String description;

    @Column(name = "resalePrice")
    @NotNull(groups = { CreateProduct.class, UpdateProduct.class })
    @NotEmpty(groups = { CreateProduct.class, UpdateProduct.class })
    private String resale_price;

    @Column(name = "price")
    @NotNull(groups = { CreateProduct.class, UpdateProduct.class })
    @NotEmpty(groups = { CreateProduct.class, UpdateProduct.class })
    private String price;

    @Column(name = "imgName", nullable = true)
    @Null(groups = { CreateProduct.class, UpdateProduct.class })
    @NotEmpty(groups = { CreateProduct.class, UpdateProduct.class })
    private String img_name;

    @Column(name = "imgUrl", nullable = true)
    @Null(groups = { CreateProduct.class, UpdateProduct.class })
    @NotEmpty(groups = { CreateProduct.class, UpdateProduct.class })
    private String img_url;

    @OneToMany(mappedBy = "product")
    private List<Color> colors = new ArrayList<Color>();

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResale_price() {
        return this.resale_price;
    }

    public void setResale_price(String resale_price) {
        this.resale_price = resale_price;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgName() {
        return this.img_name;
    }

    public void setImgName(String img_name) {
        this.img_name = img_name;
    }

    public String getImgUrl() {
        return this.img_url;
    }

    public void setImgUrl(String img_url) {
        this.img_url = img_url;
    }

    public String getImg_name() {
        return this.img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }

    public String getImg_url() {
        return this.img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public List<Color> getColors() {
        return this.colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

}
