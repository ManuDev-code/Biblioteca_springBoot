package com.cesde.Biblioteca.Repositorio;

import com.cesde.Biblioteca.Modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILibroRepositorio extends JpaRepository<Libro,Integer> {
    List<Libro> findByCodLibro (Integer CodLibro);
}
