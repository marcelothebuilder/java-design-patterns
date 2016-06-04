package com.github.marcelothebuilder.patterndecorator.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.github.marcelothebuilder.patterndecorator.api.AgendaDAO;
import com.thoughtworks.xstream.XStream;

public class AgendaDAOXML implements AgendaDAO {

	private File file;
	
	public AgendaDAOXML(String fileName) throws FileNotFoundException {
		Path path = Paths.get("src/main/resources/" + fileName);
		this.file = path.toFile();
	}

	@Override
	public void inserir(Contato entity) {
		Set<Contato> contatos = getAsSet();
		XStream xs = getStream();
		try {
			FileWriter fileWrt = new FileWriter(file);			
			contatos.add(entity);
			fileWrt.write(xs.toXML(contatos));
			fileWrt.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Contato buscar(Long codigo) {
		Set<Contato> list = getAsSet();

		for (Contato contato : list) {
			if (contato.getCodigo() == codigo) {
				return contato;
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private Set<Contato> getAsSet() {
		XStream xs = getStream();

		try {
			Set<Contato> lit = (Set<Contato>) xs.fromXML(file);
			return lit;
		} catch (Exception e) {
			return new HashSet<Contato>();
		}
	}

	private XStream getStream() {
		XStream xs = new XStream();
		xs.alias("contatos", Set.class);
		xs.alias("contato", Contato.class);
		return xs;
	}

}
