package com.sena.airbnbclone.entities;

import com.sena.airbnbclone.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "lodging_id", nullable = false)
    private Lodging lodging;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_by", nullable = true)
    private String updatedBy;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "scheduled_date", nullable = false)
    private Date scheduledDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public void rescheduleBooking(Date newDate) {
        this.setScheduledDate(newDate);
    }

    public void cancelBooking() {
        this.setStatus(Status.CANCELLED);
    }
}
