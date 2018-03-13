package br.com.caleum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caleum.financas.modelo.Cliente;
import br.com.caleum.financas.modelo.Conta;
import br.com.caleum.financas.util.JPAUtil;

public class TestaContaCliente {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
        cliente.setNome("Leonny");
        cliente.setEndereco("Rua Fulano, 123");
        cliente.setProfissao("Professor");
        
        Conta conta = new Conta();
        conta.setId(2);
        
        cliente.setConta(conta);
        
        EntityManager em = new JPAUtil().criaEM();
        
        em.getTransaction().begin();
        
        em.persist(cliente);
        
        em.getTransaction().commit();
        em.close();
	}
}
