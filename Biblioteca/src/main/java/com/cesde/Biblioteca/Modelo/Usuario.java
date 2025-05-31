package com.cesde.Biblioteca.Modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario {
    //int Integer  date LocalDate bool Boolean double Double
    @Id
    @Column(length = 15,nullable = false)
    private String idusuario;
    @Column(name="nomusuario",length = 50,nullable = false)
    private String nomusuario;
    @Column(name="dirusuario",length = 50,nullable = false)
    private String dirusuario;
    @Column(name="celular",length = 10,nullable = false)
    private String celular;
    @Column(name="activo",length = 2,nullable = false)
    private String activo;

    // Relacionamiento entre tablas
    @OneToMany(mappedBy = "usuarios")
    @JsonManagedReference
    List<Prestamo> prestamo;

    public Usuario() {
    }

    public Usuario(String idusuario, String nomusuario, String dirusuario, String celular, String activo) {
        this.idusuario = idusuario;
        this.nomusuario = nomusuario;
        this.dirusuario = dirusuario;
        this.celular = celular;
        this.activo = activo;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getNomusuario() {
        return nomusuario;
    }

    public void setNomusuario(String nomusuario) {
        this.nomusuario = nomusuario;
    }

    public String getDirusuario() {
        return dirusuario;
    }

    public void setDirusuario(String dirusuario) {
        this.dirusuario = dirusuario;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
