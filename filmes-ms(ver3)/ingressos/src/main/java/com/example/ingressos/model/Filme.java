package com.example.ingressos.model;

import java.util.List;

public class Filme {

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
      
}
