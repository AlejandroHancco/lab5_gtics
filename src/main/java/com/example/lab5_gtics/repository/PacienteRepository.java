package com.example.lab5_gtics.repository;


import com.example.lab5_gtics.entity.Paciente;
import com.example.lab5_gtics.entity.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Paciente findByDni(String dni);
}