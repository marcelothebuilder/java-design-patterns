package com.github.marcelothebuilder.patternproxy;

import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		System.out.println("Without proxy:");
		Set<String> set = new TreeSet<>();
		set.add("ronaldo@gmail.com");
		set.add("jefferson@gmail.com");
		set.add("camilo@gmail.com");
		set.add("alexandre@gmail.com");
		set.add("julio@gmail.com");
		set.add("serafim@gmail.com");
		
		Set<String> blacklistSet = new TreeSet<>();
		blacklistSet.add("ronaldo@gmail.com");
		blacklistSet.add("serafim@gmail.com");
		
		MailSender sender = new MailSenderMandrill();
		for (String string : set) {
			sender.addEmail(string);
		}
		sender.send("mail");
		
		
		
		System.out.println("With proxy");
		MailSender sender2 = new BlacklistMailSenderProxy(new MailSenderMandrill(), blacklistSet);
		for (String string : set) {
			sender2.addEmail(string);
		}
		sender2.send("mail");
		
		
		

	}

}
