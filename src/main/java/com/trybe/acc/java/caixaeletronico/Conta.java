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
   * Método para criar nova transação e adicioná-la no Array de transações da
   * conta. Este método não possui retorno.
   * 
   * @param quantia   // Recebe um valor double que será a quantia da transação.
   * @param descricao // Recebe a descrição, em formato de String, da transação.
   * 
   */
  public void adicionarTransacao(double quantia, String descricao) {
    Transacao novaTransacao = new Transacao(quantia, descricao);

    this.transacoes.add(novaTransacao);
  }

  /**
   * Método para calcular o saldo após transações da conta. Seu retorno é um
   * double.
   */
  public double retornarSaldo() {
    double saldo = 0;
    for (Transacao transacao : this.transacoes) {
      if (transacao.getDescricao().equals("Transferência recebida")) {
        saldo += transacao.getQuantia();
      } else if (transacao.getDescricao().equals("Transferência efetuada")) {
        saldo -= transacao.getQuantia();
      } else if (transacao.getDescricao().equals("Depósito efetuado")) {
        saldo += transacao.getQuantia();
      } else if (transacao.getDescricao().equals("Saque efetuado")) {
        saldo -= transacao.getQuantia();
      }
    }

    return saldo;
  }

  /**
   * Método para retornar o resumo da conta: o identificador único, o saldo e o
   * tipo da conta. Este método não recebe parametros e retorna uma String.
   */
  public String retornarResumoConta() {
    String resumo = new StringBuilder("")
        .append(this.getIdConta())
        .append(" : R$")
        .append(this.retornarSaldo())
        .append(" : ")
        .append(this.getTipoConta())
        .toString();

    return resumo;
  }

  /**
   * Método para imprimir no console o resumo de transações de cada transação da
   * lista de transações da conta. Este método não possui retorno ou recebe
   * parametros.
   */
  public void retornarExtrato() {
    for (Transacao transacao : this.transacoes) {
      System.out.println(transacao.retornarResumoTransacao());
    }
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
