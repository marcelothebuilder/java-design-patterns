package com.github.marcelothebuilder.pattern.cor.desconto;

public class CalculadoraDescontoSemDesconto implements CalculadoraDesconto {
	@Override
	public double calcula(double valorTotal) {
		return 0.0;
	}

}
