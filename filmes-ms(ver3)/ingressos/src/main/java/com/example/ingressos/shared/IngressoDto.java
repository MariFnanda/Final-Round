package com.example.ingressos.shared;

import com.example.ingressos.model.Filme;

public class IngressoDto {
  
  private String nomeDoCliente;
  private int cadeira;
  private String idFilme;
  private Filme dadosFilme;
  private Double valor;

  
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
  public Filme getDadosFilme() {
    return dadosFilme;
  }
  public void setDadosFilme(Filme dadosFilme) {
    this.dadosFilme = dadosFilme;
  } 
  public double getValor() {
    return valor;
  }
  public void setValor(double valor) {
    this.valor = valor;
  }
}

