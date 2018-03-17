package br.com.caleum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caleum.financas.modelo.Conta;
import br.com.caleum.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().criaEM();
		
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select max(m.valor) from Movimentacao m where m.conta = :pConta";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		
		BigDecimal result = (BigDecimal) query.getSingleResult();
		
		System.out.println(result);
		
		em.getTransaction().commit();
		em.close();
	}
}
