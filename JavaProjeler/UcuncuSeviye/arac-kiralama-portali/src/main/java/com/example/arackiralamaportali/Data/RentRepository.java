package com.example.arackiralamaportali.Data;

import com.example.arackiralamaportali.Models.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent,Integer> {
}
