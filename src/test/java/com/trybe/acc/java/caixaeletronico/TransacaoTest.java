package com.trybe.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {

  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    final double quantia = 13000;
    final String descricao = "Depósito efetuado";
    final Transacao novaTransacao = new Transacao(quantia, descricao);

    final LocalDateTime dataAtual = LocalDateTime.now();
    final String dataAtualFormatada = DateTimeFormatter.ofPattern(
        "dd/MM/yyyy HH:mm:ss").format(dataAtual);

    assertEquals(descricao, novaTransacao.getDescricao());
    assertEquals(quantia, novaTransacao.getQuantia());
    assertEquals(dataAtualFormatada, novaTransacao.getInstante());
  }

  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    final double quantia = 5000;
    final Transacao novaTransacao = new Transacao(quantia, "Transferência recebida");

    assertEquals(quantia, novaTransacao.getQuantia());
  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    fail("Não implementado");

  }

}
