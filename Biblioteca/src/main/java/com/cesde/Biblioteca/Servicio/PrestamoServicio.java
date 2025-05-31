package com.cesde.Biblioteca.Servicio;

import com.cesde.Biblioteca.Modelo.Prestamo;
import com.cesde.Biblioteca.Repositorio.IPrestamoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServicio {
    @Autowired
    IPrestamoRepositorio iPrestamoRepositorio;
    public Prestamo guardarPrestamo(Prestamo datosguardar) throws Exception{
        try{
            return this.iPrestamoRepositorio.save(datosguardar);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // fin del metodo guardarPrestamo

    public List<Prestamo> consultaGeneral() throws Exception{
        try{
            return this.consultaGeneral();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // fin del metodo consultaGeneral

    public Prestamo consultaIndividualId (Integer Codprestamo) throws Exception{
        try{
            Optional<Prestamo> prestamoEncontrado=this.iPrestamoRepositorio.findById(Codprestamo);
            if (prestamoEncontrado.isPresent())
                return prestamoEncontrado.get();
            else
                throw new Exception("Prestamo no registrado");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        } // fin del metodo ConsultaIndividualId
    }

    public Boolean eliminar(Integer Codprestamo) throws Exception{
        try{
            Optional<Prestamo> prestamoEncontrado=this.iPrestamoRepositorio.findById(Codprestamo);
            if (prestamoEncontrado.isPresent()){
                this.iPrestamoRepositorio.deleteById(Codprestamo);
                return true;
            }else{
                throw new Exception("Prestamo no registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        } // fin del metodo eliminar
    }

    public Prestamo modificar (Integer Codprestamo,Prestamo datosnuevos) throws Exception{
        try{
            Optional<Prestamo> prestamoEncontrado=this.iPrestamoRepositorio.findById(Codprestamo);
            if (prestamoEncontrado.isPresent()){
                Prestamo prestamoNuevo=prestamoEncontrado.get();
                prestamoNuevo.setFecha(datosnuevos.getFecha());
                prestamoNuevo.setIdUsuario(datosnuevos.getIdUsuario());
                prestamoNuevo.setActivo(datosnuevos.getActivo());
                return prestamoNuevo;
            }else {
                throw new Exception("Prestamo no registrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // fin del metodo modificar
}
