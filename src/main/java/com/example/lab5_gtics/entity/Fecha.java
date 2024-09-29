package com.example.lab5_gtics.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
@Table(name = "Fechas")

public class Fecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFechas", nullable = false)
    private Integer idFechas;

    @Column(name = "fechaDisponibilidad", length = 20)
    private String fechaDisponibilidad;

    @ManyToOne
    @JoinColumn(name = "idProfesional")
    private Profesional profesional;

    public Integer getIdFechas() {
        return idFechas;
    }

    public void setIdFechas(Integer idFechas) {
        this.idFechas = idFechas;
    }
    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;}

    public String getFechaDisponibilidad() {
        LocalDate fecha = LocalDate.parse(fechaDisponibilidad); // Convertir String a LocalDate

        // Formatear la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        return fecha.format(formatter); // Devuelve la fecha en formato legible
    }

    public void setFechaDisponibilidad(String fechaDisponibilidad) {
        this.fechaDisponibilidad = fechaDisponibilidad;
    }


    }

