package com.example.lab5_gtics.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "Canciones")
public class Canciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCanciones", nullable = false)
    private Integer idCanciones;

    @Column(name = "nombreCancion", length = 45)
    private String nombreCancion;

    @Column(name = "cantante", length = 45)
    private String cantante;

    @Column(name = "genero", length = 45)
    private String genero;

    @Column(name = "url")
    private String url;

    @Column(name = "tipoCancion")
    private Integer tipoCancion;

    @Column(name = "idRecurso")
    private Integer idRecursos;

    public Integer getIdCanciones() {
        return idCanciones;
    }

    public void setIdCanciones(Integer idCanciones) {
        this.idCanciones = idCanciones;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTipoCancion() {
        return tipoCancion;
    }

    public void setTipoCancion(Integer tipoCancion) {
        this.tipoCancion = tipoCancion;
    }

    public Integer getIdRecursos() {
        return idRecursos;
    }

    public void setIdRecursos(Integer idRecursos) {
        this.idRecursos = idRecursos;
    }
}
