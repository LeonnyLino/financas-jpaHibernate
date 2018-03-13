package br.com.caleum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caleum.financas.modelo.Conta;
import br.com.caleum.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().criaEM();
		
		em.getTransaction().begin();
		
		//consultas para reala��es do tipo ...ToMany "Lazy"
		String jpql = "select c from Conta c join fetch c.movimentacoes";
		
		Query query = em.createQuery(jpql);
		
		List<Conta> todasAsContas = query.getResultList();
		
		for(Conta conta : todasAsContas) {
			System.out.println("Titular" + conta.getTitular());
			System.out.println("Movimentacoes");
			System.out.println(conta.getMovimentacoes());
		}
		
		
		
		em.getTransaction().commit();
		em.close();
	}
}