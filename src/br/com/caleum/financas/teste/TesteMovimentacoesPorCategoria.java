package br.com.caleum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caleum.financas.modelo.Categoria;
import br.com.caleum.financas.modelo.Movimentacao;
import br.com.caleum.financas.util.JPAUtil;

public class TesteMovimentacoesPorCategoria {
	
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().criaEM();
        em.getTransaction().begin();

        Categoria categoria = new Categoria();
        categoria.setId(1);

        String jpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";

        Query query = em.createQuery(jpql);
        query.setParameter("pCategoria", categoria);

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
