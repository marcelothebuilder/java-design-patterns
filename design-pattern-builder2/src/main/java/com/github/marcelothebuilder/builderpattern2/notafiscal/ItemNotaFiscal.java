package com.github.marcelothebuilder.builderpattern2.notafiscal;

import java.math.BigDecimal;

public class ItemNotaFiscal {
	private String nome;
	private Integer quantidade;
	private BigDecimal valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorTotal() {
		BigDecimal bigQuantidade = new BigDecimal(this.quantidade);
		return this.valor.multiply(bigQuantidade);
	}
}
