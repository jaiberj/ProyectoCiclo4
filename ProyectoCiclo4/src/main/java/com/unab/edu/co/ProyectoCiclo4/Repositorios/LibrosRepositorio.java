package com.unab.edu.co.ProyectoCiclo4.Repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.unab.edu.co.ProyectoCiclo4.Modelos.LibrosModelo;

@Repository
public interface LibrosRepositorio extends MongoRepository<LibrosModelo, String>{
    
}

    

