package daos;

import java.util.List;

import javax.persistence.EntityManager;

import infra.EntityManagerFactoryProducer;

import entities.Contato;

public class ContatoDao {
	
	private final EntityManager entityManager;
	
	public ContatoDao() {
		this.entityManager = EntityManagerFactoryProducer.createEntityManager();
	}
	
	public ContatoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	private EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	public void inserir(Contato contato) {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(contato);
			getEntityManager().getTransaction().commit();
			
			System.out.println("Contato salvo! \n");
		} catch (Exception ex) {
			getEntityManager().getTransaction().rollback();
			System.out.println("Um erro ocorreu durante o cadastro do contato!");
			System.out.println("Erro: " + ex.getMessage());
		}
	}
	
	public void remover(long id) {
		Contato contato = getContatoPorId(id);
		
		if (contato != null) {
			try {
				getEntityManager().getTransaction().begin();
				getEntityManager().remove(contato);
				getEntityManager().getTransaction().commit();
				System.out.println("Contato excluido!");
			} catch (Exception ex) {
				System.out.println("Um erro ocorreu durante a exclusao do contato!");
				System.out.println("Erro: " + ex.getMessage());
			}
			
		} else {
			System.out.println("Erro: Contato nao encontrado!");
		}
	}
	
	public Contato getContatoPorId(long id) {
		return getEntityManager().find(Contato.class, id);
	}
	
	public List<Contato> getTodosContatos() {
		return getEntityManager().createQuery("from Contato", Contato.class).getResultList();
	}
	
	public void finalizar() {
		if (getEntityManager().isOpen()) {
			getEntityManager().close();
		}
	}
}
