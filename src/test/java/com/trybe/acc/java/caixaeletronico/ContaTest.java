package com.trybe.acc.java.caixaeletronico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
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
    fail("Não implementado");

  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    fail("Não implementado");
  }

}
