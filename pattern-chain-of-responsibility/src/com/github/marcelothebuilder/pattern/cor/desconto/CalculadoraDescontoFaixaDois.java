package com.github.marcelothebuilder.pattern.cor.desconto;

public class CalculadoraDescontoFaixaDois extends CalculadoraDescontoPorFaixa {

	public CalculadoraDescontoFaixaDois(CalculadoraDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double getValorMinimo() {
		return 800.00;
	}

	@Override
	protected double getValorTaxa() {
		return 0.06;
	}

}
