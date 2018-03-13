package br.com.caleum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caleum.financas.modelo.Conta;
import br.com.caleum.financas.util.JPAUtil;

public class TesteBuscas {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().criaEM();
		
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 4);
		
		conta.setTitular("João");
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
	}
}
