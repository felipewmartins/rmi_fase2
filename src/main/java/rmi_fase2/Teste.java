package rmi_fase2;


import rmi_fase2.client.Participante1;

import java.io.IOException;

/**
 * Created by caiohenrique on 16/11/14.
 */
public class Teste {

    public static void main (String args[]){


        Participante1 u = new Participante1();

        try{
            u.depositar(200,123);
            u.sacar(1000,123);
        }
        catch (IOException e){
            System.out.println(e);
        }

    }
}
