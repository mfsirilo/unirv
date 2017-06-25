package controledemilhagem;

import java.io.*;
import java.util.*;

public class Metodos implements Serializable {

    static String enderecoCli = "D:\\Facul\\ControleMilhagem\\Clientes.bin";
    static String enderecoVocli = "D:\\Facul\\ControleMilhagem\\VooClientes.bin";
    static String enderecoVoo = "D:\\Facul\\ControleMilhagem\\Voo.bin";

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
        System.out.println("Digite 5 para imprimir TODOS os clientes");
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
        } else {
            listaclientes.add(cliente);
            ControledeMilhagem.gravamentoArquivo(listaclientes, enderecoCli);

            cliente = listaclientes.get(codC);
            codC++;
        }
    }
    
    //Metodo de chamamento do ultimo codigo. 
    public static int ultimoCodigo(ArrayList<Clientes> listaclientes) {
        listaclientes = ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
        int ultimocodigo = listaclientes.get(listaclientes.size()-1).getCodCli();
        return ultimocodigo;
    }

    public void excluirCliente(ArrayList<Clientes> listaclientes) {
        listaclientes = ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);

        //Aqui busca o cliente pelo código e usa o método remove para tirar o cliente da lista
        System.out.println("Informe o codigo do cliente");
        int codigo = scan.nextInt();
        listaclientes.remove(retornaIndiceCliente(codigo, listaclientes));
        listaclientes = ControledeMilhagem.gravamentoArquivo(listaclientes, enderecoCli);

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

    public void imprimeCliente(ArrayList<Clientes> listaclientes, int codigo) {
        String NomeConjuge;
        listaclientes = ControledeMilhagem.leituramentoArquivo(listaclientes, enderecoCli);
        int indiceconjuge;
        int codC;
        if (codigo == 0) {
            System.out.println("=======================================");
            System.out.println("Lista de todos os clientes");
            System.out.println("=======================================");
            for (Clientes cli : listaclientes) {
                System.out.println("Codigo: " + cli.getCodCli());
                System.out.println("Nome: " + cli.getNome());
                System.out.println("Sexo: " + cli.getSexo());
                System.out.println("CPF: " + cli.getCpf());
                System.out.println("Categoria: " + cli.getCategoria());
                System.out.println("Codigo do Conjuge: " + cli.getCodConjuge());
                if (cli.getCodConjuge() == -1) {
                    NomeConjuge = "Não informado";
                } else {
                    NomeConjuge = listaclientes.get(retornaIndiceCliente(cli.getCodConjuge(),
                            listaclientes)).getNome();
                }
                System.out.println("Nome Conjuge: " + NomeConjuge);
                System.out.println("----------------------------------");
            }
        } else {
            int indice = retornaIndiceCliente(codigo, listaclientes);
            System.out.println("=======================================");
            System.out.println("Indice: " + indice);
            System.out.println("Codigo: " + listaclientes.get(indice).getCodCli());
            System.out.println("Nome: " + listaclientes.get(indice).getNome());
            System.out.println("Sexo: " + listaclientes.get(indice).getSexo());
            System.out.println("CPF: " + listaclientes.get(indice).getCpf());
            System.out.println("Categoria: " + listaclientes.get(indice).getCategoria());
            codC = listaclientes.get(indice).getCodConjuge();
            System.out.println("Codigo do Conjuge: " + codC);
            if (codC == -1) {
                NomeConjuge = "Não informado";
            } else {
                NomeConjuge = listaclientes.get(retornaIndiceCliente(codC,
                        listaclientes)).getNome();
            }
            System.out.println("Nome Conjuge: " + NomeConjuge);
            System.out.println("=======================================");
        }
    }

    public void menuVoo() {
        System.out.println("========================================");
        System.out.println("Digite 1 para cadastro de Voo: ");
        System.out.println("Digite 2 para imprimir todos Voos cadastrados: ");
        System.out.println("Digite 3 para excluir de Voo: ");
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

    public void imprimeVoo(ArrayList<Voos> listaVoos) {
        ControledeMilhagem.leituramentoArquivo(listaVoos, enderecoVoo);
        for (Voos voo : listaVoos) {
            System.out.println("Codigo: " + voo.getCodigoVoo());
            System.out.println("Codigo: " + voo.getOrigem());
            System.out.println("Codigo: " + voo.getDestino());
            System.out.println("Codigo: " + voo.getDistancia());
            System.out.println("---------------------------------");
        }
        System.out.println("");
        System.out.println("FIM DA LISTA DE VOOS");
        System.out.println("");

    }

    public void excluirVoo(ArrayList<Voos> listavoo, int codigo) {
        listavoo.remove(retornaIndiceVoos(codigo, listavoo));
    }

    public void cadastroVoocliente(ArrayList<Clientes> listaclientes) {
        //listavoocliente = ControledeMilhagem.leituramentoArquivo(listavoocliente, enderecoVocli);
        String enderecoArquivo;
        enderecoArquivo = "D:\\Facul\\ControleMilhagem\\" + listaclientes.get(1).getNome()+listaclientes.get(1).getCodCli()+".bin";
        System.out.println("Endereço teste -> " + enderecoArquivo);
    }

    public void excluirVoocliente(ArrayList<Voocliente> listavoocliente) {
        listavoocliente = ControledeMilhagem.leituramentoArquivo(listavoocliente, enderecoVocli);

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
