package com.cesde.Biblioteca.Servicio;

import com.cesde.Biblioteca.Modelo.Usuario;
import com.cesde.Biblioteca.Repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    private IUsuarioRepositorio iUsuario;

    public UsuarioServicio(IUsuarioRepositorio iUsuario) {
        this.iUsuario = iUsuario;
    }

    public Usuario guardar(Usuario datosguardar) throws Exception{
        try{
             return this.iUsuario.save(datosguardar);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // fin metodo guardar

    public List<Usuario> consultaGeneral() throws Exception{
        try{
            return this.iUsuario.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // fin metodo consultaGeneral

    public Usuario consultaIndividual(String idUsuario) throws Exception{
        try {
            Optional<Usuario> usuarioEncontrado=this.iUsuario.findById(idUsuario);
            if (usuarioEncontrado.isPresent())
                return usuarioEncontrado.get();
            else
                throw new Exception("Usuario no esta registrado");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // fin metodo consultaIndividual

    public List<Usuario> consultaporNombre(String nomUsuario) throws Exception{
        try{
            return this.iUsuario.findByNomusuario(nomUsuario);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // fin metodo consultaporNombre

    public Boolean eliminarUsuario(String idUsuario) throws Exception{
        try{
            Optional<Usuario> usuarioEncontrado=this.iUsuario.findById(idUsuario);
            if (usuarioEncontrado.isPresent()){
                this.iUsuario.deleteById(idUsuario);
                return true;
            }else
                throw new Exception("Usuario no registrado");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // fin metodo eliminarUsuario

    public Usuario modificarUsuario(String idUsuario, Usuario datosguardar) throws Exception{
        try{
            Optional<Usuario> usuarioEncontrado=this.iUsuario.findById(idUsuario);
            if (usuarioEncontrado.isPresent()){
                // Llenar registro a retornar
                Usuario usuarioNuevo=usuarioEncontrado.get();
                usuarioNuevo.setNomusuario(datosguardar.getNomusuario());
                usuarioNuevo.setDirusuario(datosguardar.getDirusuario());
                usuarioNuevo.setCelular(datosguardar.getCelular());
                return this.iUsuario.save(usuarioNuevo);
            }else
                throw new Exception("Usuario no registrado");
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    } // fin metodo modificarUsuario
}
