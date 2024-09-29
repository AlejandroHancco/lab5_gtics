package com.example.lab5_gtics.repository;


import com.example.lab5_gtics.entity.Cita;
import com.example.lab5_gtics.entity.Riesgo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
}