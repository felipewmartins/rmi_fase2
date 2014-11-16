package rmi_fase2.server;

import java.io.ObjectInputStream.GetField;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi_fase2.compute.Compute;
import rmi_fase2.compute.Task;

public class Participante2 implements Compute {

  public Participante2() {
    super(); // TODO Auto-generated constructor stub
  }

  @Override
  public <T> T executeTask(Task<T> t) throws RemoteException {
    // TODO Auto-generated method stub
    return t.execute();
  }

  public static void main(String[] args) {
    try {
      LocateRegistry.createRegistry(2002);
      System.out.println("RMI - registrado na porta 2002");
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    try {
      String name = "Compute";
      Compute engine = new Participante2();
      Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 2002);
      Registry registry = LocateRegistry.getRegistry(2002);
      registry.rebind(name, stub);
      System.out.println("ComputeEngine bound");
    } catch (Exception e) {
      System.err.println("ComputeEngine exception:");
      e.printStackTrace();
    }
  }

}
