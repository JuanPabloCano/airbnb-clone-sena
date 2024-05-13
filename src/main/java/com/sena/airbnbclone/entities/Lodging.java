package com.sena.airbnbclone.entities;

import com.sena.airbnbclone.enums.LodgingType;
import com.sena.airbnbclone.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "lodging")
public class Lodging {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private LodgingType type;

    @Column(name = "rooms", nullable = false)
    private int rooms;

    @Column(name = "available_rooms", nullable = false)
    private int availableRooms;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "night_price", nullable = false)
    private double nightPrice;

    @OneToOne(mappedBy = "lodging", cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "lodging")
    private List<Booking> bookings;

    public void updateNightPrice(double price) {
        this.setNightPrice(price);
    }

    public void updateStatus(Status status) {
        this.setStatus(status);
    }

    public void updateAvailableRooms(int rooms) {
        this.setRooms(rooms);
    }

    public void updateName(String name) {
        this.setName(name);
    }
}
