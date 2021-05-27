package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import daos.ContatoDao;

public class Agenda {
	
	private final ContatoDao contatoDao = new ContatoDao();
   
	public Agenda() {}
  
	public List<Contato> getContatos() {
		List<Contato> contatos = contatoDao.getTodosContatos();
		return contatos;
	}

	public void inserir(String nome, String numero, String email) {
		if (nome.isEmpty() || nome == null) {
			System.out.println("Nome Invalido \n");
	    } else if (numero.isEmpty() || numero == null) {
	      System.out.println("Numero Invalido \n");
	    } else if (email.isEmpty() || email == null || !emailValido(email)) {
	      System.out.println("Email Invalido \n");
	    } else {
	    	contatoDao.inserir(new Contato(nome, numero, email));
	    }
	}

	public List<Contato> buscarContato(String dado) {
		ArrayList<Contato> contatosEncontrados = new ArrayList<Contato>();
		List<Contato> contatos = contatoDao.getTodosContatos();
		
		if (!dado.isEmpty() && dado != null) {
			for (Contato contato : contatos) {
				if (contato.getNome().contains(dado) || contato.getNumero().contains(dado) || contato.getEmail().contains(dado)) {
					contatosEncontrados.add(contato);
				}
			}
		} else {
			System.out.println("Dado Invalido!");
		}

		return contatosEncontrados;
	}

	public void remover(Contato contato) {
		contatoDao.remover(contato.getId());
	}

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
	
	public void close() throws Exception {
		contatoDao.finalizar();
	}
}
