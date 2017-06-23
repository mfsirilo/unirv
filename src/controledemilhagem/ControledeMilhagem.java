package controledemilhagem;

import java.io.*;
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

        ArrayList<Voocliente> listaVooClientes = new ArrayList();
        ArrayList<Voos> listaVoos = new ArrayList();
        ArrayList<Clientes> listaclientes = new ArrayList();

        
        Metodos metodos = new Metodos();

        int opcao1, opcao2, opcao3;

        metodos.Menuprincipal();
        opcao1 = scan.nextInt();

        while (opcao1 != 0) {

            switch (opcao1) {
                case 1:

                    metodos.menuClientes();
                    opcao2 = scan.nextInt();

                    while (opcao2 != 0) {

                        switch (opcao2) {
                            case 1:
                                metodos.limparTela();
                                metodos.cadastroCliente(listaclientes);
                                System.out.println("Cliente Cadastrado:");
                                //o metodo abaixo deverá imprimir o último cliente cadastrado.
                                metodos.imprimeCliente(listaclientes, (listaclientes.size()-1));
                                System.out.println("O Cliente possui conjuge?");
                                
                                        
                                break;
                            case 2:
                                metodos.limparTela();
                                metodos.excluirCliente(listaclientes);
                                break;
                            case 3:
                                metodos.limparTela();
                                metodos.cadastroVoocliente(listaVooClientes);
                                break;
                            case 4:
                                metodos.limparTela();
                                metodos.excluirVoocliente(listaVooClientes);
                                break;

                        }
                        metodos.limparTela();
                        metodos.menuClientes();
                        opcao2 = scan.nextInt();
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
                                int codV = scan.nextInt(); scan.nextLine();
                                System.out.println("Informe a origem:");
                                String origem = scan.nextLine();
                                System.out.println("Qual o destino?");
                                String destino = scan.nextLine();
                                System.out.println("Eu nao sei calcular a distancia, informa aê mano:");
                                float dist = scan.nextFloat(); scan.nextLine();
                                metodos.cadastroVoo(listaVoos, codV, origem, destino, dist);
                                break;

                            case 2:
                                metodos.limparTela();
                                System.out.println("Informe o código do voo: ");
                                int codigoVoo = scan.nextInt();
                                metodos.excluirVoo(listaVoos, codigoVoo);
                                break;

                        }
                        metodos.limparTela();
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
                                metodos.historicoVooCliente(listaclientes, listaVooClientes, listaVoos);
                                break;

                            case 2:
                                metodos.limparTela();
                                metodos.saldoMilhasIndividual(listaclientes, listaVooClientes, listaVoos);
                                break;

                            case 3:
                                metodos.limparTela();
                                metodos.saldoMilhasFamiliar(listaclientes, listaVooClientes, listaVoos);
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
