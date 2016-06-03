package com.github.marcelothebuilder.builderpattern2.notafiscal.imposto;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class ImpostoNotaFiscalTest {

	@Test
	public void testCalculaValorJuridica() {
		ImpostoNotaFiscal imposto = new ImpostoNotaFiscalPessoaJuridica();

		Double sete = new BigDecimal("4").doubleValue();
		Double impostoDeCem = imposto.calculaValor(new BigDecimal("100")).doubleValue();

		Assert.assertEquals(sete, impostoDeCem, 0.0);
	}

	@Test
	public void testCalculaValorFisica() {
		ImpostoNotaFiscal imposto = new ImpostoNotaFiscalPessoaFisica();

		Double sete = new BigDecimal("7").doubleValue();
		Double impostoDeCem = imposto.calculaValor(new BigDecimal("100")).doubleValue();

		Assert.assertEquals(sete, impostoDeCem, 0.0);
	}

}
