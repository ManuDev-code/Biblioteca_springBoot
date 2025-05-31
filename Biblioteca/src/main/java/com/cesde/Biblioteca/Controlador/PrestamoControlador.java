package com.cesde.Biblioteca.Controlador;

import com.cesde.Biblioteca.Modelo.Prestamo;
import com.cesde.Biblioteca.Modelo.Usuario;
import com.cesde.Biblioteca.Servicio.PrestamoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestamos")
public class PrestamoControlador {
    // Inyectar Servicios
    @Autowired
    PrestamoServicio prestamoServicio;

    @PostMapping("/{codPrestamo}")
    public ResponseEntity<?> guardar(@RequestBody Prestamo datosNuevos) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.prestamoServicio.guardarPrestamo(datosNuevos));
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
                    .body(this.prestamoServicio.consultaGeneral());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo consultageneral

    @GetMapping("/{codPrestamo}")
    public ResponseEntity<?> consultaindividual(@PathVariable Integer codPrestamo) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.prestamoServicio.consultaIndividualId(codPrestamo));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo consultaindividual

   /* @GetMapping("/{nomUsuario}")
    public ResponseEntity<?> consultaporNombre(@PathVariable String nomUsuario) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioservicio.consultaporNombre(nomUsuario));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo consultaporNombre */

    @DeleteMapping("/{codPrestamo}")
    public ResponseEntity<?> eliminar(@PathVariable Integer codPrestamo) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.prestamoServicio.eliminar(codPrestamo));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo eliminar

    @PutMapping("/{codPrestamo}")
    public ResponseEntity<?> modificar(@PathVariable Integer codPrestamo,@RequestBody Prestamo datosnuevos) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.prestamoServicio.modificar(codPrestamo,datosnuevos));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo modificar

}
