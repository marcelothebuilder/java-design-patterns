package com.github.marcelothebuilder.pattern.cor.desconto;

public class CalculadoraDescontoFaixaTres extends CalculadoraDescontoPorFaixa {

	public CalculadoraDescontoFaixaTres(CalculadoraDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double getValorMinimo() {
		return 1000.00;
	}

	@Override
	protected double getValorTaxa() {
		return 0.08;
	}

}
