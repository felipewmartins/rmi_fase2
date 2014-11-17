package rmi_fase2.compute;

public enum ServersNames {

  COORDENADOR,
  PARTICIPANTE_1,
  PARTICIPANTE_2;
  
  public int getPort(){
    return ordinal()+2000;
  }
}
