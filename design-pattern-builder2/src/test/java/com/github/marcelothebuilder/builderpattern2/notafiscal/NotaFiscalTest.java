package com.github.marcelothebuilder.builderpattern2.notafiscal;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class NotaFiscalTest {
	@Test
	public void deveTestarSubtotal() {
		ItemNotaFiscal itemNotaFiscal = new ItemNotaFiscal();
		itemNotaFiscal.setQuantidade(4);
		itemNotaFiscal.setValor(new BigDecimal("4"));
		// 16

		ItemNotaFiscal itemNotaFiscal2 = new ItemNotaFiscal();
		itemNotaFiscal2.setQuantidade(10);
		itemNotaFiscal2.setValor(new BigDecimal("4"));
		// 40

		NotaFiscal nf = new NotaFiscalPessoaFisica();
		nf.getItemsNotaFiscal().add(itemNotaFiscal);
		nf.getItemsNotaFiscal().add(itemNotaFiscal2);

		Assert.assertEquals(56.0, nf.getSubtotal().doubleValue(), Double.MIN_NORMAL);

		Assert.assertEquals(3.92, nf.getValorImpostos().doubleValue(), Double.MIN_NORMAL);

		Assert.assertEquals(59.92, nf.getValorTotal().doubleValue(), Double.MIN_NORMAL);

	}
}
