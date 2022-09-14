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
