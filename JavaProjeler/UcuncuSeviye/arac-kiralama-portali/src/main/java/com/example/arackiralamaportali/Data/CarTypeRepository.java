package com.example.arackiralamaportali.Data;

import com.example.arackiralamaportali.Models.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType,Integer> {
}
