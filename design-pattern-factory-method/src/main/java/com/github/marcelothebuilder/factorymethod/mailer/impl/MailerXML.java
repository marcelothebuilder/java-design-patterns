/**
 * 
 */
package com.github.marcelothebuilder.factorymethod.mailer.impl;

import com.github.marcelothebuilder.factorymethod.contact.ContactRepository;
import com.github.marcelothebuilder.factorymethod.contact.impl.ContactRepositoryXML;
import com.github.marcelothebuilder.factorymethod.mailer.Mailer;

/**
 * @author Marcelo Paixao Resende
 *
 */
public class MailerXML extends Mailer {
	private String filePath;

	public MailerXML(String filePath) {
		super();
		this.filePath = filePath;
	}

	@Override
	protected ContactRepository createRepository() {
		return new ContactRepositoryXML(filePath);
	}

}
