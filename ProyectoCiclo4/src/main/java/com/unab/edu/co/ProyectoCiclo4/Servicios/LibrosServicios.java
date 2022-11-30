package com.unab.edu.co.ProyectoCiclo4.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.edu.co.ProyectoCiclo4.Modelos.LibrosModelo;
import com.unab.edu.co.ProyectoCiclo4.Repositorios.LibrosRepositorio;

@Service
public class LibrosServicios {
    @Autowired
    LibrosRepositorio lbrepo;

    

    public List<LibrosModelo> getLibrosOrden() {
        List<LibrosModelo> listaLibros = lbrepo.findAll();
        listaLibros.sort(Comparator.comparing(LibrosModelo::getTitulo));
        return listaLibros;
    }

    public String guardarLibro(LibrosModelo libro) {
        libro.setTitulo(libro.getTitulo().toLowerCase());
            
        if (libro.getId() == null || !lbrepo.existsById(libro.getId())) {
            lbrepo.save(libro); 
            return "Se guardó el libro";

        } else {
            lbrepo.save(libro); 
            return "Se actualizó el libro";

        }               
            
    }

    public String eliminarLibroPorId(String id){
        if (lbrepo.existsById(id)) {
                Optional<LibrosModelo> libro = lbrepo.findById(id);
                lbrepo.deleteById(id);
                return "Libro "+libro.get().getTitulo()+" Eliminado";
            } else {
                return "No Eliminado";
        }
    }

}
