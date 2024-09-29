package com.example.lab5_gtics.entity;
import com.example.lab5_gtics.entity.Area;


import jakarta.persistence.*;

@Entity
@Table(name = "Profesionales")
public class Profesional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfesionales", nullable = false)
    private Integer idProfesionales;

    @Column(name = "nombre", length = 45)
    private String nombre;
    @Column(name = "imagen", length = 255)
    private String imagen;
    @Column(name = "descripcionProfesional", length = 90)
    private String descripcionProfesional;
    @ManyToOne
    @JoinColumn(name = "idArea")
    private Area area;
    @ManyToOne
    @JoinColumn(name = "idSede")
    private Sede sede;

    public Integer getIdProfesionales() {
        return idProfesionales;
    }

    public void setIdProfesionales(Integer idProfesionales) {
        this.idProfesionales = idProfesionales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcionProfesional() {
        return descripcionProfesional;
    }

    public void setDescripcionProfesional(String descripcionProfesional) {
        this.descripcionProfesional = descripcionProfesional;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
}
