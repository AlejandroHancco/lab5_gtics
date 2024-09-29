package com.example.lab5_gtics.repository;

import com.example.lab5_gtics.dto.CancionesporTipo;
import com.example.lab5_gtics.entity.Canciones;
import com.example.lab5_gtics.entity.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CancionesRepository extends JpaRepository<Canciones, Integer> {
    @Query("SELECT c FROM Canciones c WHERE c.tipoCancion = 1")
    List<Canciones> findCancionesAlegres();

    @Query("SELECT c FROM Canciones c WHERE c.tipoCancion = 2")
    List<Canciones> findCancionesTristes();

    @Query("SELECT COUNT(c) FROM Canciones c WHERE c.tipoCancion = 1")
    Integer countCancionesAlegres();
    @Query("SELECT COUNT(c) FROM Canciones c WHERE c.tipoCancion = 2")
    Integer countCancionesTristes();

    @Query("SELECT COUNT(c) FROM Canciones c WHERE c.tipoCancion = 1")
    List<CancionesporTipo> countCancionesTipo(int tipo);



}