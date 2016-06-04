package com.github.marcelothebuilder.patternabstractfactory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.marcelothebuilder.patternabstractfactory.database.api.Connection;
import com.github.marcelothebuilder.patternabstractfactory.database.api.Database;
import com.github.marcelothebuilder.patternabstractfactory.database.api.PreparedStatement;
import com.github.marcelothebuilder.patternabstractfactory.database.api.Statement;
import com.github.marcelothebuilder.patternabstractfactory.database.mysql.MysqlDatabase;

public class MysqlConnectorTest {
	private Database factory;
	private Connection connection;
	
	@Before
	public void setUp() throws Exception {
		factory = new MysqlDatabase();
		connection = factory.getConnection();
	}

	@Test
	public void deveExibirNomeConexaoMysql() {
		assertEquals( "MysqlConnection", connection.getClass().getSimpleName() );
	}
	
	@Test
	public void deveExibirNomeStatementMysql() {
		Statement statement = connection.createStatement();
		assertEquals( "MysqlStatement", statement.getClass().getSimpleName() );
	}
	
	@Test
	public void deveExibirNomePreparedStatementMysql() {
		PreparedStatement statement = connection.createPreparedStatement();
		assertEquals( "MysqlPreparedStatement", statement.getClass().getSimpleName() );
	}

}
