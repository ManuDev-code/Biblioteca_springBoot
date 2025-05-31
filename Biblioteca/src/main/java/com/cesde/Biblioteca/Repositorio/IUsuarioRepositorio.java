package com.cesde.Biblioteca.Repositorio;

import com.cesde.Biblioteca.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,String> {
   List <Usuario> findByNomusuario(String Nomusuario);
}
