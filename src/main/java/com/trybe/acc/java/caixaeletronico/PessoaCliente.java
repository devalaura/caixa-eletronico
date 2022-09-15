package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {
  private String nomeCompleto;
  private String cpf;
  private String senha;
  private ArrayList<Conta> contas;

  /**
   * Construtor da classe que representa a pessoa cliente.
   * 
   * @param nome  // Recebe o nome da pessoa cliente.
   * @param cpf   // Recebe o cpf da pessoa cliente.
   * @param senha // Recebe a senha da pessoa cliente.
   * 
   */
  public PessoaCliente(String nome, String cpf, String senha) {
    this.nomeCompleto = nome;
    this.cpf = cpf;
    this.senha = senha;
    this.contas = new ArrayList<>();

    System.out.printf("Nova pessoa cliente %s com CPF: %s criada!", nome, cpf);
  }

  /**
   * Método para adicionar uma nova conta à lista de contas da pessoa cliente.
   * Este método não possui retorno.
   * 
   * @param conta // Recebe a conta a ser inserida na lista.
   */
  public void adicionarConta(Conta conta) {
    this.contas.add(conta);
  }

  /**
   * Método para contar a quantidade de elementos da lista de contas da pessoa
   * cliente. Esse método não recebe parametros e retorna um número inteiro.
   */
  public int retornaNumeroDeContas() {
    return this.contas.size();
  }

  /**
   * Método para retornar o saldo de uma conta específica dentro da lista de
   * contas. Seu retorno é do tipo double.
   * 
   * @param indice // Recebe o índice da conta dentro da lista de contas.
   */
  public double retornarSaldoContaEspecifica(int indice) {
    return this.contas.get(indice).retornarSaldo();
  }

  /**
   * Método para retornar o número identificador de uma conta específica dentro da
   * lista de contas. Seu retorno é do tipo String.
   * 
   * @param indice // Recebe o índice da conta dentro da lista de contas.
   */
  public String retornarIdContaEspecifica(int indice) {
    return this.contas.get(indice).getIdConta();
  }

  /**
   * Método para filtrar a conta pelo índice e chamar o método que retorna o
   * extrato. Esse método não possui retorno.
   * 
   * @param indice // Recebe um inteiro que representa o índice da conta na lista
   *               de contas.
   */
  public void retornarExtratoContaEspecifica(int indice) {
    Conta contaEspecifica = this.contas.get(indice);

    contaEspecifica.retornarExtrato();
  }

  /**
   * Método get do atributo privado nomeCompleto, que armazena o nome da pessoa
   * cliente.
   */
  public String getNomeCompleto() {
    return this.nomeCompleto;
  }

  /** Método get do atributo privado cpf, que armazena o CPF da pessoa cliente. */
  public String getCpf() {
    return this.cpf;
  }

  /**
   * Método get do atributo privado senha, que armazena a senha da pessoa cliente.
   */
  public String getSenha() {
    return this.senha;
  }

  /**
   * Método get do atributo privado contas, que armazena todas as contas da pessoa
   * cliente.
   */
  public ArrayList<Conta> getContas() {
    return this.contas;
  }
}
