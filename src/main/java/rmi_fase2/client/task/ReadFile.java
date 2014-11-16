package rmi_fase2.client.task;

import java.io.File;

import rmi_fase2.compute.Task;

@SuppressWarnings("rawtypes")
public class ReadFile implements Task {
  private File file;

  public ReadFile(String file) {
    super();// TODO Auto-generated constructor stub
    this.file = new File(file);
  }

  @Override
  public Object execute() {
    // TODO Auto-generated method stub
    return null;
  }


}
