package com.github.marcelothebuilder.patternabstractfactory.database.oracle;

import com.github.marcelothebuilder.patternabstractfactory.database.api.Connection;
import com.github.marcelothebuilder.patternabstractfactory.database.api.PreparedStatement;
import com.github.marcelothebuilder.patternabstractfactory.database.api.Statement;

public class OracleConnection implements Connection {

	public Statement createStatement() {
		return new OracleStatement();
	}

	public PreparedStatement createPreparedStatement() {
		return new OraclePreparedStatement();
	}

}
