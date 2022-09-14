package com.trybe.acc.java.caixaeletronico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    final Banco banco = new Banco();
    final String novaConta = banco.gerarNumeroNovaConta();

    assertEquals("String", novaConta.getClass().getSimpleName());
    assertEquals(10, novaConta.length());
    assertFalse(novaConta.matches("^[a-zA-Z]"));
    assertTrue(banco.getContas().contains(novaConta));
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    final Banco banco = new Banco();

    final String nome = "Laura Ramos";
    final String cpf = "123.456.789-10";
    final String senha = "SenhaSegura123";

    final PessoaCliente novaPessoaCliente = banco.adicionarPessoaCliente(nome, cpf, senha);

    assertEquals(novaPessoaCliente.getNomeCompleto(), nome);
    assertEquals(novaPessoaCliente.getCpf(), cpf);
    assertEquals(novaPessoaCliente.getSenha(), senha);
    assertTrue(banco.getPessoasClientes().contains(novaPessoaCliente));
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    fail("Não implementado");

  }

}
