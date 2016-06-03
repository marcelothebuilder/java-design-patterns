package com.github.marcelothebuilder.builderpattern2.notafiscal.imposto;

import java.math.BigDecimal;

public class ImpostoNotaFiscalPessoaFisica extends ImpostoNotaFiscalPercentual {
	private static BigDecimal PERCENTUAL = new BigDecimal("0.07");

	@Override
	protected BigDecimal getPercentual() {
		return PERCENTUAL;
	}
}
