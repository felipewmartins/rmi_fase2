package rmi_fase2.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi_fase2.client.task.ReadFile;
import rmi_fase2.compute.Compute;
import rmi_fase2.controle.Operacoes;

public class Cliente extends Operacoes {
  
  static Cliente cli;
  
  public Cliente() {
   super(); // TODO Auto-generated constructor stub
   cli = new Cliente();
   
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    try {
      String name = "Compute";
      Registry registry = LocateRegistry.getRegistry(2001);
      Compute comp = (Compute)registry.lookup(name);
      ReadFile read = new ReadFile("/home/felipe/teste.txt");
      //cli.depositar(20, 10);
      String retorno = (String) comp.executeTask(read);
      System.out.println(retorno);
      System.out.println("Acabou");
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  
}
