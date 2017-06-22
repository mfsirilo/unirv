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
        for (int i = 0; i != 20; ++i) {
            System.out.println("");
        }
    }

    public void Menuprincipal() {
        System.out.println("========================================");
        System.out.println("Informe uma opçcão de acordo com o Menu:");
        System.out.println("Digite 1 para Clientes");
        System.out.println("Digite 2 para Voos");
        System.out.println("Digite 3 para Relatórios");
        System.out.println("");
        System.out.println("Digite 0 para sair");
        System.out.println("");
    }

    public void menuClientes() {
        System.out.println("========================================");
        System.out.println("Digite 1 para cadastrar novo cliente");
        System.out.println("Digite 2 para excluir cliente");
        System.out.println("Digite 3 para cadastrar voo do cliente");
        System.out.println("Digite 4 para excluir voo do cliente");
        System.out.println("");
        System.out.println("Digite 0 para voltar ao Menu Principal");
        System.out.println("");

    }
    //Metodo para cadastrar clientes
    public void cadastroCliente(ArrayList<Clientes> listaclientes, int codCli, String nome, String sexo,
            String cpf, int categoria, int codCon) {
        //Carrega os clientes do arquivo pra lista
        listaclientes = ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);
        
	Clientes cliente = new Clientes(codCli , nome, sexo, cpf, categoria, codCon);
        //Aqui adiciona o objeto cliente na lista de clientes.
        listaclientes.add(cliente);
        
    }

    public void excluirCliente(ArrayList<Clientes> listaclientes, int codigo) {
        listaclientes = ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);
        //Aqui busca o cliente pelo código e usa o método remove para tirar o cliente da lista
        listaclientes.remove(retornaIndiceCliente(codigo, listaclientes));
        

    }
    //Metodo que procurar o indide do cliente dentro do arraylist atrav�s do c�digo
    public static int retornaIndiceCliente(int codigo, ArrayList<Clientes> listaclientes){
            int index = 0;
             for (int i =0; i<listaclientes.size();i++){
                if(listaclientes.get(i).getCodCli()==codigo)
              index = i;
            }
            return index;
    }
    public void cadastroVoocliente(ArrayList<Voocliente> listavoocliente) {
        listavoocliente = ControledeMilhagem.entradaArquivo(listavoocliente, enderecoVocli);

    }

    public void excluirVoocliente(ArrayList<Voocliente> listavoocliente) {
        listavoocliente = ControledeMilhagem.entradaArquivo(listavoocliente, enderecoVocli);

    }

    public void menuVoo() {
        System.out.println("========================================");
        System.out.println("Digite 1 para cadastro de Voo: ");
        System.out.println("Digite 2 para excluir de Voo: ");
        System.out.println("");
        System.out.println("Digite 0 para voltar ao Menu Principal");
        System.out.println("");

    }

    public void cadastroVoo(ArrayList<Voos> listavoo) {

    }

    public void excluirVoo(ArrayList<Voos> listavoo) {

    }

    public void menuRelatorio() {

        System.out.println("Digite 1 para exibição de histórico de voo por cliente");
        System.out.println("Digite 2 para exibição de saldo de milhas individuais");
        System.out.println("Digite 3 para exibição de saldo de milhas familiar");
        System.out.println("");
        System.out.println("Digite 0 para voltar ao Menu Principal");
        System.out.println("");
    }

    public void historicoVooCliente(ArrayList<Clientes> listaclientes, ArrayList<Voocliente> listavoocliente, ArrayList<Voos> listavoos) {
        listaclientes = ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);
        listavoocliente = ControledeMilhagem.entradaArquivo(listavoocliente, enderecoVocli);
        listavoos = ControledeMilhagem.entradaArquivo(listavoos, enderecoVoo);

    }

    public void saldoMilhaindividual(ArrayList<Clientes> listaclientes, ArrayList<Voocliente> listavoocliente, ArrayList<Voos> listavoos) {

    }

}
