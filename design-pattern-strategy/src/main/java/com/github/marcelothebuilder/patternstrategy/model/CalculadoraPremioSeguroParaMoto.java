package com.github.marcelothebuilder.patternstrategy.model;

public class CalculadoraPremioSeguroParaMoto implements CalculadoraPremioSeguro {

	@Override
	public double calcular(Cliente cliente, Double valorVeiculo) {
		return valorVeiculo*0.3;
	}

}
