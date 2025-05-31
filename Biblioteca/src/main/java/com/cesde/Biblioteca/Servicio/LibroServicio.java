package com.cesde.Biblioteca.Servicio;

import com.cesde.Biblioteca.Modelo.Libro;
import com.cesde.Biblioteca.Modelo.Usuario;
import com.cesde.Biblioteca.Repositorio.ILibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LibroServicio {
    // inyectar Repositorio
    @Autowired
    ILibroRepositorio iLibroRepositorio;

    public Libro guardar(Libro datosguardar) throws Exception{
        try{
            return this.iLibroRepositorio.save(datosguardar);
        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    } // fin metodo guardar

    public List<Libro> consultageneral() throws Exception{
        try{
            return this.iLibroRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // fin metodo consultageneral

    public Libro consultaindividual(Integer codlibro) throws Exception{
        try{
            Optional<Libro> libroencontrado=this.iLibroRepositorio.findById(codlibro);
            if (libroencontrado.isPresent())
                return libroencontrado.get();
            else
                throw new Exception("Libro no registrado");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }// fin metodo consultaindividual

    public List<Libro> consultaporNombre(Integer codLibro) throws Exception{
        try{
            return this.iLibroRepositorio.findByCodLibro(codLibro);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // fin metodo consultaporNombre

    public Libro modificarlibro(Integer codlibro,Libro datosmodificar) throws Exception{
        try{
            Optional<Libro> libroencontrado=this.iLibroRepositorio.findById(codlibro);
            if (libroencontrado.isPresent()){
                Libro libronuevo=libroencontrado.get();
                libronuevo.setAutor(datosmodificar.getAutor());
                libronuevo.setNomLibro(datosmodificar.getNomLibro());
                libronuevo.setGenero(datosmodificar.getGenero());
                return this.iLibroRepositorio.save(libronuevo);
            }else{
                throw new Exception("No se puede modificar porque no esta registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Boolean eliminarlibro(Integer codlibro) throws Exception{
        try{
            Optional<Libro> libroencontrado=this.iLibroRepositorio.findById(codlibro);
            if (libroencontrado.isPresent()){
                this.iLibroRepositorio.deleteById(codlibro);
                return true;
            }else
                throw new Exception("No se pudo eliminar porque no esta registrado");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // fin metodo eliminarlibro
}
