package com.cesde.Biblioteca.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="libro")
public class Libro {
    @Id
    @Column(name="codlibro",length = 50,nullable = false)
    private int codLibro;
    private String nomLibro;
    private String genero;
    private String autor;
    private String activo;
    public Libro() {
    }
    public Libro(int codLibro, String nomLibro, String genero, String autor, String activo) {
        this.codLibro = codLibro;
        this.nomLibro = nomLibro;
        this.genero = genero;
        this.autor = autor;
        this.activo = activo;
    }
    public int getCodLibro() {
        return codLibro;
    }
    public void setCodLibro(int codLibro) {
        this.codLibro = codLibro;
    }

    public String getNomLibro() {
        return nomLibro;
    }

    public void setNomLibro(String nomLibro) {
        this.nomLibro = nomLibro;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
