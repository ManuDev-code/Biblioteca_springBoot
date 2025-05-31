package com.cesde.Biblioteca.Repositorio;

import com.cesde.Biblioteca.Modelo.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrestamoRepositorio extends JpaRepository<Prestamo,Integer> {
}
