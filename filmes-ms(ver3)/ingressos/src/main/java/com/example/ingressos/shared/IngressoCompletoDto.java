package com.example.ingressos.shared;


public class IngressoCompletoDto {

    private String id;
    private String nomeDoCliente;
    private String idFilme;
    private int cadeira;

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
    public int getCadeira() {
        return cadeira;
    }
    public void setCadeira(int cadeira) {
        this.cadeira = cadeira;
    }

    
}
