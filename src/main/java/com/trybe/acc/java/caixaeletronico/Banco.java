package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

public class Banco {
  private ArrayList<String> contas = new ArrayList<>();
  private ArrayList<PessoaCliente> pessoasClientes = new ArrayList<>();

  /** Método para gerar um novo número, único e de 10 dígitos, para contas. */
  public String gerarNumeroNovaConta() {
    Random random = new Random();
    String numeroConta = "";

    for (int i = 0; i < 10; i++) {
      String digito = Integer.toString(random.nextInt());
      numeroConta.concat(digito);
    }

    if (this.contas.contains(numeroConta)) {
      return this.gerarNumeroNovaConta();
    } else {
      this.contas.add(numeroConta);

      return numeroConta;
    }
  }

  /**
   * Método para instânciar novo objeto de pessoa cliente.
   * 
   * @param nome  // Recebe o nome da pessoa cliente.
   * @param cpf   // Recebe o cpf da pessoa cliente.
   * @param senha // Recebe a senha da pessoa cliente.
   * 
   */
  public PessoaCliente adicionarPessoaCliente(String nome, String cpf, String senha) {
    PessoaCliente novaPessoaCliente = new PessoaCliente(nome, cpf, senha);

    if (this.pessoasClientes.contains(novaPessoaCliente)) {
      return novaPessoaCliente;
    } else {
      this.pessoasClientes.add(novaPessoaCliente);

      return novaPessoaCliente;
    }

  }

  /** Método get do atributo privado contas, que armazena todas as contas. */
  public ArrayList<String> getContas() {
    return this.contas;
  }

  /**
   * Método get do atributo privado pessoasClientes, que armazena as pessoas
   * clientes.
   */
  public ArrayList<PessoaCliente> getPessoasClientes() {
    return this.pessoasClientes;
  }
}
