package controledemilhagem;

import java.io.*;
import java.util.*;

public class Metodos implements Serializable {

//    String enderecoCli = "/home/marcos/Documentos/pratica3/Trabalhos/Clientes.bin";
//    String enderecoVocli = "/home/marcos/Documentos/pratica3/Trabalhos/VooCliente.bin";
//    String enderecoVoo = "/home/marcos/Documentos/pratica3/Trabalhos/Voo.bin";
    static String enderecoCli = "C:\\Users\\Bruno\\Desktop\\Facul\\ControleMilhagemClientes\\Clientes.bin";
    static String enderecoVocli = "C:\\Users\\Bruno\\Desktop\\Facul\\ControleMilhagemClientes\\VooCliente.bin";
    static String enderecoVoo = "D:\\Facul\\ControleMilhagemClientes\\Voo.bin";

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
    public void cadastroCliente(ArrayList<Clientes> listaclientes, String nome, String sexo,
            String cpf, int categoria, int CodConjuge) {
        Metodos cadastrocliente = new Metodos();
        //Carrega os clientes do arquivo pra lista
        listaclientes = ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
        Clientes cliente = new Clientes(codC, nome, sexo, cpf, categoria, CodConjuge);
        if (listaclientes.size() > 0) {
            int ultimocliente = listaclientes.get(listaclientes.size() - 1).getCodCli();
            cliente.setCodCli(ultimocliente + 1);//parte do codigo que seta 
            listaclientes.add(cliente);
            ControledeMilhagem.gravamentoArquivo(listaclientes, enderecoCli);
            cliente = listaclientes.get(codC);
            codC++;
        }else {
            listaclientes.add(cliente);
            ControledeMilhagem.gravamentoArquivo(listaclientes, enderecoCli);
            cliente = listaclientes.get(codC);
            codC++;
        }
    }
//        if ((escolha).equals("s")) {
//            //Inserir metodo de imprimir os conjuges ou codigos dos conjuges 
//
//            for (Clientes listacliente : listaclientes) {
//                System.out.println("Os codigos são: " + listacliente.getCodConjuge());
//            }
//            System.out.println("Verifique se o conjuge possui código cadastrado?");
//            escolha2 = scan.next();
//            if ((escolha2).equals("n")) {
//                //chamar função de cadastro novamente, para cadastrar o conjuge 
//                cadastrocliente.cadastroCliente(listaclientes);
//
//                int ultimoconjuge = listaclientes.get(listaclientes.size() - 1).getCodConjuge();
//
//                cliente.setCodConjuge(ultimoconjuge + 1);//parte do codigo que seta 
//                listaclientes.add(cliente);
//                ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
//                cliente = listaclientes.get(CodConjuge);
//                CodConjuge++;
//
//                ControledeMilhagem.gravamentoArquivo(listaclientes, enderecoCli);
//            } else {
//                listaclientes.add(cliente);
//                ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
//                cliente = listaclientes.get(codC);
//                codC++;
//
//                listaclientes.add(cliente);
//                ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
//                cliente = listaclientes.get(CodConjuge);
//                CodConjuge++;
//            }
//        }
//    }
//
//    else if (listaclientes.size () 
//        > 0) {
//            int ultimocliente = listaclientes.get(listaclientes.size() - 1).getCodCli();
//        cliente.setCodConjuge(ultimocliente + 1);//parte do codigo que seta 
//        listaclientes.add(cliente);
//        ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
//        cliente = listaclientes.get(codC);
//        codC++;
//        ControledeMilhagem.gravamentoArquivo(listaclientes, enderecoCli);
//
//    }
//
//    
//        else {
//            listaclientes.add(cliente);
//        ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
//        cliente = listaclientes.get(codC);
//        codC++;
//    }
//    //ControledeMilhagem.gravamentoArquivo(listaclientes, enderecoCli);
//
//    System.out.println (
//
//"");
//
//        //Aqui adiciona o objeto cliente na lista de clientes.
//        //listaclientes.add(cliente);
//    }

    public void excluirCliente(ArrayList<Clientes> listaclientes) {
        listaclientes = ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
        //Aqui busca o cliente pelo código e usa o método remove para tirar o cliente da lista
        System.out.println("Informe o codigo do cliente");
        int codigo = scan.nextInt();
        listaclientes.remove(retornaIndiceCliente(codigo, listaclientes));

    }

