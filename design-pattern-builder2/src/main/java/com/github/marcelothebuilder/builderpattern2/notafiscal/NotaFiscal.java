package com.github.marcelothebuilder.builderpattern2.notafiscal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.marcelothebuilder.builderpattern2.notafiscal.imposto.ImpostoNotaFiscal;

public abstract class NotaFiscal {
	private Long numero;
	private Date dataEmissao;
	private List<ItemNotaFiscal> itemsNotaFiscal = new ArrayList<>();

	protected abstract ImpostoNotaFiscal recuperaCalculadoraImposto();

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public List<ItemNotaFiscal> getItemsNotaFiscal() {
		return itemsNotaFiscal;
	}

	public void setItemsNotaFiscal(List<ItemNotaFiscal> itemsNotaFiscal) {
		this.itemsNotaFiscal = itemsNotaFiscal;
	}

	public BigDecimal getSubtotal() {
		BigDecimal subTotal = BigDecimal.ZERO;
		for (ItemNotaFiscal itemNotaFiscal : itemsNotaFiscal) {
			subTotal = subTotal.add(itemNotaFiscal.getValorTotal());
		}
		return subTotal;
	}

	public BigDecimal getValorImpostos() {
		ImpostoNotaFiscal calculadora = this.recuperaCalculadoraImposto();
		return calculadora.calculaValor(this.getSubtotal());
	}

	public BigDecimal getValorTotal() {
		BigDecimal subtotal = this.getSubtotal();
		BigDecimal valorImpostos = this.getValorImpostos();
		return subtotal.add(valorImpostos);
	}

}
