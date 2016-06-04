package com.github.marcelothebuilder.patternabstractfactory.database;

public class DatabaseProviderNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public DatabaseProviderNotFoundException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DatabaseProviderNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DatabaseProviderNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public DatabaseProviderNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DatabaseProviderNotFoundException(Throwable cause) {
		super(cause);
	}
}
