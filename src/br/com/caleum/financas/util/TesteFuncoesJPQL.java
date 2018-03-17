package br.com.caleum.financas.util;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caleum.financas.dao.MovimentacaoDao;
import br.com.caleum.financas.modelo.Conta;
import br.com.caleum.financas.modelo.Movimentacao;
import br.com.caleum.financas.modelo.TipoMovimentacao;
import br.com.caleum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().criaEM();
		Conta conta = new Conta();
		conta.setId(2);
		
		//sum(m.valor) somando todos os valores das movimentações da tabela
//		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo" + " order by m.valor desc";
		
		MovimentacaoDao dao = new MovimentacaoDao(em);
		List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAÍDA, conta);
		
		
		
	}
}
