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
@Table(name = "favorites")
public class Favorite {

    public interface CreateFavorite {
    }

    public interface UpdateFavorite {
    }

    public Favorite(Long id, Long productId, User user) {
        this.id = id;
        this.productId = productId;
        this.user = user;
    }

    public Favorite() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id", nullable = false, updatable = false)
    @NotNull
    @NotEmpty
    @NotBlank
    private Long productId;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
