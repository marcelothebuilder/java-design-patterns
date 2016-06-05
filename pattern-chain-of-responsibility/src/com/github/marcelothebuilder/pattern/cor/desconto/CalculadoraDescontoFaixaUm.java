package com.github.marcelothebuilder.pattern.cor.desconto;

public class CalculadoraDescontoFaixaUm extends CalculadoraDescontoPorFaixa {

	public CalculadoraDescontoFaixaUm(CalculadoraDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double getValorMinimo() {
		return 300.00;
	}

	@Override
	protected double getValorTaxa() {
		return 0.04;
	}

}
