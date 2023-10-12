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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "deliver_adresses")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class DeliverAdress {

    public interface CreateAdress {
    }

    public interface UpdateAdress {
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


}
