package com.trybe.acc.java.caixaeletronico;

public class Transacao {
  private double quantia;
  private String instante;
  private String descricao;
  private Conta conta;

  /**
   * Método construtor da classe.
   * 
   * @param quantia   // Recebe um valor double que representa a quantia alvo da
   *                  transação.
   * @param descricao // Recebe a descrição, em forma de String, da transação.
   */
  public Transacao(double quantia, String descricao) {
    this.quantia = quantia;
    this.descricao = descricao;
  }
}
