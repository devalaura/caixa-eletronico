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

  /** Método get para retornar o atributo privado quantia. */
  public double getQuantia() {
    return this.quantia;
  }

  /** Método get para retornar o atributo privado instante. */
  public String getInstante() {
    return this.instante;
  }

  /** Método get para retornar o atributo privado descricao. */
  public String getDescricao() {
    return this.descricao;
  }

  /** Método get para retornar o atributo privado conta. */
  public Conta getConta() {
    return this.conta;
  }
}
