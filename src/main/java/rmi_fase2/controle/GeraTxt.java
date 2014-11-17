package rmi_fase2.controle;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by caiohenrique on 16/11/14.
 */
public class GeraTxt {

    public void extrato(int conta, String msg) throws IOException {

        if(conta==123) {

            FileWriter user1 = new FileWriter("Usuario1.txt");
            PrintWriter gravaUser1 = new PrintWriter(user1);

            gravaUser1.printf("--------------\n");

            gravaUser1.printf(msg);

            gravaUser1.printf("\n--------------");

            user1.close();
        }
        else if(conta==124){

            FileWriter user2 = new FileWriter("Usuario2.txt");
            PrintWriter gravaUser2 = new PrintWriter(user2);
            gravaUser2.printf(msg);
        }
        else
            System.out.println("Conta nao existe");
    }

}
