package rmi_fase2.client;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi_fase2.client.task.ReadFile;
import rmi_fase2.compute.Compute;
import rmi_fase2.compute.ServersNames;
import rmi_fase2.controle.Operacoes;

public class Cliente extends Operacoes {
  
  
  public Cliente() {
   super(); // TODO Auto-generated constructor stub
   
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    Operacoes cliOperacoes = new Cliente();
    cliOperacoes.depositar(100, 123);
    try {
      String name = "Compute";
      Registry registry = LocateRegistry.getRegistry("localhost",ServersNames.COORDENADOR.getPort());
      Compute comp = (Compute)registry.lookup(name);
      ReadFile read = new ReadFile("/home/felipe/teste.txt");
      comp.executeTask(cliOperacoes.depositar(100, 123));
      System.out.println("Fim");
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  @Override
  public Double execute() {
    // TODO Auto-generated method stub
    return null;
  }

  
}
