package rmi_fase2.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Teste extends Remote {
  String teste() throws RemoteException;
}
