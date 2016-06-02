/**
 * 
 */
package com.github.marcelothebuilder.factorymethod.contact.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.github.marcelothebuilder.factorymethod.contact.Contact;
import com.github.marcelothebuilder.factorymethod.contact.ContactRepository;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

/**
 * 
 * @author Marcelo Paixao Resende
 *
 */
public class ContactRepositoryCSV implements ContactRepository {
	private String filePath;

	public ContactRepositoryCSV(String filePath) {
		super();
		this.filePath = filePath;
	}

	@Override
	public List<Contact> all() {
		CSVReader reader = null;
		try {
			URI res = this.getClass().getResource("/" + filePath).toURI();
			File resFile = new File(res);
			FileReader fReader = new FileReader(resFile);
			reader = new CSVReader(fReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ColumnPositionMappingStrategy<Contact> strategy = new ColumnPositionMappingStrategy<>();
		strategy.setType(Contact.class);
		strategy.setColumnMapping(new String[] { "name", "email" });
		CsvToBean<Contact> csvToBean = new CsvToBean<>();
		List<Contact> list = csvToBean.parse(strategy, reader);

		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
