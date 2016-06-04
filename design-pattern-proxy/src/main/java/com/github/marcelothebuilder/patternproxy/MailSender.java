package com.github.marcelothebuilder.patternproxy;

public interface MailSender {
	void addEmail(String mail);
	void send(String mail);
}
