package rmi_fase2.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi_fase2.client.task.ReadFile;
import rmi_fase2.compute.Compute;

public class Cliente {

  public static void main(String[] args) {
    try {
      String name = "compute";
      Registry registry = LocateRegistry.getRegistry(2001);
      Compute comp = (Compute)registry.lookup(name);
      ReadFile read = new ReadFile("teste.txt");
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
