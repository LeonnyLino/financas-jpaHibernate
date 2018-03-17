package br.com.caleum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caleum.financas.modelo.Conta;
import br.com.caleum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {

	private EntityManager em;
	
	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {
		//avg(m.valor) tirando a media dos valores de movimentação
		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo" + " order by m.valor desc";
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAÍDA);
			
		
		return query.getResultList();
	}
	
}
