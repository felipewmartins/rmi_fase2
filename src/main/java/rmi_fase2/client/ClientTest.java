package rmi_fase2.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi_fase2.interfaces.Teste;

public class ClientTest {
  static Teste obj = null;
  static String message = "branco";
  public static void main(String[] args) {
    try {
      obj = (Teste)Naming.lookup("//"
          + "kvist.cs.umu.se"
          + "/Hello");
      message = obj.teste();
    } catch (MalformedURLException | RemoteException | NotBoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
