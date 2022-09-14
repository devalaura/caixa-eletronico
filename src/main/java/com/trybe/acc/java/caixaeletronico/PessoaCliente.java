package com.trybe.acc.java.caixaeletronico;

public class PessoaCliente {
  private String nomeCompleto;
  private String cpf;
  private String senha;

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

    System.out.printf("Nova pessoa cliente %s com CPF: %s criada!", nome, cpf);
  }
}
