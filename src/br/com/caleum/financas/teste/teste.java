package br.com.caleum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caleum.financas.modelo.Conta;

public class teste {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.setTitular("Leonny");
		conta.setAgencia("4020-7");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("42.106-7");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}
}
