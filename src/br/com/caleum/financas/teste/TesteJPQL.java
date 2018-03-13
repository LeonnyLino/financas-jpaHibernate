package br.com.caleum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caleum.financas.modelo.Conta;
import br.com.caleum.financas.modelo.Movimentacao;
import br.com.caleum.financas.modelo.TipoMovimentacao;
import br.com.caleum.financas.util.JPAUtil;

public class TesteJPQL {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().criaEM();
		Conta conta = new Conta();
		conta.setId(2);
		em.getTransaction().begin();
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo" + " order by m.valor desc";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAÍDA);
		List<Movimentacao> resultados = query.getResultList();
		
		for(Movimentacao movimentacao : resultados) {
			System.out.println("Descrição " + movimentacao.getDescricao());
			System.out.println("Conta.id " + movimentacao.getConta().getId());
			System.out.println("Conta.id " + movimentacao.getTipo());
			System.out.println("Conta.id " + movimentacao.getValor());
		}
		em.getTransaction().commit();
		em.close();
	}
}
