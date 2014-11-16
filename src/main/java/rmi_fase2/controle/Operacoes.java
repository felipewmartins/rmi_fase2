package rmi_fase2.controle;

public abstract class Operacoes {
	
	private String nome;
    private double saldo;
    private int conta;
    private String msg;

    public void sacar(double valor) {

        System.out.println("Iniciando Operaçao");

        if(saldo <= 0){
            System.out.println("Impossivel sacar. Saldo atual.:" + saldo);
        }
        else {
            saldo = saldo - valor;
            System.out.println("Saldo atual.:" + saldo);
            msg = "Usuario.: "+nome+" /n Sacou.:"+valor;
        }

        System.out.println("Finalizando Operaçao");
    }

    public void depositar(double valor, int conta) {

        System.out.println("Iniciando Operaçao");

        if(saldo <= 0){
            System.out.println("Impossivel depositar, Saldo atual.: " + saldo);
        }
        else{
            valor = valor - saldo;
            msg = "Usuario.: "+nome+" /n Depositou.:"+valor+" para a conta.: "+conta;
            //forma de identificar conta e acessar para depositar
        }

        System.out.println("Finalizando Operaçao");

    }

    public void extrato() {

    }

}
