package com.example.lab5_gtics.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Areas")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAreas", nullable = false)
    private Integer idAreas;

    @Column(name = "nombreArea", length = 45)
    private String nombreArea;


    public Integer getIdAreas() {
        return idAreas;
    }

    public void setIdAreas(Integer idAreas) {
        this.idAreas = idAreas;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
}