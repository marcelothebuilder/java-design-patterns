package com.github.marcelothebuilder.pattern.cor;

import java.util.ArrayList;
import java.util.List;

import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDesconto;
import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDescontoFaixaDois;
import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDescontoFaixaTres;
import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDescontoFaixaUm;
import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDescontoSemDesconto;

public class Pedido {
	private List<ItemPedido> itensPedido = new ArrayList<>();
	private CalculadoraDesconto calculadoraDesconto;

	public Pedido(CalculadoraDesconto calculadoraDesconto) {
		this.calculadoraDesconto = calculadoraDesconto;
	}

	public void adicionarItem(ItemPedido itemPedido) {
		validaQuantidade(itemPedido);
		itensPedido.add(itemPedido);
	}

	private void validaQuantidade(ItemPedido itemPedido) {
		if (itemPedido.getQuantidade() < 0) {
			throw new QuantidadeInvalidaException("Não é possível adicionar itens com quantidade negativa");
		}
	}

	public ResumoPedido resumo() {
		double valorTotal = itensPedido.stream().mapToDouble(i -> i.getQuantidade() * i.getValorUnitario()).sum();

		double valorDesconto = calculadoraDesconto.calcula(valorTotal);

		ResumoPedido resumo = new ResumoPedido();
		resumo.setValorDesconto(valorDesconto);
		resumo.setValorTotal(valorTotal);
		return resumo;
	}
}
