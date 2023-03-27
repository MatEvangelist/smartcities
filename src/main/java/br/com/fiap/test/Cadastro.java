package br.com.fiap.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.ContratoAluguel;
import br.com.fiap.entity.Estabelecimento;
import br.com.fiap.entity.TipoEstabelecimento;

public class Cadastro {

	public static void main(String[] args) {
		EntityManager em = Persistence
				.createEntityManagerFactory("smartcities")
				.createEntityManager();
		
		TipoEstabelecimento tipo = new TipoEstabelecimento(0, "Petshop", null);
		
		Cliente cliente1 = new Cliente(0, "Thiago", null);
		Cliente cliente2 = new Cliente(0, "Leandro", null);
		
		ContratoAluguel contrato = new ContratoAluguel(1, 2000, new GregorianCalendar(2015, Calendar.JANUARY, 10), null);
		
		List<Cliente> lista = new ArrayList<>();
		lista.add(cliente1);
		lista.add(cliente2);
		
		Estabelecimento est1 = new Estabelecimento(0, "Fiap Pet", null, null, tipo);
		Estabelecimento est2 = new Estabelecimento(0, "Poyatos Dog", null, contrato, tipo);
		
		contrato.setEstabelecimento(est2);
		
		em.persist(est1);
		em.persist(est2);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
	}
}
