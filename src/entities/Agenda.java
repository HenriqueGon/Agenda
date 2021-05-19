package entities;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
  
  private ArrayList<Contato> contatos = new ArrayList<Contato>();
  
  public Agenda() {}
  
  public List<Contato> getContatos() {
    return this.contatos;
  }

  public void inserir(String nome, String numero, String email) {
    this.contatos.add(new Contato(nome, numero, email));

    System.out.println("Contato salvo!");
  }

  public List<Contato> buscarPorNome(String nome) {
    ArrayList<Contato> contatosEncontrados = new ArrayList<Contato>();

    for (Contato contato : this.contatos) {
      if (contato.getNome().equals(nome)) {
        contatosEncontrados.add(contato);
      }
    }

    return contatosEncontrados;
  }

  public void remover(Contato contato) {
    contatos.remove(contato);

    System.out.println("Contato removido!");
  }
}
