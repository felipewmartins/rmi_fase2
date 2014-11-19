package rmi_fase2.client.task;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;

import rmi_fase2.compute.Task;

@SuppressWarnings("rawtypes")
public class ReadFile implements Task, Serializable {

  private static final long serialVersionUID = -6675528050927057867L;
  private File file;

  public ReadFile(String file) {
    super();// TODO Auto-generated constructor stub
    this.file = new File(file);
  }

  @Override
  public Object execute() {
    // TODO Auto-generated method stub
    StringBuilder sb = new StringBuilder();
    try {
      Files.lines(file.toPath()).forEach(s -> sb.append(s));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sb.toString();

  }

  @Override
  public Object sacar(double valor, int conta) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Object depositar(double valor, int conta) {
    // TODO Auto-generated method stub
    return false;
  }

 
}
