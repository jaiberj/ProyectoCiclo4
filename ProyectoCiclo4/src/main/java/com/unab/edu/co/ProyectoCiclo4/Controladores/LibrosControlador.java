package com.unab.edu.co.ProyectoCiclo4.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.edu.co.ProyectoCiclo4.Modelos.LibrosModelo;
import com.unab.edu.co.ProyectoCiclo4.Servicios.LibrosServicios;


@RestController
@RequestMapping("/libros")
public class LibrosControlador {
    @Autowired
    LibrosServicios lService;

    @GetMapping
    public List <LibrosModelo> getLibrosOrdenados(){

        return lService.getLibrosOrden();
    }

    @PostMapping
    public String nuevoLibro(@RequestBody LibrosModelo libro){

        return lService.guardarLibro(libro);

    }

    @DeleteMapping("/id")
    public String borrarLibroPorId(@PathVariable("id") String id){
        return lService.eliminarLibroPorId(id);
    }
    
    
}
