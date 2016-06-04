package com.github.marcelothebuilder.patternabstractfactory.database.mysql;

import com.github.marcelothebuilder.patternabstractfactory.database.api.Connection;
import com.github.marcelothebuilder.patternabstractfactory.database.api.Database;

public class MysqlDatabase implements Database {

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return new MysqlConnection();
	}

}
