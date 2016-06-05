package com.github.marcelothebuilder.pattern.cor;

public class QuantidadeInvalidaException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public QuantidadeInvalidaException() {
	}

	public QuantidadeInvalidaException(String arg0) {
		super(arg0);
	}

	public QuantidadeInvalidaException(Throwable arg0) {
		super(arg0);
	}

	public QuantidadeInvalidaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
