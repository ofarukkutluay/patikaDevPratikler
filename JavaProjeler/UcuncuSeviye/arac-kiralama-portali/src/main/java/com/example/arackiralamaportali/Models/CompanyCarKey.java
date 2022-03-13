package com.example.arackiralamaportali.Models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class CompanyCarKey implements Serializable {
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "car_id")
    private int carId;
}
