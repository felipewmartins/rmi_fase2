package rmi_fase2.client;

import java.rmi.RemoteException;

import rmi_fase2.compute.Task;

@SuppressWarnings("rawtypes")
public class OperacaoImpl implements Task {

  private String msg;
  private double saldo = 200;
  private boolean retorno = false;

  public OperacaoImpl() throws RemoteException {
    super(); // TODO Auto-generated constructor stub
  }

  public synchronized Object sacar(double valor, int conta) {
    // TODO Auto-generated method stub
    retorno = false;
    System.out
    .println("\n----------------------- Finalizando Operaçao ---------------------------");


    System.out.println("---------------------Iniciando Operaçao--------------------------\n");

    if (saldo <= 0 | valor > saldo) {
      System.out.println("Impossivel sacar. Saldo atual.:" + saldo);
      return retorno;
    } else {
      System.out.println("Saldo atual.:" + saldo);
      saldo = saldo - valor;
      msg = "Conta.: " + conta + " | Sacou.:" + valor;
      System.out.println(msg);
      retorno = true;
    }
    return retorno;
    
  }

  public synchronized Object depositar(double valor, int conta) {
    // TODO Auto-generated method stub
    System.out
    .println("\n------------------------- Iniciando Operaçao --------------------------------");

    if (saldo <= 0) {
      System.out.println("Impossivel depositar, Saldo atual.: " + saldo);
      return retorno;
    } else {
      msg = "Conta.: " + conta + " | Depositou.:" + valor + " para a conta.: " + conta;
      valor = valor - saldo;
      System.out.println(msg);
      retorno = true;
  // falta forma de identificar conta e acessar para depositar
}

    System.out
    .println("\n----------------------- Finalizando Operaçao ---------------------------");
    return retorno;


  }

  @Override
  public Object execute() {
    // TODO Auto-generated method stub
    return null;
  }

}
