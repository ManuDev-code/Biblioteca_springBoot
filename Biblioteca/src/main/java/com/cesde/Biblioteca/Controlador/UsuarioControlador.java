package com.cesde.Biblioteca.Controlador;

import com.cesde.Biblioteca.Modelo.Usuario;
import com.cesde.Biblioteca.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControlador {
    // Inyectar Servicios
    @Autowired
    private UsuarioServicio usuarioservicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Usuario datosNuevos) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.usuarioservicio.guardar(datosNuevos));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo guardar

    @GetMapping
    public ResponseEntity<?> consultageneral() throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioservicio.consultaGeneral());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo consultageneral

    @GetMapping("/{idUsuario}")
    public ResponseEntity<?> consultaindividual(@PathVariable String idUsuario) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioservicio.consultaIndividual(idUsuario));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo consultaindividual

    @GetMapping("/buscar/{nomUsuario}")
    public ResponseEntity<?> consultaporNombre(@RequestParam String nomUsuario) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioservicio.consultaporNombre(nomUsuario));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo consultaporNombre

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<?> eliminarusuario(@PathVariable String idUsuario) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioservicio.eliminarUsuario(idUsuario));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo eliminarusuario

    @PutMapping("/{idUsuario}")
    public ResponseEntity<?> modificarusuario(@PathVariable String idUsuario,@RequestBody Usuario datosnuevos) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioservicio.modificarUsuario(idUsuario,datosnuevos));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo modificarusuario

}
