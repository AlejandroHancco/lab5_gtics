package com.example.lab5_gtics.entity;

import jakarta.persistence.*;

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

    public String getFechaDisponibilidad() {
        return fechaDisponibilidad;
    }

    public void setFechaDisponibilidad(String fechaDisponibilidad) {
        this.fechaDisponibilidad = fechaDisponibilidad;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }
}
