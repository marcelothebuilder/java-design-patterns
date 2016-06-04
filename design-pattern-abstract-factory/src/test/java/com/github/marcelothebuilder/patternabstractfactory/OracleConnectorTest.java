package com.github.marcelothebuilder.patternabstractfactory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.marcelothebuilder.patternabstractfactory.database.api.Connection;
import com.github.marcelothebuilder.patternabstractfactory.database.api.Database;
import com.github.marcelothebuilder.patternabstractfactory.database.api.PreparedStatement;
import com.github.marcelothebuilder.patternabstractfactory.database.api.Statement;
import com.github.marcelothebuilder.patternabstractfactory.database.oracle.OracleDatabase;

public class OracleConnectorTest {
	private Database factory;
	private Connection connection;
	
	@Before
	public void setUp() throws Exception {
		factory = new OracleDatabase();
		connection = factory.getConnection();
	}

	@Test
	public void deveExibirNomeConexaoOracle() {
		assertEquals( "OracleConnection", connection.getClass().getSimpleName() );
	}
	
	@Test
	public void deveExibirNomeStatementOracle() {
		Statement statement = connection.createStatement();
		assertEquals( "OracleStatement", statement.getClass().getSimpleName() );
	}
	
	@Test
	public void deveExibirNomePreparedStatementOracle() {
		PreparedStatement statement = connection.createPreparedStatement();
		assertEquals( "OraclePreparedStatement", statement.getClass().getSimpleName() );
	}

}
