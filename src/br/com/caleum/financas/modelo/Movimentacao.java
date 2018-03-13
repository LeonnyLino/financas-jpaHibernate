package br.com.caleum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movimentacao {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private BigDecimal valor;
		@Enumerated(EnumType.STRING)// por ser um "enum" o banco ir� registrar no tipo varchar os valores
		private TipoMovimentacao tipo;
		@Temporal(TemporalType.TIMESTAMP)
		private Calendar data;
		@ManyToOne //anota�ao para indicar a cardinalidade do relacionamento entre movaimenta�ao e conta
		private Conta conta; //muitos pra um (*1)
		private String descricao;
		@ManyToMany
		private List<Categoria> categorias;
		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public BigDecimal getValor() {
			return valor;
		}
		public void setValor(BigDecimal valor) {
			this.valor = valor;
		}
		public TipoMovimentacao getTipo() {
			return tipo;
		}
		public void setTipo(TipoMovimentacao tipo) {
			this.tipo = tipo;
		}
		public Calendar getData() {
			return data;
		}
		public void setData(Calendar data) {
			this.data = data;
		}
		public Conta getConta() {
			return conta;
		}
		public void setConta(Conta conta) {
			this.conta = conta;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public List<Categoria> getCategorias() {
			return categorias;
		}
		public void setCategorias(List<Categoria> categorias) {
			this.categorias = categorias;
		}
		
		
}
