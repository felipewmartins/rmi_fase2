package rmi_fase2.client;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import rmi_fase2.compute.Compute;
import rmi_fase2.compute.ServersNames;
import rmi_fase2.compute.Task;

public class Cliente{
  
  private OperacaoImpl oper;
  
  public Cliente() throws RemoteException {
   super(); // TODO Auto-generated constructor stub
   oper = new OperacaoImpl();
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void main(String[] args) throws IOException {
    
    boolean continua = true;  
      
    try (Scanner sc = new Scanner(System.in)){
      Registry registry = LocateRegistry.getRegistry(ServersNames.COORDENADOR.getPort());
      Compute comp = (Compute)registry.lookup(ServersNames.COORDENADOR.name());
      
      System.out.println("/////////////////////////////////////////////////////\n");
      System.out.println("////////////////OPERADOR BANCÁRIO///////////////////\n");
      System.out.println("Conta disponível: 123");
      System.out.println("Opção 1 - Sacar");
      System.out.println("Opção 2 - Depositar");
      System.out.println("Opção 3 - Consultar");
      System.out.println("Opção 4 - Sair");
      
      while(continua){
        String opcao = sc.next();
        
        switch (opcao) {
          case "1":
            System.out.println("Digite o valor que deseja sacar -->");
            double valor = sc.nextDouble();
            OperacaoImpl oper = new OperacaoImpl();
            boolean retorno  = (boolean) comp.executeTask((Task) oper.sacar(valor, 123));
            System.out.println(retorno);
            break;
          case "2":
            double valor2 = sc.nextDouble();
            OperacaoImpl oper2 = new OperacaoImpl();
            System.out.println("Digite o valor que deseja depositar -->");
            boolean retornoDeposito = (boolean) comp.executeTask((Task) oper2.depositar(valor2, 123));
            System.out.println(retornoDeposito);

          default:
            break;
        }
      }
        
      
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

}
