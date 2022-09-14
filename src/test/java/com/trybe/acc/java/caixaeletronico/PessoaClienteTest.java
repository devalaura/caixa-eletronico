package com.trybe.acc.java.caixaeletronico;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {
  private final ByteArrayOutputStream output = new ByteArrayOutputStream();

  @Before
  public void before() {
    System.setOut(new PrintStream(output));
  }

  @After
  public void after() throws IOException {
    output.close();
  }

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    new PessoaCliente("Laura Ramos", "123.456.789-10", "SenhaSegura123");

    String expected = "Nova pessoa cliente Laura Ramos com CPF: 123.456.789-10 criada!";

    assertEquals(expected, output.toString());
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    PessoaCliente pessoaCliente = new PessoaCliente(
        "Laura Ramos", "123.456.789-10", "SenhaSegura123");

    assertEquals(0, pessoaCliente.retornaNumeroDeContas());

    Banco banco = new Banco();

    Conta contaPoupanca = new Conta("Poupança", pessoaCliente, banco);
    pessoaCliente.adicionarConta(contaPoupanca);

    assertEquals(1, pessoaCliente.retornaNumeroDeContas());

    Conta contaCorrente = new Conta("Corrente", pessoaCliente, banco);
    pessoaCliente.adicionarConta(contaCorrente);

    assertEquals(2, pessoaCliente.retornaNumeroDeContas());
  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    PessoaCliente pessoaCliente = new PessoaCliente(
        "Laura Ramos", "123.456.789-10", "SenhaSegura123");

    Banco banco = new Banco();

    Conta conta = new Conta("Poupança", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    conta.adicionarTransacao(500, "Depósito efetuado");
    conta.adicionarTransacao(5500, "Depósito efetuado");
    conta.adicionarTransacao(500, "Saque efetuado");

    assertEquals(5500, pessoaCliente.retornarSaldoContaEspecifica(0));
  }

  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(
        "Laura Ramos", "123.456.789-10", "SenhaSegura123");

    Conta conta = new Conta("Corrente", pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    conta.adicionarTransacao(200, "Depósito efetuado");

    LocalDateTime dataAtual = LocalDateTime.now();
    String dataAtualFormatada = DateTimeFormatter.ofPattern(
        "dd/MM/yyyy HH:mm:ss").format(dataAtual);

    pessoaCliente.retornarExtratoContaEspecifica(1);
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
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    fail("Não implementado");

  }

}
