package rmi_fase2.compute;

public interface Task<T> {
  T execute();
  
  T sacar(double valor, int conta);
  T depositar(double valor, int conta);

}
