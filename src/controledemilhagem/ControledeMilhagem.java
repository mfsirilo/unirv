package controledemilhagem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.text.*;

public class ControledeMilhagem {
    
    public static ArrayList saidaArquivo(ArrayList arraylist, String enderecoArquivo) {

        try {
            FileOutputStream saida = new FileOutputStream(enderecoArquivo);
            ObjectOutputStream escritorObjetos = new ObjectOutputStream(saida);
            escritorObjetos.writeObject(arraylist);
            saida.close();
            System.out.println("Arquivo Gravado!!");
            return arraylist;
        } catch (Exception e) {
            System.out.println("ERRO!");
            return arraylist;
        }
    }

    public static ArrayList entradaArquivo(ArrayList arraylist, String enderecoArquivo) {

        try {
            InputStream entrada = new FileInputStream(enderecoArquivo);
            ObjectInputStream leitorObjetos = new ObjectInputStream(entrada);
            arraylist = (ArrayList) leitorObjetos.readObject();
            entrada.close();
            return arraylist;
        } catch (Exception e) {
            System.out.println("Erro");
            return arraylist;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        ArrayList<Voocliente> listavoocliente = new ArrayList();
        ArrayList<Voos> listavoos = new ArrayList();
        ArrayList<Clientes> listaclientes = new ArrayList();
        
        Clientes client = new Clientes();
        Metodos metodos = new Metodos();
        
        int opcao1, opcao2;
        
        metodos.Menuprincipal();
        opcao1 = scan.nextInt();
        while(opcao1!=0){
            switch(opcao1){
                case 1:
                    metodos.
                    
            }
            
        }
    }

}
