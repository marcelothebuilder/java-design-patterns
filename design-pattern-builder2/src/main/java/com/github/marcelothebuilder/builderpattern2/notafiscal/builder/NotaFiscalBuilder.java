package com.github.marcelothebuilder.builderpattern2.notafiscal.builder;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.github.marcelothebuilder.builderpattern2.notafiscal.ItemNotaFiscal;
import com.github.marcelothebuilder.builderpattern2.notafiscal.NotaFiscal;
import com.github.marcelothebuilder.builderpattern2.notafiscal.NotaFiscalPessoaFisica;
import com.github.marcelothebuilder.builderpattern2.notafiscal.NotaFiscalPessoaJuridica;

public class NotaFiscalBuilder
		implements NotaFiscalBuilderSemNumero, NotaFiscalBuilderSemData, NotaFiscalBuilderValido {
	private NotaFiscal notaFiscal;

	private NotaFiscalBuilder() {
	}

	public static NotaFiscalBuilderSemNumero notaPessoaFisica() {
		NotaFiscalBuilder builder = new NotaFiscalBuilder();
		builder.notaFiscal = new NotaFiscalPessoaFisica();
		return builder;
	}

	public static NotaFiscalBuilderSemNumero notaPessoaJuridica() {
		NotaFiscalBuilder builder = new NotaFiscalBuilder();
		builder.notaFiscal = new NotaFiscalPessoaJuridica();
		return builder;
	}

	@Override
	public NotaFiscalBuilderSemData comNumero(long numero) {
		this.notaFiscal.setNumero(numero);
		return this;
	}

	@Override
	public NotaFiscalBuilderValido comProduto(String nome, int quantidade, String valor) {
		ItemNotaFiscal item = this.getItemNotaFiscalSemValor(nome, quantidade);
		item.setValor(new BigDecimal(valor));
		this.notaFiscal.getItemsNotaFiscal().add(item);
		return this;
	}

	@Override
	public NotaFiscalBuilderValido comProduto(String nome, int quantidade, double valor) {
		ItemNotaFiscal item = this.getItemNotaFiscalSemValor(nome, quantidade);
		item.setValor(new BigDecimal(valor));
		this.notaFiscal.getItemsNotaFiscal().add(item);
		return this;
	}

	@Override
	public NotaFiscalBuilderValido comDataEmissao(String dataEmissao) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
		Date date = sdf.parse(dataEmissao);
		this.notaFiscal.setDataEmissao(date);
		return this;
	}

	@Override
	public NotaFiscal construir() {
		return this.notaFiscal;
	}

	/*
	 * METODOS HELPER
	 */

	private ItemNotaFiscal getItemNotaFiscalSemValor(String nome, int quantidade) {
		ItemNotaFiscal item = new ItemNotaFiscal();
		item.setNome(nome);
		item.setQuantidade(quantidade);
		return item;
	}
}
