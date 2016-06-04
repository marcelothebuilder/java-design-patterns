package com.github.marcelothebuilder.patterndecorator.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.marcelothebuilder.patterndecorator.api.AgendaDAO;

public class CachedAgendaDAO implements AgendaDAO {
	private AgendaDAO dao;
	private Map<Long, Contato> map = new HashMap<>();
	
	public CachedAgendaDAO(AgendaDAOXML agendaDAOXML) {
		this.dao = agendaDAOXML;
	}

	@Override
	public void inserir(Contato entity) {
		map.put(entity.getCodigo(), entity);
		dao.inserir(entity);
	}

	@Override
	public Contato buscar(Long codigo) {
		if (map.containsKey(codigo)) {
			return map.get(codigo);
		}
		
		Contato contato = dao.buscar(codigo);
		map.put(codigo, contato);
		
		return contato;
	}

}