    //Metodo que procurar o indide do cliente dentro do arraylist atrav�s do c�digo
    public static int retornaIndiceCliente(int codigo, ArrayList<Clientes> listaclientes) {
        int index = 0;
        for (int i = 0; i < listaclientes.size(); i++) {
            if (listaclientes.get(i).getCodCli() == codigo) {
                index = i;
            }
        }
        return index;
    }
    public void imprimeCliente(ArrayList<Clientes> listaclientes, int codigo){
        String NomeConjuge;
        int indiceconjuge;
        int codC;
        if (codigo==0){
            for(Clientes cli: listaclientes){
                System.out.println("Codigo: " + cli.getCodCli());
                System.out.println("Nome: " + cli.getNome());
                System.out.println("Sexo: " + cli.getSexo());
                System.out.println("CPF: " + cli.getCpf());
                System.out.println("Categoria: " + cli.getCategoria());
                System.out.println("Codigo do Conjuge: " + cli.getCodConjuge());
                indiceconjuge = retornaIndiceCliente(cli.getCodConjuge(), listaclientes);
                NomeConjuge = listaclientes.get(retornaIndiceCliente(cli.getCodConjuge(),
                        listaclientes)).getNome();
                System.out.println("Nome Conjuge: " + NomeConjuge);
            }
        }else{
            int indice = retornaIndiceCliente(codigo, listaclientes);
            System.out.println("Codigo: " + listaclientes.get(indice).getCodCli());
            System.out.println("Nome: " + listaclientes.get(indice).getNome());
            System.out.println("Sexo: " + listaclientes.get(indice).getSexo());
            System.out.println("CPF: " + listaclientes.get(indice).getCpf());
            System.out.println("Categoria: " + listaclientes.get(indice).getCategoria());
            codC = listaclientes.get(indice).getCodConjuge();
            System.out.println("Codigo do Conjuge: " + codC);
            indiceconjuge = retornaIndiceCliente(codC, listaclientes);
            NomeConjuge = listaclientes.get(indiceconjuge).getNome();
                System.out.println("Nome Conjuge: " + NomeConjuge);                                      
        }
    }

    public void cadastroVoocliente(ArrayList<Voocliente> listavoocliente) {
        listavoocliente = ControledeMilhagem.leituramentoArquivo(listavoocliente, enderecoVocli);

    }

    public void excluirVoocliente(ArrayList<Voocliente> listavoocliente) {
        listavoocliente = ControledeMilhagem.leituramentoArquivo(listavoocliente, enderecoVocli);

    }

    public void menuVoo() {
        System.out.println("========================================");
        System.out.println("Digite 1 para cadastro de Voo: ");
        System.out.println("Digite 2 para excluir de Voo: ");
        System.out.println("");
        System.out.println("Digite 0 para voltar ao Menu Principal");
        System.out.println("");

    }

    public void cadastroVoo(ArrayList<Voos> listaVoos, int codV, String origem, String destino, float dist) {
        /*O codigo de voos não é incremental, o codigo de voo é definido de acordo com a compania
        *Escala cidades e etc. Então o usuário q vai digitar.
         */
        Voos voo = new Voos(codV, origem, destino, dist);
        listaVoos.add(voo);
        ControledeMilhagem.gravamentoArquivo(listaVoos, enderecoVoo);
    }

    public void excluirVoo(ArrayList<Voos> listavoo, int codigo) {
        listavoo.remove(retornaIndiceVoos(codigo, listavoo));
    }

    public static int retornaIndiceVoos(int codigo, ArrayList<Voos> listaVoos) {
        int index = 0;
        for (int i = 0; i < listaVoos.size(); i++) {
            if (listaVoos.get(i).getCodigoVoo() == codigo) {
                index = i;
            }
        }
        return index;
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
        listaclientes = ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
        listavoocliente = ControledeMilhagem.leituramentoArquivo(listavoocliente, enderecoVocli);
        listavoos = ControledeMilhagem.leituramentoArquivo(listavoos, enderecoVoo);

    }

    public void saldoMilhasIndividual(ArrayList<Clientes> listaclientes, ArrayList<Voocliente> listavoocliente, ArrayList<Voos> listavoos) {
        listaclientes = ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
        listavoocliente = ControledeMilhagem.leituramentoArquivo(listavoocliente, enderecoVocli);
        listavoos = ControledeMilhagem.leituramentoArquivo(listavoos, enderecoVoo);

    }

    public void saldoMilhasFamiliar(ArrayList<Clientes> listaclientes, ArrayList<Voocliente> listavoocliente, ArrayList<Voos> listavoos) {
        listaclientes = ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
        listavoocliente = ControledeMilhagem.leituramentoArquivo(listavoocliente, enderecoVocli);
        listavoos = ControledeMilhagem.leituramentoArquivo(listavoos, enderecoVoo);

    }

}
