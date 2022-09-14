package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

public class Banco {
  private ArrayList<Conta> contas = new ArrayList<>();
  private ArrayList<PessoaCliente> pessoasClientes = new ArrayList<>();

  /**
   * Método para gerar um novo número, único e de 10 dígitos, para contas.
   * Retorna a String que representa o novo número da conta.
   * Não recebe parâmetros.
   */
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
   * Método para instânciar novo objeto de pessoa cliente. Retorna o novo objeto
   * criado de PessoaCliente.
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

  /**
   * Método para verificar a validade dos dados de login (cpf e senha) da pessoa
   * cliente. Caso os dados estejam corretos, retorna a pessoa cliente encontrada,
   * caso não, retorna null.
   * 
   * @param cpf   // Recebe o CPF da pessoa cliente que está tentando logar.
   * @param senha // Recebe a senha da pessoa cliente que está tentando logar.
   */
  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    for (PessoaCliente pessoa : this.pessoasClientes) {
      if (pessoa.getCpf().equals(cpf) && pessoa.getSenha().equals(senha)) {
        return pessoa;
      }
    }

    return null;
  }

  /**
   * Método para adicionar uma conta criada à lista de contas da pessoa cliente.
   * Não possui retorno.
   * 
   * @param conta // Recebe a conta que deve ser adicionada à lista.
   */
  public void adicionarConta(Conta conta) {
    if (!this.contas.contains(conta)) {
      this.contas.add(conta);
    }
  }

  /** Método get do atributo privado contas, que armazena todas as contas. */
  public ArrayList<Conta> getContas() {
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
