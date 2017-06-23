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
    int codC = 0, codCV = 0, codV = 0, CodConjuge = 0;

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
    public void cadastroCliente(ArrayList<Clientes> listaclientes) {
    Metodos cadastrocliente = new Metodos();
        //Carrega os clientes do arquivo pra lista
        
        listaclientes = ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);

        String nome;
        String sexo;
        String cpf;
        int categoria;
        String escolha;
        String escolha2;

        System.out.println("Informe o nome do cliente");
        nome = scan.next();
        System.out.println("Informe o sexo");
        sexo = scan.next();
        System.out.println("Informe o CPF");
        cpf = scan.next();
        System.out.println("Informe a categoria - ");
        categoria = scan.nextInt();
        System.out.println("Deseja cadastrar um conjuge? \ns - Para sim \nn - Para não");
        escolha = scan.next();

        Clientes cliente = new Clientes(codC, nome, sexo, cpf, categoria, CodConjuge);

        if ((escolha).equals("s")) {
            //Inserir metodo de imprimir os conjuges ou codigos dos conjuges 
            
            for(Clientes listacliente :listaclientes){
                System.out.println("Os codigos são: "+ listacliente.getCodConjuge());
            }
            System.out.println("Verifique se o conjuge possui código cadastrado?");
            escolha2 = scan.next();
            if ((escolha2).equals("n")) {
                //chamar função de cadastro novamente, para cadastrar o conjuge 
                cadastrocliente.cadastroCliente(listaclientes);
                
                if (listaclientes.size() > 0) {
                    int ultimocliente = listaclientes.get(listaclientes.size() - 1).getCodCli();
                    cliente.setCodConjuge(ultimocliente + 1);//parte do codigo que seta 
                    listaclientes.add(cliente);
                    ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);
                    cliente = listaclientes.get(codC);
                    codC++;

                    int ultimoconjuge = listaclientes.get(listaclientes.size() - 1).getCodConjuge();

                    cliente.setCodConjuge(ultimoconjuge + 1);//parte do codigo que seta 
                    listaclientes.add(cliente);
                    ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);
                    cliente = listaclientes.get(CodConjuge);
                    CodConjuge++;

                    ControledeMilhagem.saidaArquivo(listaclientes, enderecoCli);
                } else {
                    listaclientes.add(cliente);
                    ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);
                    cliente = listaclientes.get(codC);
                    codC++;

                    listaclientes.add(cliente);
                    ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);
                    cliente = listaclientes.get(CodConjuge);
                    CodConjuge++;
                }
            }
        } else if (listaclientes.size() > 0) {
            int ultimocliente = listaclientes.get(listaclientes.size() - 1).getCodCli();
            cliente.setCodConjuge(ultimocliente + 1);//parte do codigo que seta 
            listaclientes.add(cliente);
            ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);
            cliente = listaclientes.get(codC);
            codC++;
            ControledeMilhagem.saidaArquivo(listaclientes, enderecoCli);

        } else {
            listaclientes.add(cliente);
            ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);
            cliente = listaclientes.get(codC);
            codC++;
        }
        ControledeMilhagem.saidaArquivo(listaclientes, enderecoCli);
        System.out.println("");

        //Aqui adiciona o objeto cliente na lista de clientes.
        //listaclientes.add(cliente);
    }

    public void excluirCliente(ArrayList<Clientes> listaclientes) {
        listaclientes = ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);
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

    public void cadastroVoo(ArrayList<Voos> listaVoos) {
        /*O codigo de voos não é incremental, o codigo de voo é definido de acordo com a compania
        *Escala cidades e etc. Então o usuário q vai digitar.
         */
        System.out.println("Informe o codigo do voo:");
        codV = scan.nextInt();
        scan.nextLine();
        System.out.println("Informe a origem:");
        String origem = scan.nextLine();
        System.out.println("Qual o destino?");
        String destino = scan.nextLine();
        System.out.println("Eu nao sei calcular a distancia, informa aê mano:");
        float dist = scan.nextFloat();
        scan.nextLine();
        Voos voo = new Voos(codV, origem, destino, dist);
        listaVoos.add(voo);
    }

    public void excluirVoo(ArrayList<Voos> listavoo) {
        System.out.println("Informe o código do voo: ");
        int codigo = scan.nextInt();
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
        listaclientes = ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);
        listavoocliente = ControledeMilhagem.entradaArquivo(listavoocliente, enderecoVocli);
        listavoos = ControledeMilhagem.entradaArquivo(listavoos, enderecoVoo);

    }

    public void saldoMilhasIndividual(ArrayList<Clientes> listaclientes, ArrayList<Voocliente> listavoocliente, ArrayList<Voos> listavoos) {
        listaclientes = ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);
        listavoocliente = ControledeMilhagem.entradaArquivo(listavoocliente, enderecoVocli);
        listavoos = ControledeMilhagem.entradaArquivo(listavoos, enderecoVoo);

    }

    public void saldoMilhasFamiliar(ArrayList<Clientes> listaclientes, ArrayList<Voocliente> listavoocliente, ArrayList<Voos> listavoos) {
        listaclientes = ControledeMilhagem.entradaArquivo(listaclientes, enderecoCli);
        listavoocliente = ControledeMilhagem.entradaArquivo(listavoocliente, enderecoVocli);
        listavoos = ControledeMilhagem.entradaArquivo(listavoos, enderecoVoo);

    }

}
