package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agenda {
  
  private ArrayList<Contato> contatos = new ArrayList<Contato>();
  
  public Agenda() {}
  
  public List<Contato> getContatos() {
    return this.contatos;
  }

  public void inserir(String nome, String numero, String email) {
    if (nome.isEmpty() || nome == null) {
      System.out.println("Nome Inválido \n");
    } else if (numero.isEmpty() || numero == null) {
      System.out.println("Número Inválido \n");
    } else if (email.isEmpty() || email == null || !emailValido(email)) {
      System.out.println("Email Inválido \n");
    } else {
      this.contatos.add(new Contato(nome, numero, email));

      System.out.println("Contato salvo! \n");
    }
  }

  public List<Contato> buscarContato(String dado) {
    ArrayList<Contato> contatosEncontrados = new ArrayList<Contato>();
    
    if (!dado.isEmpty() && dado != null) {
      for (Contato contato : this.contatos) {
        if (contato.getNome().contains(dado) || contato.getNumero().contains(dado) || contato.getEmail().contains(dado)) {
          contatosEncontrados.add(contato);
        }
      }
    } else {
      System.out.println("Dado Inválido!");
    }

    return contatosEncontrados;
  }

  public void remover(Contato contato) {
    this.contatos.remove(contato);

    System.out.println("Contato removido! \n");
  }

  //Método encontrado na internet.
  private static boolean emailValido(String email) {
    boolean emailValido = false;

    String regex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(email);

    if (matcher.matches()) {
      emailValido = true;
    }
    
    return emailValido;
  }
}
