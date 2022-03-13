package com.example.arackiralamaportali.Models;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @Column(name = "brand_id")
//    private int brandId;

    @Column(name = "plate")
    @NotEmpty(message = "Plaka bilgisi boş olamaz!")
    private String plate;

    @Column(name="km")
    @Min(value = 0,message = "Km bilgisi 0 dan küçük olamaz")
    private int km;

    @Column(name = "model_year")
    @Min(value=1769,message = "Model yılı arabanın icadından önce olamaz!")
    private int modelYear;

    @ManyToOne()
    @JoinColumn(name = "brand_id",referencedColumnName = "id")
    private Brand brand;

    @OneToMany(mappedBy = "car")
    private List<CompanyCar> companyCars;

}
