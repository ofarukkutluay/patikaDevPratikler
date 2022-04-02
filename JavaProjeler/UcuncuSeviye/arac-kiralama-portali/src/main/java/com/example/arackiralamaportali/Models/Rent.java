package com.example.arackiralamaportali.Models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "rents")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "car_id",referencedColumnName = "id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "start_rent")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startRent;

    @Column(name = "end_rent")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endRent;

    @Column(name = "is_reservation")
    private boolean isReservation;
}
