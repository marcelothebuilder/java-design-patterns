/**
 * 
 */
package com.github.marcelothebuilder.patternproxy;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Marcelo Paixao Resende
 *
 */
public class MailSenderMandrill implements MailSender {
	private Set<String> mails = new TreeSet<>();
	
	@Override
	public void send(String mail) {
		for (String string : mails) {
			System.out.println("Sending to "+string+" through "+this.getClass().getSimpleName());
		}
	}

	@Override
	public void addEmail(String mail) {
		mails.add(mail);
	}
}
