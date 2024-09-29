package com.example.lab5_gtics.repository;

import com.example.lab5_gtics.entity.Area;
import com.example.lab5_gtics.entity.Fecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FechaRepository extends JpaRepository<Fecha, Integer> {
}