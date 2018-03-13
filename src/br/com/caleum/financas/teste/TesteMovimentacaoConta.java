package br.com.caleum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caleum.financas.modelo.Conta;
import br.com.caleum.financas.modelo.Movimentacao;
import br.com.caleum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().criaEM();
		
		em.getTransaction().begin();
		Movimentacao movimentacao = em.find(Movimentacao.class, 3);
		Conta conta = movimentacao.getConta();
		System.out.println(movimentacao.getConta().getTitular());
		
		System.out.println(conta.getMovimentacoes().size());
		
		
		em.getTransaction().commit();
		em.close();
	}
}
