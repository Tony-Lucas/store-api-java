package com.devhall.storeapi.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Nullable;
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
@Table(name = "products")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Product {

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
    @Nullable
    @NotEmpty(groups = { CreateProduct.class, UpdateProduct.class })
    private String description;

    @Column(name = "resale_price")
    @NotNull(groups = { CreateProduct.class, UpdateProduct.class })
    @NotEmpty(groups = { CreateProduct.class, UpdateProduct.class })
    private String resale_price;

    @Column(name = "price")
    @NotNull(groups = { CreateProduct.class, UpdateProduct.class })
    @NotEmpty(groups = { CreateProduct.class, UpdateProduct.class })
    private String price;

    @Column(name = "imgName", nullable = true)
    @Nullable
    private String img_name;

    @Column(name = "imgUrl", nullable = true)
    @Nullable
    private String img_url;

    @OneToMany(mappedBy = "product")
    private List<Color> colors = new ArrayList<Color>();

}
