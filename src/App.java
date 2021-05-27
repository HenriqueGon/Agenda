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
            	agenda.close();
                return;
            }

            switch(opcao) {
                case 1:
                    inserir();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    remover();
                    break;
                default:   
                    System.out.println("Opcao Invalida \n");
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

        System.out.println("Digite a opcao: ");

        return sc.nextInt();
    }

    private static void inserir() {
        sc.nextLine();

        System.out.println("Digite o nome do contato: ");
        String nome = sc.nextLine();

        System.out.println("Digite o numero do contato: ");
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
                System.out.println("Numero: " + contato.getNumero());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("");
            }
        }
    }

    private static void remover() {
        List<Contato> contatos = agenda.getContatos();

        if (contatos.size() > 0) {
            System.out.println("");

            for (Contato contato : contatos) {
                System.out.println("ID: " + (contato.getId() - 1));
                System.out.println("Nome: " + contato.getNome());
                System.out.println("Numero: " + contato.getNumero());
                System.out.println("Email: " + contato.getEmail());
                System.out.println("");
            }

            System.out.println("Digite o ID do contato que deseja remover: ");
            int id = sc.nextInt();
            
            System.out.println(contatos.get(id));
            
            try {
            	agenda.remover(contatos.get(id));
            } catch(Exception ex) {
            	System.out.println("Ocorreu um erro");
            }
        }
    }
}
