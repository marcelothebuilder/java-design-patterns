package com.github.marcelothebuilder.builderpattern2.notafiscal.builder;

import com.github.marcelothebuilder.builderpattern2.notafiscal.NotaFiscal;

public interface NotaFiscalBuilderValido {
	NotaFiscalBuilderValido comProduto(String nome, int quantidade, String valor);

	NotaFiscalBuilderValido comProduto(String nome, int quantidade, double valor);

	NotaFiscal construir();
}
