package com.github.marcelothebuilder.patternstrategy.model;

public class CalculadoraPremioSeguroParaCarro implements CalculadoraPremioSeguro {

	@Override
	public double calcular(Cliente cliente, Double valorVeiculo) {
		return valorVeiculo*0.15;
	}

}
