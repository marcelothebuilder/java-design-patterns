package com.github.marcelothebuilder.patternabstractfactory.database.oracle;

import com.github.marcelothebuilder.patternabstractfactory.database.api.Connection;
import com.github.marcelothebuilder.patternabstractfactory.database.api.Database;

public class OracleDatabase implements Database {

	public Connection getConnection() {
		return new OracleConnection();
	}

}
