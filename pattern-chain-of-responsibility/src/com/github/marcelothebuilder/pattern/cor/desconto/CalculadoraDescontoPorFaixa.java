package com.github.marcelothebuilder.pattern.cor.desconto;

public abstract class CalculadoraDescontoPorFaixa implements CalculadoraDesconto {
	
	protected CalculadoraDesconto proximo;
	
	public CalculadoraDescontoPorFaixa(CalculadoraDesconto proximo) {
		this.proximo = proximo;
	}
	
	protected abstract double getValorMinimo();
	protected abstract double getValorTaxa();
	
	@Override
	public double calcula(double valorTotal) {
		if (valorTotal >= this.getValorMinimo()) {
			return valorTotal * this.getValorTaxa();
		}		
		
		return this.proximo.calcula(valorTotal);
	}

}
