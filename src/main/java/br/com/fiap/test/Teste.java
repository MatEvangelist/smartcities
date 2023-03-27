package br.com.fiap.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Estabelecimento;

public class Teste {

	@Test
	public void execCadastro() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("smartcities");
		EntityManager em = factory.createEntityManager();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Poyatos");
		
		try {
			em.persist(cliente);
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		em.close();
		factory.close();
	}
		
	@Test
	public void execBusca() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("smartcities");
		EntityManager em = factory.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 1);
		
		System.out.println(cliente.getId() + " " + cliente.getNome());
		
		em.close();
		factory.close();
	}
	
	@Test
	public void execAltera() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("smartcities");
		EntityManager em = factory.createEntityManager();
		
		Cliente cliente = new Cliente(1, "Thiago", null);
				
		em.merge(cliente);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}
	
	@Test
	public void execExclui() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("smartcities");
		EntityManager em = factory.createEntityManager();
		
		Cliente cliente = em.find(Cliente.class, 1);
		em.remove(cliente);
		
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		em.close();
		factory.close();
	}
	
	@Test
	public void exec() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("smartcities");
		EntityManager em = factory.createEntityManager();

		em.close();
		factory.close();
	}

	@Test
	public void exec1() {
		EntityManager em = null;
		try {
			em = Persistence.createEntityManagerFactory("smartcities").createEntityManager();
			Estabelecimento est = new Estabelecimento();
			est.setId(1);
			est.setNome("Bar do Joao");
			em.merge(est);
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}
	}

	@Test
	public void exec2() {
		Persistence.createEntityManagerFactory("smartcities").createEntityManager();
		
	}

	@Test
	public void exec3() {
		Persistence.createEntityManagerFactory("smartcities").createEntityManager();
	}

}
