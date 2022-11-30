package com.unab.edu.co.ProyectoCiclo4.Modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("libros")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class LibrosModelo {
    @Id
    private String id;
    private String titulo;
    private String autor;        
    private String genero;
    private String editorial;
    private String usuario;

    
}
