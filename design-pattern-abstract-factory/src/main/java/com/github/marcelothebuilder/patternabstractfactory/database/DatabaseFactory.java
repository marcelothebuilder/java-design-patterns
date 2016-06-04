package com.github.marcelothebuilder.patternabstractfactory.database;

import java.util.Properties;

import com.github.marcelothebuilder.patternabstractfactory.database.api.Database;

public class DatabaseFactory {
	private Properties properties;
	
	public DatabaseFactory(Properties properties) {
		this.properties = properties;
	}
	
	public Database getDatabase() {
		String provider = properties.getProperty("dbprovider");
		try {
			return (Database) Class.forName(provider)
				.newInstance();
		} catch (ReflectiveOperationException e) {
			throw new DatabaseProviderNotFoundException("Database "+provider+" not found.", e);
		}
	}
}
