package com.unab.edu.co.ProyectoCiclo4.Servicios;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.edu.co.ProyectoCiclo4.Modelos.EditorialModelo;
import com.unab.edu.co.ProyectoCiclo4.Repositorios.EditorialRepositorio;

@Service
public class EditorialServicios {
    @Autowired
    EditorialRepositorio eRepo;
    

    
    public List<EditorialModelo> getEditorialOrden() {
        List<EditorialModelo> listaEditoriales = eRepo.findAll();
        listaEditoriales.sort(Comparator.comparing(EditorialModelo::getNombre));
        return listaEditoriales;
    }

    public String guardarEditorial(EditorialModelo editorial) {
        editorial.setNombre(editorial.getNombre().toLowerCase());
            
        if (editorial.getId() == null || !eRepo.existsById(editorial.getId())) {
            eRepo.save(editorial); 
            return "Se guardó la editorial";

        } else {
            eRepo.save(editorial); 
            return "Se actualizó la editorial";

        }               
            
    }

    public String eliminarEditorialPorId(String id){
        if (eRepo.existsById(id)) {
                Optional<EditorialModelo> editorial = eRepo.findById(id);
                eRepo.deleteById(id);
                return "Editorial "+editorial.get().getNombre()+" Eliminada";
            } else {
                return "No Eliminada";
        }
    }
    
}
