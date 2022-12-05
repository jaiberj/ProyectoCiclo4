package com.unab.edu.co.ProyectoCiclo4.Modelos;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("editoriales")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EditorialModelo {
    @Id
    private String id;
    private String nombre;
    private String pais;        
    private List<LibrosModelo> libros;
        
}
