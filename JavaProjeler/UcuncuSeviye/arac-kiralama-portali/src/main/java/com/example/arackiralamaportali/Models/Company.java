package com.example.arackiralamaportali.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Firma ismi boş olamaz!")
    private String name;

    @Column(name = "tax_number")
    @NotNull
    @Min(value = 11111 , message = "Vergi numarası minimum 5 haneden kısa olamaz!")
    private long taxNumber;

    @Column(name = "tax_administration")
    @NotBlank(message = "Vergi dairesi boş bırakılamaz!")
    private String taxAdministration;


    @ManyToOne()
    @JoinColumn(name = "city_id",referencedColumnName = "id")
    private City city;

    @OneToMany(mappedBy = "company")
    private List<Car> cars;

}
