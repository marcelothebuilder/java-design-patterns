package com.github.marcelothebuilder.builderpattern2.notafiscal.builder;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import com.github.marcelothebuilder.builderpattern2.notafiscal.NotaFiscal;

public class NotaFiscalBuilderTest {
	@Test(expected = ParseException.class)
	public void testComDataEmissaoIncorreta() throws ParseException {
		NotaFiscalBuilderTest.getSemData().comDataEmissao("89/01");
		NotaFiscalBuilderTest.getSemData().comDataEmissao("89/22");
	}

	@Test
	public void testComDataEmissaoCorreta() throws ParseException {
		NotaFiscalBuilderTest.getSemData().comDataEmissao("11/12/2012");
	}

	@Test
	public void testComValores() throws ParseException {
		NotaFiscal nf = NotaFiscalBuilder.notaPessoaFisica().comNumero(5L).comDataEmissao("12/11/1993")
				.comProduto("Produto", 4, 4.0).comProduto("Produto2", 10, "4").construir();

		Assert.assertEquals(56.0, nf.getSubtotal().doubleValue(), Double.MIN_NORMAL);

		Assert.assertEquals(3.92, nf.getValorImpostos().doubleValue(), Double.MIN_NORMAL);

		Assert.assertEquals(59.92, nf.getValorTotal().doubleValue(), Double.MIN_NORMAL);
	}

	private static NotaFiscalBuilderSemData getSemData() {
		return NotaFiscalBuilder.notaPessoaFisica().comNumero(5L);
	}

}
