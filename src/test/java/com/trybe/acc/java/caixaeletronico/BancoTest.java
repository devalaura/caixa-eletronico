package com.trybe.acc.java.caixaeletronico;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    final Banco banco = new Banco();
    final String novaConta = banco.gerarNumeroNovaConta();

    assertEquals(10, novaConta.length());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    final Banco banco = new Banco();

    final String nome = "Laura Ramos";
    final String cpf = "123.456.789-10";
    final String senha = "SenhaSegura123";

    final PessoaCliente novaPessoaCliente = banco.adicionarPessoaCliente(nome, cpf, senha);

    assertEquals(nome, novaPessoaCliente.getNomeCompleto());
    assertEquals(cpf, novaPessoaCliente.getCpf());
    assertEquals(senha, novaPessoaCliente.getSenha());
    assertTrue(banco.getPessoasClientes().contains(novaPessoaCliente));
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    final Banco banco = new Banco();

    final String nome = "Laura Ramos";
    final String cpf = "123.456.789-10";
    final String senha = "SenhaSegura123";

    final PessoaCliente novaPessoaCliente = banco.adicionarPessoaCliente(nome, cpf, senha);

    assertEquals(novaPessoaCliente, banco.pessoaClienteLogin(cpf, senha));
    assertNull(banco.pessoaClienteLogin(cpf, "SenhaNãoSegura"));
    assertNull(banco.pessoaClienteLogin("000.000.000-00", senha));
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    final Banco banco = new Banco();

    final PessoaCliente pessoaCliente = new PessoaCliente(
        "Laura Ramos", "123.456.789-10", "SenhaSegura123");

    final Conta contaPoupanca = new Conta("Poupança", pessoaCliente, banco);
    banco.adicionarConta(contaPoupanca);
    final Conta contaCorrente = new Conta("Corrente", pessoaCliente, banco);
    banco.adicionarConta(contaCorrente);

    banco.depositar(pessoaCliente, 0, 15000);

    banco.transferirFundos(pessoaCliente, 0, 1, 10000);

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream ps = System.out;
    System.setOut(new PrintStream(output));

    banco.mostrarExtrato(pessoaCliente, 0);
    String esperadoPoupanca = "5000";
    assertEquals(esperadoPoupanca, output.toString());

    // System.setOut(new PrintStream(output));

    // banco.mostrarExtrato(pessoaCliente, 1);
    // String esperadoCorrente = "10000";
    // assertEquals(esperadoCorrente, output.toString());

    // banco.transferirFundos(pessoaCliente, 1, 0, 5000);

    // System.setOut(new PrintStream(output));

    // banco.mostrarExtrato(pessoaCliente, 0);
    // esperadoPoupanca = "10000";
    // assertEquals(esperadoPoupanca, output.toString());

    // System.setOut(new PrintStream(output));

    // banco.mostrarExtrato(pessoaCliente, 1);
    // esperadoCorrente = "5000";
    // assertEquals(esperadoCorrente, output.toString());
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    final Banco banco = new Banco();

    final PessoaCliente pessoaCliente = new PessoaCliente(
        "Laura Ramos", "123.456.789-10", "SenhaSegura123");

    final Conta conta = new Conta("Poupança", pessoaCliente, banco);
    banco.adicionarConta(conta);

    banco.depositar(pessoaCliente, 0, 15000);
    banco.sacar(pessoaCliente, 0, 10000);

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream ps = System.out;
    System.setOut(new PrintStream(output));

    banco.mostrarExtrato(pessoaCliente, 0);

    String saldoEsperado = "5000";
    assertEquals(saldoEsperado, output.toString());
  }

}
