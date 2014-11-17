package rmi_fase2.server;

import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi_fase2.compute.Compute;
import rmi_fase2.compute.ServersNames;
import rmi_fase2.compute.Task;

public class Coodenador extends ServerGenerico implements Compute, Serializable {

  private static final long serialVersionUID = -2163726111780263507L;

  private ServersNames servAtual;

  public Coodenador(String name, int port) {
    super(name, port);

  }

  @Override
  public <T> T executeTask(Task<T> t) {
    // TODO Auto-generated method stub
    return gereciaConexao(t);
  }

  public <T> T gereciaConexao(Task<T> t) {
    T result = executarNoServer(servAtual, t);
    servAtual =
        servAtual == ServersNames.PARTICIPANTE_1 ? ServersNames.PARTICIPANTE_2
            : ServersNames.PARTICIPANTE_1;
    return result;

  }

  private <T> T executarNoServer(ServersNames server, Task<T> t) {
    T retorno = null;
    try {
      Registry registry = LocateRegistry.getRegistry(server.getPort());
      Compute comp = (Compute) registry.lookup(server.name());
      retorno = comp.executeTask(t);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return retorno;
  }

}
