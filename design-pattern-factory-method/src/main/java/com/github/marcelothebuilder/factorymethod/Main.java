/**
 * 
 */
package com.github.marcelothebuilder.factorymethod;

import javax.swing.JOptionPane;

import com.github.marcelothebuilder.factorymethod.mailer.Mailer;
import com.github.marcelothebuilder.factorymethod.mailer.impl.MailerCSV;
import com.github.marcelothebuilder.factorymethod.mailer.impl.MailerXML;

/**
 * 
 * @author Marcelo Paixao Resende
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Please input the message to be sent.");

		System.out.println("Sending with XML data");
		{
			Mailer mailer = new MailerXML("contacts.xml");
			mailer.sendMessage(message);
		}

		System.out.println("Sending with CSV data");
		{
			Mailer mailer = new MailerCSV("contacts.csv");
			mailer.sendMessage(message);
		}
	}

}
