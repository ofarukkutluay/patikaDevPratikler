package com.example.arackiralamaportali.Models;



import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


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
    @NotBlank(message = "Plaka bilgisi boş olamaz!")
    private String plate;

    @Column(name="km")
    @Min(value = 0,message = "Km bilgisi 0 dan küçük olamaz")
    private int km;

    @Column(name = "model_year")
    @Min(value=1769,message = "Model yılı arabanın icadından önce olamaz!")
    private int modelYear;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name="price_validity_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate priceValidityDate;

    @ManyToOne()
    @JoinColumn(name="type",referencedColumnName = "id")
    private CarType type;

    @ManyToOne()
    @JoinColumn(name = "brand_id",referencedColumnName = "id")
    private Brand brand;

    @ManyToOne()
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company company;

}
