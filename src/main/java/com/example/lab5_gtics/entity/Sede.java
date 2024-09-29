package com.example.lab5_gtics.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Sedes")
public class Sede {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSedes", nullable = false)
    private Integer idSedes;

    @Column(name = "nombreSede", length = 20)
    private String nombreSede;

    public Integer getIdSedes() {
        return idSedes;
    }

    public void setIdSedes(Integer idSedes) {
        this.idSedes = idSedes;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }
}