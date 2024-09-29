package com.example.lab5_gtics.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "riesgos")
public class Riesgo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRiesgos", nullable = false)
    private Integer idRiesgos;

    @Column(name = "name")
    private String name;

    public Integer getIdRiesgos() {
        return idRiesgos;
    }

    public void setIdRiesgos(Integer idRiesgos) {
        this.idRiesgos = idRiesgos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}