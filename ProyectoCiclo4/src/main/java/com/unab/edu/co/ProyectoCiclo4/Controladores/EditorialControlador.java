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

import com.unab.edu.co.ProyectoCiclo4.Modelos.EditorialModelo;
import com.unab.edu.co.ProyectoCiclo4.Servicios.EditorialServicios;

@RestController
@RequestMapping("/editoriales")
public class EditorialControlador {
    @Autowired
    EditorialServicios eServicios;

    
    @GetMapping
    public List <EditorialModelo> getEdoitorialesOrdenadas(){

        return eServicios.getEditorialOrden();
    }

    @PostMapping
    public String nuevoLibro(@RequestBody EditorialModelo editorial){

        return eServicios.guardarEditorial(editorial);

    }

    @DeleteMapping("/id")
    public String borrarEditorialPorId(@PathVariable("id") String id){
        return eServicios.eliminarEditorialPorId(id);
    }



    
}
