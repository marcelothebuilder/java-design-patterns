package com.github.marcelothebuilder.builderpattern2.notafiscal.imposto;

import java.math.BigDecimal;

public class ImpostoNotaFiscalPessoaJuridica extends ImpostoNotaFiscalPercentual {
	private static BigDecimal PERCENTUAL = new BigDecimal("0.04");

	@Override
	protected BigDecimal getPercentual() {
		return PERCENTUAL;
	}
}
