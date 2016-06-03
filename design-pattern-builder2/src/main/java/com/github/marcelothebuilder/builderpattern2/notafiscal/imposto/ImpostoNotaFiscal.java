package com.github.marcelothebuilder.builderpattern2.notafiscal.imposto;

import java.math.BigDecimal;

public interface ImpostoNotaFiscal {
	BigDecimal calculaValor(BigDecimal valorBase);
}
