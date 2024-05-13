package com.sena.airbnbclone.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    public void updateName(String name) {
        this.setName(name);
    }

    public void updateLastName(String lastName) {
        this.setLastName(lastName);
    }

    public void updateAddress(Address address) {
        this.setAddress(address);
    }
}
