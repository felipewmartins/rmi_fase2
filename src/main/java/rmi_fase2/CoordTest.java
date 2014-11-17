package rmi_fase2;

import rmi_fase2.server.Participante1;
import rmi_fase2.compute.ServersNames;
import rmi_fase2.server.Coodenador;
import rmi_fase2.server.ServerGenerico;

public class CoordTest {
  public static void main(String[] args) {
    ServerGenerico  c = new Coodenador(ServersNames.COORDENADOR.name(), ServersNames.COORDENADOR.getPort());
    ServerGenerico p1 = new Participante1(ServersNames.PARTICIPANTE_1.name(), ServersNames.PARTICIPANTE_1.getPort());
    c.iniciarServer();
    p1.iniciarServer();
  }
}
