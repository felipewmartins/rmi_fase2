package rmi_fase2.servers;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Coodernador extends UnicastRemoteObject {

  protected Coodernador() throws RemoteException {
    super();
    // TODO Auto-generated constructor stub
  }

  private static final long serialVersionUID = -2319453752009526824L;

  public static void main(String[] args) throws RemoteException {
    Coodernador c = new Coodernador();
    try {
      Naming.rebind("Teste", c);
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
