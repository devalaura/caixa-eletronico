package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class Conta {
  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> transacoes;

  /**
   * Método construtor da classe Conta.
   * 
   * @param tipoConta     // Recebe o tipo da conta ("Poupança" ou "Corrente").
   * @param pessoaCliente // Recebe um objeto do tipo PessoaCliente que representa
   *                      a pessoa cliente resposável por esta conta.
   * @param banco         // Recebe um objeto do tipo Banco que representa o banco
   *                      resposável pela conta.
   * 
   */
  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    this.tipoConta = tipoConta;
    this.pessoaCliente = pessoaCliente;
    this.idConta = banco.gerarNumeroNovaConta();
    this.transacoes = new ArrayList<>();
  }

  /**
   * Método get do atributo privado tipoConta, que armazena o tipo da conta
   * ("Poupança" ou "Corrente").
   */
  public String getTipoConta() {
    return this.tipoConta;
  }

  /**
   * Método get do atributo privado idConta, que armazena o número da conta.
   */
  public String getIdConta() {
    return this.idConta;
  }

  /**
   * Método get do atributo privado pessoaCliente, que armazena o objeto que
   * representa a pessoa cliente responsável pela conta.
   */
  public PessoaCliente getPessoaCliente() {
    return this.pessoaCliente;
  }

  /**
   * Método get do atributo privado transacoes, que armazena as transações
   * realizadas pela pessoa cliente responsável pela conta.
   */
  public ArrayList<Transacao> getTransacoes() {
    return this.transacoes;
  }
}
