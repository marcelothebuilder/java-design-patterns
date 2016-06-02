/**
 * 
 */
package com.github.marcelothebuilder.factorymethod.mailer.impl;

import com.github.marcelothebuilder.factorymethod.contact.ContactRepository;
import com.github.marcelothebuilder.factorymethod.contact.impl.ContactRepositoryCSV;
import com.github.marcelothebuilder.factorymethod.mailer.Mailer;

/**
 * @author Marcelo Paixao Resende
 *
 */
public class MailerCSV extends Mailer {
	private String filePath;

	public MailerCSV(String filePath) {
		super();
		this.filePath = filePath;
	}

	@Override
	protected ContactRepository createRepository() {
		return new ContactRepositoryCSV(filePath);
	}

}
