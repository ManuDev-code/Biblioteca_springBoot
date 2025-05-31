package com.cesde.Biblioteca.Controlador;

import com.cesde.Biblioteca.Modelo.Libro;
import com.cesde.Biblioteca.Modelo.Usuario;
import com.cesde.Biblioteca.Servicio.LibroServicio;
import com.cesde.Biblioteca.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libros")
public class LibroControlador {
    // Inyectar Servicios
    @Autowired
    private LibroServicio libroServicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Libro datosNuevos) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.libroServicio.guardar(datosNuevos));
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
                    .body(this.libroServicio.consultageneral());
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo consultageneral

    @GetMapping("/{codLibro}")
    public ResponseEntity<?> consultaindividual(@PathVariable Integer codLibro) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.libroServicio.consultaindividual(codLibro));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo consultaindividual

    @GetMapping("/buscar/{codLibro}")
    public ResponseEntity<?> consultaporNombre(@RequestParam Integer codLibro) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.libroServicio.consultaporNombre(codLibro));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo consultaporNombre

    @DeleteMapping("/{codLibro}")
    public ResponseEntity<?> eliminar(@PathVariable Integer codLibro) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.libroServicio.eliminarlibro(codLibro));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo eliminar

    @PutMapping("/{codLibro}")
    public ResponseEntity<?> modificar(@PathVariable Integer codLibro,@RequestBody Libro datosnuevos) throws Exception{
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.libroServicio.modificarlibro(codLibro,datosnuevos));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    } // fin metodo modificar
}
