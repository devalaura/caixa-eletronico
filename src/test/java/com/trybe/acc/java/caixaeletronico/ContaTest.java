package com.trybe.acc.java.caixaeletronico;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Teste da classe Conta")
class ContaTest {

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    final String nome = "Laura Ramos";
    final String cpf = "123.456.789-10";
    final String senha = "SenhaSegura123";
    final String tipoConta = "Poupança";

    final Banco banco = new Banco();
    final PessoaCliente novaPessoaCliente = banco.adicionarPessoaCliente(nome, cpf, senha);
    final Conta novaConta = new Conta(tipoConta, novaPessoaCliente, banco);

    assertEquals(novaPessoaCliente, novaConta.getPessoaCliente());
    assertEquals(tipoConta, novaConta.getTipoConta());
    assertEquals("String", novaConta.getIdConta().getClass().getSimpleName());
    assertEquals(10, novaConta.getIdConta().length());
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    final String nome = "Laura Ramos";
    final String cpf = "123.456.789-10";
    final String senha = "SenhaSegura123";

    final Banco banco = new Banco();
    final PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);
    final Conta conta = new Conta("Poupança", pessoaCliente, banco);

    assertEquals(0, conta.retornarSaldo());
    assertEquals(0, conta.getTransacoes().size());

    conta.adicionarTransacao(200, "Depósito efetuado");
    assertEquals(200, conta.retornarSaldo());
    assertEquals(1, conta.getTransacoes().size());

    conta.adicionarTransacao(10, "Saque efetuado");
    assertEquals(190, conta.retornarSaldo());
    assertEquals(2, conta.getTransacoes().size());

    conta.adicionarTransacao(50, "Transferência recebida");
    assertEquals(240, conta.retornarSaldo());
    assertEquals(3, conta.getTransacoes().size());

    conta.adicionarTransacao(40, "Transferência efetuada");
    assertEquals(200, conta.retornarSaldo());
    assertEquals(4, conta.getTransacoes().size());

  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream ps = System.out;
    System.setOut(new PrintStream(output));

    final Banco banco = new Banco();
    final PessoaCliente pessoaCliente = new PessoaCliente(
        "Laura Ramos", "123.456.789-10", "SenhaSegura123");
    final Conta conta = new Conta("Poupança", pessoaCliente, banco);

    conta.adicionarTransacao(200.00, "Depósito efetuado");

    LocalDateTime dataAtual = LocalDateTime.now();
    String dataAtualFormatada = DateTimeFormatter.ofPattern(
        "dd/MM/yyyy HH:mm:ss").format(dataAtual);

    conta.retornarExtrato();
    String resultadoEsperado = new StringBuilder("")
        .append("Extrato da conta ")
        .append(conta.getIdConta())
        .append("\n")
        .append(dataAtualFormatada)
        .append(" -------- Depósito efetuado: R$ 200.00 +")
        .toString();

    assertEquals(resultadoEsperado, output.toString());
  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream ps = System.out;
    System.setOut(new PrintStream(output));

    final Banco banco = new Banco();
    final PessoaCliente pessoaCliente = new PessoaCliente(
        "Laura Ramos", "123.456.789-10", "SenhaSegura123");
    final Conta conta = new Conta("Poupança", pessoaCliente, banco);

    conta.adicionarTransacao(200.00, "Depósito efetuado");

    LocalDateTime dataAtual = LocalDateTime.now();
    String dataAtualFormatada = DateTimeFormatter.ofPattern(
        "dd/MM/yyyy HH:mm:ss").format(dataAtual);

    conta.retornarExtrato();
    String resultadoEsperado = new StringBuilder("")
        .append(dataAtualFormatada)
        .append(" -------- Depósito efetuado: R$ 200.00 +")
        .toString();

    assertEquals(resultadoEsperado, output.toString());
  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    final Banco banco = new Banco();
    final PessoaCliente pessoaCliente = new PessoaCliente(
        "Laura Ramos", "123.456.789-10", "SenhaSegura123");
    final Conta conta = new Conta("Poupança", pessoaCliente, banco);

    assertEquals(10, conta.getIdConta().length());
    assertEquals("String", conta.getIdConta().getClass().getSimpleName());
  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    final Banco banco = new Banco();

    final String nome = "Laura Ramos";
    final String cpf = "123.456.789-10";
    final String senha = "SenhaSegura123";
    final PessoaCliente pessoaCliente = new PessoaCliente(nome, cpf, senha);

    final Conta conta = new Conta("Poupança", pessoaCliente, banco);

    assertEquals(pessoaCliente, conta.getPessoaCliente());
    assertEquals(nome, conta.getPessoaCliente().getNomeCompleto());
    assertEquals(cpf, conta.getPessoaCliente().getCpf());
    assertEquals(senha, conta.getPessoaCliente().getSenha());
  }

}
