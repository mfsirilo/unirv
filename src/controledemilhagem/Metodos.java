package controledemilhagem;

import java.io.*;
import java.util.*;

public class Metodos {

    String enderecoCli = "/home/marcos/Documentos/pratica3/Trabalhos/Clientes.bin";
    String enderecoVocli = "/home/marcos/Documentos/pratica3/Trabalhos/VooCliente.bin";
    String enderecoVoo = "/home/marcos/Documentos/pratica3/Trabalhos/Voo.bin";

    /*String enderecoCli = "C:\\Users\\Bruno\\Desktop\\Facul\\ControleMilhagemClientes.bin";
    String enderecoVocli = "C:\\Users\\Bruno\\Desktop\\Facul\\ControleMilhagemClientes.bin";
    String enderecoVoo = "C:\\Users\\Bruno\\Desktop\\Facul\\ControleMilhagemClientes.bin";
    */


    Scanner scan = new Scanner(System.in);
    int codC = 0, codCV = 0, codV = 0;

    public static void limparTela() {
        for (int i = 0; i != 100; ++i) {
            System.out.println("");
        }
    }

    public void Menuprincipal() {
        System.out.println("========================================");
        System.out.println("Informe uma opçcão de acordo com o Menu:");
        System.out.println("Digite 0 para sair");
        System.out.println("Digite 1 para Clientes");
        System.out.println("Digite 2 para Voos");
        System.out.println("");
    }

    public void menuClientes() {
        System.out.println("========================================");
        System.out.println("Digite 1 para cadastrar novo cliente");
        System.out.println("Digite 2 para excluir cliente");
        System.out.println("Digite 3 para exibir todos os clientes");
        System.out.println("Digite 4 para cadastrar voo do cliente");
        System.out.println("Digite 5 para excluir voo do cliente");

    }

    public void cadastroCliente(ArrayList<Clientes> listaclientes) {
        listaclientes = ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);

        String nome;
        String sexo;
        int cpf;
        int categoria;
        int codCon;
    }

    public void excluirCliente(){
        
    }

    public static void CadastroVoo(ArrayList<Voos> listavoo) {

    }

}
