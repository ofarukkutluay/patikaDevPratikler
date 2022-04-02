package com.example.arackiralamaportali.Data;

import com.example.arackiralamaportali.Models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
}
