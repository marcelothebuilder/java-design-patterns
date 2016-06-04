package com.github.marcelothebuilder.patternstrategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.marcelothebuilder.patternstrategy.model.CalculadoraPremioSeguroParaCarro;
import com.github.marcelothebuilder.patternstrategy.model.CalculadoraPremioSeguroParaMoto;
import com.github.marcelothebuilder.patternstrategy.model.Cliente;
import com.github.marcelothebuilder.patternstrategy.model.PropostaSeguro;
import com.github.marcelothebuilder.patternstrategy.model.Sexo;

public class PropostaSeguroTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		PropostaSeguro proposta = new PropostaSeguro();
		proposta.setValorVeiculo(5_000.0);
		Cliente cliente = new Cliente();
		cliente.setIdade(19);
		cliente.setNome("Rodrigo");
		cliente.setSexo(Sexo.MASCULINO);
		proposta.setCliente(cliente);
		proposta.setCalculadora(new CalculadoraPremioSeguroParaCarro());
		assertEquals("Prêmio: 750.0", proposta.gerar());
		proposta.setCalculadora(new CalculadoraPremioSeguroParaMoto());
		assertEquals("Prêmio: 1500.0", proposta.gerar());
	}

}
