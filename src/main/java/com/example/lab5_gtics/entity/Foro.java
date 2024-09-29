package com.example.lab5_gtics.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Foro")
public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idForo", nullable = false)
    private Integer idForo;

    @Column(name = "comentario")
    private String comentario;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "nombrePersona")
    private String nombrePersona;

    public Integer getIdForo() {
        return idForo;
    }

    public void setIdForo(Integer idForo) {
        this.idForo = idForo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
