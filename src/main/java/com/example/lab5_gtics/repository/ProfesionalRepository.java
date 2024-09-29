package com.example.lab5_gtics.repository;

import com.example.lab5_gtics.entity.Area;
import com.example.lab5_gtics.entity.Fecha;
import com.example.lab5_gtics.entity.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Integer> {

    @Query("SELECT p FROM Profesional p LEFT JOIN Fecha f ON p.idProfesionales = f.profesional.idProfesionales " +
            "WHERE (:idarea = 0 OR p.area.idAreas = :idarea) " +
            "AND (:idFechas = 0 OR f.idFechas = :idFechas) " +
            "AND (:idSede = 0 OR p.sede.idSedes = :idSede)")
    List<Profesional> findProfesionalesByAreaAndFechaAndSede(@Param("idarea") Integer idarea,
                                                             @Param("idFechas") Integer idFechas,
                                                             @Param("idSede") Integer idSede);

}