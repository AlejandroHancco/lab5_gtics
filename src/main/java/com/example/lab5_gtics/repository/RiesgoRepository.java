package com.example.lab5_gtics.repository;


import com.example.lab5_gtics.entity.Riesgo;
import com.example.lab5_gtics.entity.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiesgoRepository extends JpaRepository<Riesgo, Integer> {
}