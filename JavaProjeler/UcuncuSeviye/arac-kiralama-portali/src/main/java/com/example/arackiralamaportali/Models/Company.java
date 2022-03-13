package com.example.arackiralamaportali.Models;


import lombok.Data;

import javax.persistence.*;
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
    private String name;

    @Column(name = "tax_number")
    private long taxNumber;

    @Column(name = "tax_administration")
    private String taxAdministration;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "company")
    private List<CompanyCar> companyCars;

}
