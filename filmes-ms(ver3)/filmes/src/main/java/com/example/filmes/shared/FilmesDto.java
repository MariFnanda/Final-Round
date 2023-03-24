package com.example.filmes.shared;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class FilmesDto {

    private String id;
    @NotEmpty(message="O campo de titulo deve ser informado.")
    @NotBlank(message="Deve informar os caracteres")
    private String titulo;
    private List<String> generos;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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

    
}
