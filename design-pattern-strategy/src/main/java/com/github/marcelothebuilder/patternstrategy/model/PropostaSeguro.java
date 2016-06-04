package com.github.marcelothebuilder.patternstrategy.model;

public class PropostaSeguro {
	private CalculadoraPremioSeguro calculadora;
	private Cliente cliente;
	private double valorVeiculo;
	
	public void setValorVeiculo(double valorVeiculo) {
		this.valorVeiculo = valorVeiculo;
	}

	public void setCalculadora(CalculadoraPremioSeguro calculadora) {
		this.calculadora = calculadora;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String gerar() {
		return "Prêmio: "+calculadora.calcular(cliente, valorVeiculo);
		
	}
}
