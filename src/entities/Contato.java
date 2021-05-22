package entities;

public class Contato {

  private String nome = "";
  private String numero = "";
  private String email = "";

  public Contato(String nome, String numero, String email) {
    this.nome = nome;
    this.numero = numero;
    this.email = email;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNumero() {
    return this.numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

