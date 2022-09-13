package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Random;

public class Banco {
  private ArrayList<String> contas = new ArrayList<>();

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

  /** Método get do atributo provado contas, que armazena todas as contas. */
  public ArrayList<String> getContas() {
    return this.contas;
  }
}
