package rmi_fase2.controle;

import java.io.IOException;

public abstract class Operacoes extends GeraTxt {

  private String msg;
  private GeraTxt gera = new GeraTxt();
  private double saldo = 200;


  public void sacar(double valor, int conta) throws IOException {

        System.out.println("\n----------------------- Finalizando Operaçao ---------------------------");


    System.out.println("---------------------Iniciando Operaçao--------------------------\n");

    if (saldo <= 0 | valor > saldo) {
      System.out.println("Impossivel sacar. Saldo atual.:" + saldo);
    } else {
      System.out.println("Saldo atual.:" + saldo);
      saldo = saldo - valor;
      msg = "Conta.: " + conta + " | Sacou.:" + valor;
      System.out.println(msg);
    }

    System.out
        .println("\n----------------------- Finalizando Operaçao ---------------------------\n");

    gera.extrato(conta, msg);

  }

  public void depositar(double valor, int conta) throws IOException {

    System.out
        .println("\n------------------------- Iniciando Operaçao --------------------------------");

    if (saldo <= 0) {
      System.out.println("Impossivel depositar, Saldo atual.: " + saldo);
    } else {
      msg = "Conta.: " + conta + " | Depositou.:" + valor + " para a conta.: " + conta;
      valor = valor - saldo;
      System.out.println(msg);
      // falta forma de identificar conta e acessar para depositar
    }

    System.out
        .println("\n----------------------- Finalizando Operaçao ---------------------------");

    gera.extrato(conta, msg);
  }

}
