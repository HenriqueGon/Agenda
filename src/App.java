import java.util.List;
import java.util.Scanner;

import entities.Agenda;
import entities.Contato;

public class App {
    private final static Scanner sc = new Scanner(System.in);
    private final static Agenda agenda = new Agenda();
    
    public static void main(String[] args) throws Exception {  
        int opcao;
        
        do {
            opcao = opcoes();

            if (opcao == 0) {
                sc.close();
            } else if (opcao == 1) {
                adicionar();
            } else if (opcao == 2) {
                buscar();
            } else if (opcao == 3) {
                remover();
            } else {
                System.out.println("Opção Inválida \n");
            }
        } while(opcao != 0);
    }

    private static int opcoes() {
        System.out.println("" + 
        "(1) Adicionar um novo contato.\r\n" + 
        "(2) Buscar contatos.\r\n" + 
        "(3) Remover um contato.\r\n" + 
        "(0) Sair. \r\n" + 
        "");

        System.out.println("Digite a opção: ");

        return sc.nextInt();
    }

    private static void adicionar() {
        sc.nextLine();

        System.out.println("Digite o nome do contato: ");
        String nome = sc.nextLine();

        System.out.println("Digite o número do contato: ");
        String numero = sc.nextLine();

        System.out.println("Digite o email do contato: ");
        String email = sc.nextLine();

        agenda.inserir(nome, numero, email);
    }

    private static void buscar() {
        sc.nextLine();
        
        System.out.println("Buscar contatos com: ");
        String dado = sc.nextLine();
        System.out.println("");

        List<Contato> contatosEncontrados = agenda.buscarContato(dado);

        System.out.println(contatosEncontrados.size() + " encontrado(s) \n");

        if (contatosEncontrados.size() > 0) {
            for (Contato contato : contatosEncontrados) {
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Número: " + contato.getNumero());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("");
            }
        }
    }

    private static void remover() {
        List<Contato> contatos = agenda.getContatos();

        if (contatos.size() > 0) {
            System.out.println("");

            for (int i = 0; i < contatos.size(); i++) {
                System.out.println("ID: " + i);
                System.out.println("Nome: " + contatos.get(i).getNome());
                System.out.println("Número: " + contatos.get(i).getNumero());
                System.out.println("Email: " + contatos.get(i).getEmail());
                System.out.println("");
            }

            System.out.println("Digite o ID do contato que deseja remover: ");
            int id = sc.nextInt();

            agenda.remover(contatos.get(id));
        }
    }
}
