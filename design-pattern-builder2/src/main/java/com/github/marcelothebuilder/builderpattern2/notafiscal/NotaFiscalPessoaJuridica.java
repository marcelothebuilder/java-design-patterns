package com.github.marcelothebuilder.builderpattern2.notafiscal;

import com.github.marcelothebuilder.builderpattern2.notafiscal.imposto.ImpostoNotaFiscal;
import com.github.marcelothebuilder.builderpattern2.notafiscal.imposto.ImpostoNotaFiscalPessoaJuridica;

public class NotaFiscalPessoaJuridica extends NotaFiscal {

	@Override
	protected ImpostoNotaFiscal recuperaCalculadoraImposto() {
		return new ImpostoNotaFiscalPessoaJuridica();
	}

}
