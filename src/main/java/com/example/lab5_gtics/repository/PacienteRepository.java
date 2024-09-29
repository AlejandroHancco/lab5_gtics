package com.example.lab5_gtics.repository;


import com.example.lab5_gtics.dto.CitaporArea;
import com.example.lab5_gtics.dto.CitaporProfesional;
import com.example.lab5_gtics.dto.PacienteporRiesgo;
import com.example.lab5_gtics.entity.Paciente;
import com.example.lab5_gtics.entity.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Paciente findByDni(String dni);

    @Query(value = "SELECT r.idRiesgos as riesgo, COUNT(DISTINCT p.idPacientes) as cantidad " +
            "FROM Riesgos r " +  // Asegúrate de que la tabla Riesgos existe
            "LEFT JOIN Citas c ON r.idRiesgos = c.idRiesgo " +
            "LEFT JOIN Pacientes p ON c.idPaciente = p.idPacientes " +
            "GROUP BY r.idRiesgos", nativeQuery = true)
    List<PacienteporRiesgo> getPacienteporRiesgo();

}