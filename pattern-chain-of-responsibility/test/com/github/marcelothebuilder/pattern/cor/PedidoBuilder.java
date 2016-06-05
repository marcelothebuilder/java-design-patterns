package com.github.marcelothebuilder.pattern.cor;

import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDesconto;
import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDescontoFaixaDois;
import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDescontoFaixaTres;
import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDescontoFaixaUm;
import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDescontoSemDesconto;

public class PedidoBuilder {

	private Pedido instancia;
	
	public PedidoBuilder() {
		CalculadoraDesconto calculadoraDesconto = new CalculadoraDescontoFaixaTres(
				new CalculadoraDescontoFaixaDois(
						new CalculadoraDescontoFaixaUm(
								new CalculadoraDescontoSemDesconto())));

		this.instancia = new Pedido(calculadoraDesconto);
	}
	
	public Pedido construir() {
		return this.instancia;
	}

	public PedidoBuilder comItem(double valorItem, int quantidade) {
		instancia.adicionarItem(new ItemPedido("Item", valorItem, quantidade));
		return this;
	}

}
