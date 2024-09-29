package com.example.lab5_gtics.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Frases")
public class Frases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFrases", nullable = false)
    private Integer idFrases;

    @Column(name = "frase")
    private String frase;


    @Column(name = "idRecurso")
    private Integer idRecurso;

    public Integer getIdFrases() {
        return idFrases;
    }

    public void setIdFrases(Integer idFrases) {
        this.idFrases = idFrases;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Integer getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }
}
