package com.github.marcelothebuilder.builderpattern2.notafiscal.imposto;

import java.math.BigDecimal;

public abstract class ImpostoNotaFiscalPercentual implements ImpostoNotaFiscal {

	protected abstract BigDecimal getPercentual();

	@Override
	public BigDecimal calculaValor(BigDecimal valorBase) {
		return valorBase.multiply(this.getPercentual());
	}

}
