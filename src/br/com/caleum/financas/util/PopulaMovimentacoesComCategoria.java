package br.com.caleum.financas.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caleum.financas.modelo.Categoria;
import br.com.caleum.financas.modelo.Conta;
import br.com.caleum.financas.modelo.Movimentacao;
import br.com.caleum.financas.modelo.TipoMovimentacao;
import br.com.caleum.financas.util.JPAUtil;

public class PopulaMovimentacoesComCategoria {

	public static void main(String[] args) {
		
		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		
		Categoria categoria1 = new Categoria();
		categoria1.setNome("viagem");
		Categoria categoria2 = new Categoria();
		categoria2.setNome("negocios");
		
		Conta conta = new Conta();
        conta.setId(2); 
		
		Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setData(Calendar.getInstance()); //hoje
        movimentacao1.setDescricao("Viagem � SP");
        movimentacao1.setTipo(TipoMovimentacao.SA�DA);
        movimentacao1.setValor(new BigDecimal("100.0"));
        movimentacao1.setCategorias(Arrays.asList(categoria1, categoria2));
        movimentacao1.setConta(conta);
        
        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setData(amanha); // amanha
        movimentacao2.setDescricao("Viagem ao RJ");
        movimentacao2.setTipo(TipoMovimentacao.SA�DA);
        movimentacao2.setValor(new BigDecimal("300.0"));
        movimentacao2.setCategorias(Arrays.asList(categoria1, categoria2));
        movimentacao2.setConta(conta);
        
        EntityManager em = new JPAUtil().criaEM();
        
        em.getTransaction().begin();
        
        em.persist(categoria1);
        em.persist(categoria2);
        
        em.persist(movimentacao1);
        em.persist(movimentacao2);
        em.getTransaction().commit();
        em.close();
        
        

	}
}
