package rmi_fase2.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi_fase2.compute.Compute;
import rmi_fase2.compute.Task;

public class Participante1 implements Compute {

  public Participante1() {
    super(); // TODO Auto-generated constructor stub
  }

  @Override
  public <T> T executeTask(Task<T> t) throws RemoteException {
    // TODO Auto-generated method stub
    return t.execute();
  }

  private void createRegister() {
    try {
      LocateRegistry.createRegistry(2001);
      System.out.println("RMI registrado na porta 2001");
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }

  public void startP1() {
    createRegister();
    try {
      String name = "Compute";
      Compute engine = new Participante1();
      Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 2001);
      Registry registry = LocateRegistry.getRegistry(2001);
      registry.rebind(name, stub);
      System.out.println("ComputeEngine bound");
    } catch (Exception e) {
      System.err.println("ComputeEngine exception:");
      e.printStackTrace();
    }
  }

}
