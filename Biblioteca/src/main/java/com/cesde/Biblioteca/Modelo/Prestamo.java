package com.cesde.Biblioteca.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codprestamo",nullable = false)
    private Integer codPrestamo;
    @Column(name="fecha",nullable = false)
    private LocalDate fecha;
    @Column(name="idusuario",length = 15,nullable = false)
    private String idUsuario;
    @Column(name="activo",length = 2,nullable = false)
    private String activo;

    // Relacionamiento
    @ManyToOne
    @JoinColumn(name="pk_usuarios",referencedColumnName = "idUsuario")
    @JsonBackReference
    Usuario usuarios;
    public Prestamo() {
    }

    public Prestamo(Integer codPrestamo, LocalDate fecha, String idUsuario, String activo) {
        this.codPrestamo = codPrestamo;
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.activo = activo;
    }

    public Integer getCodPrestamo() {
        return codPrestamo;
    }

    public void setCodPrestamo(Integer codPrestamo) {
        this.codPrestamo = codPrestamo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
