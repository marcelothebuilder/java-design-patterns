package com.github.marcelothebuilder.patternabstractfactory.database.mysql;

import com.github.marcelothebuilder.patternabstractfactory.database.api.Connection;
import com.github.marcelothebuilder.patternabstractfactory.database.api.PreparedStatement;
import com.github.marcelothebuilder.patternabstractfactory.database.api.Statement;

public class MysqlConnection implements Connection {

	public Statement createStatement() {
		return new MysqlStatement();
	}

	public PreparedStatement createPreparedStatement() {
		return new MysqlPreparedStatement();
	}

}
