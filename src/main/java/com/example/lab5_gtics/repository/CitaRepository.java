package com.example.lab5_gtics.repository;


import com.example.lab5_gtics.dto.CitaporArea;
import com.example.lab5_gtics.dto.CitaporProfesional;
import com.example.lab5_gtics.dto.CitaporSede;
import com.example.lab5_gtics.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
    @Query("SELECT c FROM Cita c WHERE (:idprofesional = 0 OR c.profesional.idProfesionales = :idprofesional) AND (:idarea = 0  OR c.area.idAreas = :idarea) AND (:idfecha = 0 OR c.fecha.idFechas = :idfecha) AND (:idriesgo = 0 OR c.riesgo.idRiesgos = :idriesgo)  AND (:idsede = 0 OR c.sede.idSedes = :idsede)")
    List<Cita> filtradoQuery(@Param("idprofesional") Integer  idprofesional, @Param("idarea") Integer  idarea, @Param("idfecha") Integer  idfecha,@Param("idriesgo") Integer  idriesgo,@Param("idsede") Integer  idsede);


    @Query(value = "SELECT s.nombreSede as sede, COUNT(*) as cantidad " +
            "FROM Citas c " +
            "JOIN Sedes s ON c.idSede = s.idSedes " +
            "GROUP BY s.nombreSede", nativeQuery = true)
    List<CitaporSede> getCitasporSede();

    @Query(value = "SELECT p.nombre as profesional, COUNT(*) as cantidad " +
            "FROM Citas c " +
            "JOIN Profesionales p ON c.idProfesional = p.idProfesionales " +
            "GROUP BY p.nombre", nativeQuery = true)
    List<CitaporProfesional> getCitasporProfesional();

    @Query(value = "SELECT a.nombreArea as area, COUNT(*) as cantidad " +
            "FROM Citas c " +
            "JOIN Areas a ON c.idArea = a.idAreas " +
            "GROUP BY a.nombreArea", nativeQuery = true)
    List<CitaporArea> getCitasporArea();
}