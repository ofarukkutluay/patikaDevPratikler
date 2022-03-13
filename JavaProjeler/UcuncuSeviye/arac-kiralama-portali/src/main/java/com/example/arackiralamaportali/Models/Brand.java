package com.example.arackiralamaportali.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Marka ismi boş olamaz!")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Car> cars;
}
