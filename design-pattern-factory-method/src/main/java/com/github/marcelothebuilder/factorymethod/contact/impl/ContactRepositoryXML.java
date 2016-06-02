/**
 * 
 */
package com.github.marcelothebuilder.factorymethod.contact.impl;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.github.marcelothebuilder.factorymethod.contact.Contact;
import com.github.marcelothebuilder.factorymethod.contact.ContactRepository;

/**
 * 
 * @author Marcelo Paixao Resende
 *
 */
public class ContactRepositoryXML implements ContactRepository {
	private String filePath;

	public ContactRepositoryXML(String filePath) {
		super();
		this.filePath = filePath;
	}

	@Override
	public List<Contact> all() {
		List<Contact> resultList = new ArrayList<>();

		URI res = null;
		try {
			res = this.getClass().getResource("/" + filePath).toURI();

			File resFile = new File(res);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = null;

			builder = factory.newDocumentBuilder();

			Document document = null;

			document = builder.parse(resFile);

			document.getDocumentElement().normalize();

			NodeList nList = document.getElementsByTagName("contact");

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					Contact contact = new Contact();
					contact.setName(element.getElementsByTagName("name").item(0).getTextContent());
					contact.setEmail(element.getElementsByTagName("email").item(0).getTextContent());
					resultList.add(contact);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultList;
	}

}
