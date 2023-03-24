package com.example.ingressos.shared;

import jakarta.validation.constraints.Positive;

public class IngressoCompletoDto {

    private String id;
    private String nomeDoCliente;
    private String idFilme;
    @Positive
    private Double valor;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNomeDoCliente() {
        return nomeDoCliente;
    }
    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }
    public String getIdFilme() {
        return idFilme;
    }
    public void setIdFilme(String idFilme) {
        this.idFilme = idFilme;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
