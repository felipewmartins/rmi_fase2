package rmi_fase2.compute;

/**
 * Created by caiohenrique on 03/12/14.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}