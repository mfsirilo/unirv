package controledemilhagem;

import java.io.*;
import java.util.*;
import java.text.*;

public class ControledeMilhagem implements Serializable {

    public static ArrayList gravamentoArquivo(ArrayList arraylist, String enderecoArquivo) {
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

    public static ArrayList leituramentoArquivo(ArrayList arraylist, String enderecoArquivo) {
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

        
        ArrayList<Voos> listaVoos = new ArrayList();
        ArrayList<Clientes> listaclientes = new ArrayList();

        listaVoos = leituramentoArquivo(listaVoos, Metodos.enderecoVoo);
        listaclientes = leituramentoArquivo(listaclientes, Metodos.enderecoCli);

//        listaVoos = leituramentoArquivo(listaVoos, Metodos.enderecoVoolinux);
//        listaclientes = leituramentoArquivo(listaclientes, Metodos.enderecoClilinux);

        Metodos metodos = new Metodos();

        int opcao1, opcao2, opcao3;

        metodos.Menuprincipal();
        opcao1 = scan.nextInt();scan.nextLine();

        while (opcao1 != 0) {

            switch (opcao1) {
                case 1:

                    metodos.menuClientes();
                    opcao2 = scan.nextInt();scan.nextLine();

                    while (opcao2 != 0) {

                        switch (opcao2) {

                            case 1:

                                metodos.limparTela();

                                String nome;
                                String sexo;
                                String cpf;
                                int categoria;
                                String escolha;
                                String escolha2;

                                System.out.println("Informe o nome do cliente");
                                nome = scan.nextLine();
                                System.out.println("Informe o sexo");
                                sexo = scan.nextLine();
                                System.out.println("Informe o CPF");
                                cpf = scan.nextLine();
                                System.out.println("Informe a categoria - 0 Prata, 1 Ouro, 2 Diamante");
                                categoria = scan.nextInt();scan.nextLine();
                                System.out.println(" ====================== ");
                                System.out.println("");

                                int codigoConjuge = -1;
                                
                                metodos.cadastroCliente(listaclientes, nome, sexo, cpf, categoria, codigoConjuge);
                                listaclientes = leituramentoArquivo(listaclientes, Metodos.enderecoCli);

                                metodos.imprimeCliente(listaclientes, Metodos.ultimoCodigo(listaclientes));
                                System.out.println(" ====================== ");
                                
                                //gravamentoArquivo(listaclientes, Metodos.enderecoClilinux);

                                System.out.println("Cliente Cadastrado:");
                                System.out.println("");
                                System.out.println("");

                                System.out.println("Deseja cadastrar um conjuge? \ns - Para sim \nn - Para não");
                                escolha = scan.nextLine();
                                if ((escolha).equals("s")) {
                                    System.out.println("Conjuge já é cliente? \ns - Para sim \nn - Para não");
                                    escolha2 = scan.nextLine();
                                    if ((escolha2).equals("s")) {
                                        metodos.imprimeCliente(listaclientes, 0);
                                        System.out.println("Informe o codigo do conjuge");
                                        int codigoAux = scan.nextInt();scan.nextLine();
                                        
                                        int codigoConjugeCadastrado = listaclientes.get(metodos.retornaIndiceCliente(codigoAux, listaclientes)).getCodCli();
                                        listaclientes.get(listaclientes.size() - 1).setCodConjuge(codigoConjugeCadastrado);
                                        codigoAux = listaclientes.get(listaclientes.size() - 1).getCodCli();
                                        listaclientes.get(metodos.retornaIndiceCliente(codigoConjugeCadastrado, listaclientes)).setCodConjuge(codigoAux);
                                        gravamentoArquivo(listaclientes, Metodos.enderecoCli);
                                        //gravamentoArquivo(listaclientes, Metodos.enderecoClilinux);
                                    } else if ((escolha2).equals("n")) {
                                        System.out.println("Informe o nome do cliente");
                                        nome = scan.nextLine();
                                        System.out.println("Informe o sexo");
                                        sexo = scan.nextLine();
                                        System.out.println("Informe o CPF");
                                        cpf = scan.nextLine();
                                        System.out.println("Informe a categoria - 0 Prata, 1 Ouro, 2 Diamante");
                                        categoria = scan.nextInt();scan.nextLine();
                                        codigoConjuge = listaclientes.get(listaclientes.size()-1).getCodCli();
                                        listaclientes.get(listaclientes.size()-1).setCodConjuge(codigoConjuge+1);
                                        gravamentoArquivo(listaclientes, Metodos.enderecoCli);
                                        metodos.cadastroCliente(listaclientes, nome, sexo, cpf, categoria, codigoConjuge);
                                        listaclientes = leituramentoArquivo(listaclientes, Metodos.enderecoCli);
                                        gravamentoArquivo(listaclientes, Metodos.enderecoCli);
                                    }
                                }
                                break;
                            case 2:
                                
                                metodos.limparTela();
                                //listaclientes = leituramentoArquivo(listaclientes, Metodos.enderecoCli);
                                metodos.excluirCliente(listaclientes);
                                
                                break;
                            case 3:
                                metodos.limparTela();
                                leituramentoArquivo(listaclientes, Metodos.enderecoCli);
                                metodos.imprimeCliente(listaclientes, 0);
                                System.out.println("Informe o codigo do cliente: ");
                                int codigo = scan.nextInt(); scan.nextLine();
                                Clientes auxCli = new Clientes();
                                auxCli = listaclientes.get(Metodos.retornaIndiceCliente(codigo, listaclientes));
                                metodos.limparTela();
                                leituramentoArquivo(listaVoos, Metodos.enderecoVoo);
                                metodos.imprimeVoo(listaVoos);
                                System.out.println("Informe o codigo do voo");
                                codigo = scan.nextInt(); scan.nextLine();
                                Voos auxVoo = new Voos();
                                auxVoo = listaVoos.get(metodos.retornaIndiceVoos(codigo, listaVoos));
                                System.out.println("Informe a data: ");
                                int data = scan.nextInt(); scan.nextLine();
                                System.out.println("Informe a hora: ");
                                int hora = scan.nextInt(); scan.nextLine();
                                metodos.cadastroVoocliente(auxCli, auxVoo, data, hora);
                                break;
                            case 4:
                                metodos.limparTela();
                                metodos.imprimeCliente(listaclientes, 0);
                                System.out.println("Informe o codigo do cliente: ");
                                codigo = scan.nextInt(); scan.nextLine();
                                auxCli = listaclientes.get(Metodos.retornaIndiceCliente(codigo, listaclientes));
                                metodos.excluirVoocliente(auxCli);
                                break;
                            case 5:
                                metodos.limparTela();
                                metodos.imprimeCliente(listaclientes, 0);
                                break;
                        }
                        metodos.menuClientes();
                        opcao2 = scan.nextInt(); scan.nextLine();
                    }
                    metodos.limparTela();
                    metodos.Menuprincipal();
                    opcao1 = scan.nextInt();
                    break;

                case 2:

                    metodos.menuVoo();
                    opcao2 = scan.nextInt();
                    while (opcao2 != 0) {

                        switch (opcao2) {
                            case 1:
                                metodos.limparTela();
                                System.out.println("Informe o codigo do voo:");
                                int codV = scan.nextInt();
                                scan.nextLine();
                                System.out.println("Informe a origem:");
                                String origem = scan.nextLine();
                                System.out.println("Qual o destino?");
                                String destino = scan.nextLine();
                                System.out.println("Eu nao sei calcular a distancia, informa aê mano:");
                                float dist = scan.nextFloat();
                                scan.nextLine();
                                listaVoos = leituramentoArquivo(listaVoos, Metodos.enderecoVoo);
                                metodos.cadastroVoo(listaVoos, codV, origem, destino, dist);
                                break;

                            case 2:
                                metodos.limparTela();
                                System.out.println(" ======================================== ");
                                System.out.println("");
                                metodos.imprimeVoo(listaVoos);
                                break;

                            case 3:
                                metodos.limparTela();
                                System.out.println("Informe o código do voo: ");
                                int codigoVoo = scan.nextInt();
                                listaVoos = leituramentoArquivo(listaVoos, Metodos.enderecoVoo);
                                metodos.excluirVoo(listaVoos, codigoVoo);
                                break;

                        }
                        metodos.menuVoo();
                        opcao2 = scan.nextInt();

                    }
                    metodos.limparTela();
                    metodos.Menuprincipal();
                    opcao1 = scan.nextInt();
                    break;

                case 3:

                    metodos.menuRelatorio();
                    opcao2 = scan.nextInt();
                    while (opcao2 != 0) {
                        switch (opcao2) {
                            case 1:
                                metodos.limparTela();
                                //listaclientes=leituramentoArquivo(listaclientes, Metodos.enderecoCli);
                                metodos.imprimeCliente(listaclientes, 0);
                                System.out.println("Informe o codigo do cliente: ");
                                int codigo = scan.nextInt(); scan.nextLine();
                                metodos.historicoVooCliente(listaclientes, codigo);
                                break;

                            case 2:
                                metodos.limparTela();
                                listaclientes=leituramentoArquivo(listaclientes, Metodos.enderecoCli);
                                listaclientes=leituramentoArquivo(listaVoos, Metodos.enderecoVoo);
                                metodos.imprimeCliente(listaclientes, 0);
                                System.out.println("Informe o codigo do cliente: ");
                                codigo = scan.nextInt(); scan.nextLine();
                                metodos.saldoMilhasIndividual(listaclientes, codigo,listaVoos);
                                break;

                            case 3:
                                metodos.limparTela();
                                listaclientes=leituramentoArquivo(listaclientes, Metodos.enderecoCli);
                                listaclientes=leituramentoArquivo(listaVoos, Metodos.enderecoVoo);
                                metodos.imprimeCliente(listaclientes, 0);
                                System.out.println("Informe o codigo do cliente: ");
                                codigo = scan.nextInt(); scan.nextLine();
                                metodos.saldoMilhasFamiliar(listaclientes, codigo, listaVoos);
                                break;
                        }
                        metodos.menuRelatorio();
                        opcao2 = scan.nextInt();
                    }
                    metodos.limparTela();
                    metodos.Menuprincipal();
                    opcao1 = scan.nextInt();
                    break;
            }

        }
    }

}
