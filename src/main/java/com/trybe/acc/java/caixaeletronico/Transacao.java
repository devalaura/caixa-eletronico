package com.trybe.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    this.instante = this.retornarInstante();
  }

  /**
   * Método para captura o instante em que a transação foi efetuada. Retorna uma
   * String que representa a data no formato "dd/MM/yyyy HH:mm:ss".
   */
  public String retornarInstante() {
    final LocalDateTime dataAtual = LocalDateTime.now();
    final String dataAtualFormatada = DateTimeFormatter.ofPattern(
        "dd/MM/yyyy HH:mm:ss").format(dataAtual);

    return dataAtualFormatada;
  }

  /**
   * Método para retornar o resumo de cada transação efetuada nessa conta. Não
   * recebe parametros e retorna uma String.
   */
  public String retornarResumoTransacao() {
    String modificador = "";
    if (this.getDescricao().contains("Depósito")) {
      modificador = " +";
    } else if (this.getDescricao().contains("recebida")) {
      modificador = " +";
    } else {
      modificador = " -";
    }

    final String resumo = new StringBuilder("")
        .append(this.getInstante())
        .append(" -------- ")
        .append(this.getDescricao())
        .append(" R$ ")
        .append(this.getQuantia())
        .append(modificador)
        .toString();

    return resumo;
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
