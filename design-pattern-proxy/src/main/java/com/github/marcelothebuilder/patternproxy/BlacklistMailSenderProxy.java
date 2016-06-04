package com.github.marcelothebuilder.patternproxy;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class BlacklistMailSenderProxy implements MailSender {
	private MailSender sender;
	private Set<String> blacklist;
	
	public BlacklistMailSenderProxy(MailSender sender, Set<String> blacklist) {
		this.sender = sender;
		this.blacklist = blacklist;
	}
	
	public BlacklistMailSenderProxy(MailSender sender, String... blacklist) {
		this(sender, new TreeSet<>());
		Collections.addAll(this.blacklist, blacklist);
	}

	@Override
	public void addEmail(String mail) {
		if (!blacklist.contains(mail)) {
			sender.addEmail(mail);
		}
	}

	@Override
	public void send(String mail) {
		sender.send(mail);
	}

}
