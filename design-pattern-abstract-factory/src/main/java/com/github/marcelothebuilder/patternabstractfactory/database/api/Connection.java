package com.github.marcelothebuilder.patternabstractfactory.database.api;

public interface Connection {
	Statement createStatement();
	PreparedStatement createPreparedStatement();
}
