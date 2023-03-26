package com.example.ingressos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ingressos")
public class Ingresso {
  @Id
  private String id;
  private String nomeDoCliente;
  private int cadeira;
  private String idFilme;
  
  
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
  public int getCadeira() {
    return cadeira;
  }
  public void setCadeira(int cadeira) {
    this.cadeira = cadeira;
  }
  public String getIdFilme() {
    return idFilme;
  }
  public void setIdFilme(String idFilme) {
    this.idFilme = idFilme;
  } 
}
