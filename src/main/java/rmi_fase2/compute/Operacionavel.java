package rmi_fase2.compute;

import java.rmi.Remote;

public interface Operacionavel extends Remote {

  public void sacar(double valor, int conta);
  public void depositar(double valor, int conta);
}
