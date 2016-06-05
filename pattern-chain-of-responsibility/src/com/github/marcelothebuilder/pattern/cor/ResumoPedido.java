package com.github.marcelothebuilder.pattern.cor;

public class ResumoPedido {
	private double valorTotal;
	private double valorDesconto;
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(valorDesconto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResumoPedido other = (ResumoPedido) obj;
		if (Double.doubleToLongBits(valorDesconto) != Double.doubleToLongBits(other.valorDesconto))
			return false;
		if (Double.doubleToLongBits(valorTotal) != Double.doubleToLongBits(other.valorTotal))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ResumoPedido [valorTotal=" + valorTotal + ", valorDesconto=" + valorDesconto + "]";
	}
}
