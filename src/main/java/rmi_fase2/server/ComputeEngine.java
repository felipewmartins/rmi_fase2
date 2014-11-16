package rmi_fase2.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi_fase2.compute.Compute;
import rmi_fase2.compute.Task;

public class ComputeEngine implements Compute, Serializable {

  private static final long serialVersionUID = -2163726111780263507L;

  public  ComputeEngine() {
   super(); // TODO Auto-generated constructor stub
  }

  @Override
  public <T> T executeTask(Task<T> t) throws RemoteException {
    // TODO Auto-generated method stub
    return t.execute();
  }
  
  public static void main(String[] args) {
    /*if (System.getSecurityManager() == null) {
      System.setSecurityManager(new SecurityManager()); //instala a segurança da aplicação
    }*/
    try {
      LocateRegistry.createRegistry(1099);
      System.out.println("RMI registrado na porta 1099");
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    try {
      String name = "Compute";
      Compute engine = new ComputeEngine();
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
