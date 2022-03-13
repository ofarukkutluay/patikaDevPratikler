package com.example.arackiralamaportali.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "company_cars")
public class CompanyCar {

    @EmbeddedId
    private CompanyCarKey id;


    @ManyToOne()
    @MapsId("companyId")
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company company;

    @ManyToOne()
    @MapsId("carId")
    @JoinColumn(name = "car_id",referencedColumnName = "id")
    private Car car;


}
