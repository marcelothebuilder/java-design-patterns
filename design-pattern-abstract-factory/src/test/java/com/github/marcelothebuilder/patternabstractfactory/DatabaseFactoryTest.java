package com.github.marcelothebuilder.patternabstractfactory;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.github.marcelothebuilder.patternabstractfactory.database.DatabaseFactory;
import com.github.marcelothebuilder.patternabstractfactory.database.DatabaseProviderNotFoundException;

public class DatabaseFactoryTest {
	
	private DatabaseFactory factory;

	@Before
	public void setUp() throws Exception {
		Properties props = new Properties();
		props.setProperty("dbprovider", "com.github.marcelothebuilder.patternabstractfactory.database.mysql.MysqlDatabase");
		factory = new DatabaseFactory(props);
	}

	@Test
	public void testGetMysqlDatabase() {
		assertEquals("MysqlDatabase", factory.getDatabase().getClass().getSimpleName());
	}
	
	@Test(expected=DatabaseProviderNotFoundException.class)
	public void deveLancarDatabaseProviderNotFoundException() {
		Properties props = new Properties();
		props.setProperty("dbprovider",
				"com.github.marcelothebuilder.patternabstractfactory.database.mysql.NewDatabase");
		new DatabaseFactory(props).getDatabase();
	}

}
