package rmi_fase2.controle;

import rmi_fase2.client.Participante1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Operacoes extends GeraTxt{
	
    private String msg;
    private GeraTxt gera = new GeraTxt();

    public void sacar(double valor, int conta, double saldo) throws IOException {

        System.out.println("Iniciando Operaçao--------------------------\n");

        if(saldo <= 0 | valor > saldo){
            System.out.println("Impossivel sacar. Saldo atual.:" + saldo);
        }
        else {
            System.out.println("Saldo atual.:" + saldo);
            saldo = saldo - valor;
            msg = "Conta.: "+conta+" | Sacou.:"+valor;
            System.out.println(msg);

            gera.extrato(conta, msg);
        }

        System.out.println("\nFinalizando Operaçao ------------------------");

    }

    public void depositar(double valor, int conta, double saldo) throws IOException {

        System.out.println("\nIniciando Operaçao ---------------------------");

        if(saldo <= 0){
            System.out.println("Impossivel depositar, Saldo atual.: " + saldo);
        }
        else{
            msg = "Conta.: "+conta+" | Depositou.:"+valor+" para a conta.: "+conta;
            valor = valor - saldo;
            System.out.println(msg);
            //falta forma de identificar conta e acessar para depositar

            gera.extrato(conta, msg);

        }

        System.out.println("\nFinalizando Operaçao ------------------------");

    }

}
