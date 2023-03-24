package com.example.filmes.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("filmes")
public class Filme {

    @Id
    private String id;
    private String titulo;
    private List<String> generos;

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public List<String> getGeneros() {
        return generos;
    }
    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }        
    
}
