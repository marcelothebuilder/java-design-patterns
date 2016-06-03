package com.github.marcelothebuilder.builderpattern2.notafiscal.builder;

import java.text.ParseException;

public interface NotaFiscalBuilderSemData {
	NotaFiscalBuilderValido comDataEmissao(String dataEmissao) throws ParseException;
}
