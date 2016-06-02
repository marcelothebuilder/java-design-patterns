/**
 * 
 */
package com.github.marcelothebuilder.factorymethod.mailer;

import java.util.List;

import com.github.marcelothebuilder.factorymethod.contact.Contact;
import com.github.marcelothebuilder.factorymethod.contact.ContactRepository;

/**
 * @author Marcelo Paixao Resende
 *
 */
public abstract class Mailer {

	protected abstract ContactRepository createRepository();

	public void sendMessage(String message) {
		ContactRepository contactRepository = this.createRepository();
		List<Contact> contacts = contactRepository.all();

		for (Contact contact : contacts) {
			System.out.println(String.format("Sending e-mail to %s <%s>", contact.getName(), contact.getEmail()));
		}
	}

}
