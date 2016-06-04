package com.github.marcelothebuilder.patterndecorator;

import java.io.FileNotFoundException;

import com.github.marcelothebuilder.patterndecorator.api.AgendaDAO;
import com.github.marcelothebuilder.patterndecorator.impl.AgendaDAOXML;
import com.github.marcelothebuilder.patterndecorator.impl.CachedAgendaDAO;
import com.github.marcelothebuilder.patterndecorator.impl.Contato;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		notBuffered();
		cached();
	}

	private static void cached() throws FileNotFoundException {
		AgendaDAO dao = new CachedAgendaDAO(new AgendaDAOXML("agenda.xml"));
		Contato contato = new Contato();
		contato.setCodigo(5L);
		contato.setNome("Jasper");
		contato.setTelefone("3144-1313");
		dao.inserir(contato);
		
		Long timeStart = System.currentTimeMillis();
		
		for (int i = 0; i < 1000; i++) {
			dao.buscar(1L);
		}
		
		Long timeEnd = System.currentTimeMillis();
		
		Long timeDiff = timeEnd - timeStart;
		
		System.out.println("Took "+timeDiff+" ms cached");
	}

	private static void notBuffered() throws FileNotFoundException {
		AgendaDAO dao = new AgendaDAOXML("agenda.xml");
		Contato contato = new Contato();
		contato.setCodigo(5L);
		contato.setNome("Tetonx");
		contato.setTelefone("3144-1313");
		dao.inserir(contato);
		
		Long timeStart = System.currentTimeMillis();
		
		for (int i = 0; i < 1000; i++) {
			dao.buscar(1L);
		}
		
		Long timeEnd = System.currentTimeMillis();
		
		Long timeDiff = timeEnd - timeStart;
		
		System.out.println("Took "+timeDiff+" ms");
	}

}
