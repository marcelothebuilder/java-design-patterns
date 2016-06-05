package com.github.marcelothebuilder.pattern.cor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.marcelothebuilder.pattern.cor.Pedido;
import com.github.marcelothebuilder.pattern.cor.ResumoPedido;
import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDesconto;
import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDescontoFaixaDois;
import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDescontoFaixaTres;
import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDescontoFaixaUm;
import com.github.marcelothebuilder.pattern.cor.desconto.CalculadoraDescontoSemDesconto;

public class PedidoTest {
	private PedidoBuilder pedido;

	@Before
	public void setUp() throws Exception {
		pedido = new PedidoBuilder();
	}

	@Test
	public void devePermitirAdicionarUmItem() throws Exception {
		pedido.comItem(3.0, 10);
	}

	@Test
	public void deveCalcularValorTotalParaPedidoVazio() throws Exception {
		assertEquals(0.0, pedido.construir().resumo().getValorTotal(), 0.0001);
	}

	@Test
	public void deveCalcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		double valorTotal = 0.0;
		double desconto = 0.0;
		assertResumoDoPedido(valorTotal, desconto);
	}

	private void assertResumoDoPedido(double valorTotal, double desconto) {
		ResumoPedido resumo = pedido.construir().resumo();

		ResumoPedido resumoCompare = new ResumoPedido();
		resumoCompare.setValorDesconto(desconto);
		resumoCompare.setValorTotal(valorTotal);
		
		assertEquals(resumoCompare, resumo);
	}

	@Test
	public void deveCalcularResumoParaItemSemDesconto() throws Exception {
		pedido.comItem(5.00, 5);
		assertResumoDoPedido(25.0, 0);
	}

	@Test
	public void deveCalcularResumoParaDoisItensSemDesconto() throws Exception {
		pedido.comItem(5.00, 5).comItem(4.00, 5);
		assertResumoDoPedido(25.0 + 20.0, 0);
	}

	@Test
	public void deveCalcularDescontoFaixaUm() throws Exception {
		pedido.comItem(101.00, 3);
		// 4%
		assertEquals(101.00 * 3 * 0.04, pedido.construir().resumo().getValorDesconto(), 0.0001);
	}

	@Test
	public void deveCalcularDescontoFaixaDois() throws Exception {
		// 6%
		pedido.comItem(101.00, 8);
		double valor = 101.00 * 8;
		assertResumoDoPedido(valor, valor * 0.06);
	}

	@Test
	public void deveCalcularDescontoFaixaTres() throws Exception {
		// 8% se > 1000
		pedido.comItem(101.00, 11);

		double totalEsperado = 101.00 * 11;
		double descontoEsperado = 101.00 * 11 * 0.08;

		assertResumoDoPedido(totalEsperado, descontoEsperado);
	}
	
	@Test(expected=QuantidadeInvalidaException.class)
	public void naoDeveAceitarPedidosComQuantidadeDeItensNegativa() throws Exception {
		pedido.comItem(101.00, -12);
	}
}
