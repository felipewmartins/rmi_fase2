package rmi_fase2.servers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Coodernador extends UnicastRemoteObject {

  protected Coodernador() throws RemoteException {
    super();
    // TODO Auto-generated constructor stub
  }
  
  public String teste(){

      return "Deu certo!";
  }

  private static final long serialVersionUID = -2319453752009526824L;

  public static void main(String[] args) throws IOException {
    //String line = System.getProperty("line.separator");
    //File fileLog = new File("log-servidor-1");
    //FileWriter fw = new FileWriter(fileLog);
    //fw.close();
    Coodernador c = new Coodernador();
    try {
      Naming.rebind("Teste", c);
      System.out.println("Conectado no registro...");
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
