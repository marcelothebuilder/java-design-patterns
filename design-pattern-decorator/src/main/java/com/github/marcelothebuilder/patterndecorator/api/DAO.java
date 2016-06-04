package com.github.marcelothebuilder.patterndecorator.api;

public interface DAO<T, I extends Number> {
	void inserir(T entity);
	T buscar(I codigo);
}
