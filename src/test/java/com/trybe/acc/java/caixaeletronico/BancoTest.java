package com.trybe.acc.java.caixaeletronico;

import java.io.ByteArrayOutputStream;
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
    ByteArrayOutputStream saida = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(saida);
    System.setOut(ps);

    final Banco banco = new Banco();
    final PessoaCliente pessoaCliente = banco.adicionarPessoaCliente(
        "Laura Ramos", "123.456.789-10", "SenhaSegura123");
    final Conta contaPoupanca = new Conta("Poupança", pessoaCliente, banco);
    final Conta contaCorrente = new Conta("Corrente", pessoaCliente, banco);
    pessoaCliente.adicionarConta(contaPoupanca);
    pessoaCliente.adicionarConta(contaCorrente);
    banco.adicionarConta(contaPoupanca);
    banco.adicionarConta(contaCorrente);

    banco.depositar(pessoaCliente, 0, 15000);
    banco.mostrarExtrato(pessoaCliente, 0);
    String esperadoPoupanca = " -------- Depósito efetuado R$ 15000.0 +";
    assertTrue(saida.toString().contains(esperadoPoupanca));
    assertEquals(1, contaPoupanca.getTransacoes().size());

    banco.transferirFundos(pessoaCliente, 0, 1, 10000);
    assertEquals(2, contaPoupanca.getTransacoes().size());
    assertEquals(1, contaCorrente.getTransacoes().size());

    banco.mostrarExtrato(pessoaCliente, 0);
    esperadoPoupanca = " -------- Transferência efetuada R$ 10000.0 -";
    assertTrue(saida.toString().contains(esperadoPoupanca));

    banco.mostrarExtrato(pessoaCliente, 1);
    String esperadoCorrente = " -------- Transferência recebida R$ 10000.0 +";
    assertTrue(saida.toString().contains(esperadoCorrente));

    banco.transferirFundos(pessoaCliente, 1, 0, 5000);
    assertEquals(3, contaPoupanca.getTransacoes().size());
    assertEquals(2, contaCorrente.getTransacoes().size());

    banco.mostrarExtrato(pessoaCliente, 0);
    esperadoPoupanca = " -------- Transferência recebida R$ 5000.0 +";
    assertTrue(saida.toString().contains(esperadoPoupanca));

    banco.mostrarExtrato(pessoaCliente, 1);
    esperadoCorrente = "-------- Transferência efetuada R$ 5000.0 -";
    assertTrue(saida.toString().contains(esperadoCorrente));
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    ByteArrayOutputStream saida = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(saida);
    System.setOut(ps);

    final Banco banco = new Banco();
    final PessoaCliente pessoaCliente = banco.adicionarPessoaCliente(
        "Laura Ramos", "123.456.789-10", "SenhaSegura123");
    final Conta conta = new Conta("Poupança", pessoaCliente, banco);
    banco.adicionarConta(conta);

    banco.depositar(pessoaCliente, 0, 15000);
    banco.sacar(pessoaCliente, 0, 10000);

    banco.mostrarExtrato(pessoaCliente, 0);

    String esperado = " -------- Depósito efetuado R$ 15000.0 +";
    assertTrue(saida.toString().contains(esperado));
    esperado = " -------- Saque efetuado R$ 10000.0 -";
    assertTrue(saida.toString().contains(esperado));
  }

}
