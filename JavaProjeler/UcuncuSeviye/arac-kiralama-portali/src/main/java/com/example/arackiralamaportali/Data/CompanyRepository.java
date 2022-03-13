package com.example.arackiralamaportali.Data;

import com.example.arackiralamaportali.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
