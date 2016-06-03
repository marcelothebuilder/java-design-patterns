package com.github.marcelothebuilder.builderpattern2.notafiscal;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class ItemNotaFiscalTest {
	@Test
	public void deveTestarValorTotal() {
		ItemNotaFiscal item = new ItemNotaFiscal();
		item.setQuantidade(5);
		item.setValor(new BigDecimal("30"));

		Assert.assertEquals(150.00, item.getValorTotal().doubleValue(), Double.MIN_NORMAL);
	}
}
