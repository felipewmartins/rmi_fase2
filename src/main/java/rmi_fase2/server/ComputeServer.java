package rmi_fase2.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi_fase2.compute.Compute;
import rmi_fase2.compute.Task;

public class ComputeServer implements Compute {
  
  public  ComputeServer() {
   super(); // TODO Auto-generated constructor stub
  }

  @Override
  public <T> T executeTask(Task<T> t) throws RemoteException {
    // TODO Auto-generated method stub
    return null;
  }
  
  public static void main(String[] args) {
    if (System.getSecurityManager() == null) {
      System.setSecurityManager(new SecurityManager());
    }
    try {
      String name = "Compute";
      Compute engine = new ComputeServer();
      Compute stub =
          (Compute) UnicastRemoteObject.exportObject(engine, 0);
      Registry registry = LocateRegistry.getRegistry();
      registry.rebind(name, stub);
      System.out.println("ComputeEngine bound");
  } catch (Exception e) {
      System.err.println("ComputeEngine exception:");
      e.printStackTrace();
  }
  }

}
