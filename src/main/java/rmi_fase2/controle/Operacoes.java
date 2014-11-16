package rmi_fase2.controle;

import rmi_fase2.compute.Task;

public abstract class Operacoes implements Task {

  private String nome;
  private double saldo;
  private int conta;
  private String msg;

  public synchronized void sacar(double valor) {

    System.out.println("Iniciando Operaçao");

    if (saldo <= 0) {
      System.out.println("Impossivel sacar. Saldo atual.:" + saldo);
    } else {
      saldo = saldo - valor;
      System.out.println("Saldo atual.:" + saldo);
      msg = "Usuario.: " + nome + " /n Sacou.:" + valor;
    }

    System.out.println("Finalizando Operaçao");
  }

  public synchronized void depositar(double valor, int conta) {

    System.out.println("Iniciando Operaçao");

    if (saldo <= 0) {
      System.out.println("Impossivel depositar, Saldo atual.: " + saldo);
    } else {
      valor = valor - saldo;
      msg = "Usuario.: " + nome + " /n Depositou.:" + valor + " para a conta.: " + conta;
      // forma de identificar conta e acessar para depositar
    }

    System.out.println("Finalizando Operaçao");

  }

  public void extrato() {

  }

  @Override
  public Object execute() {
    // TODO Auto-generated method stub
    //depositar(valor, conta);
    return null;
  }

}
