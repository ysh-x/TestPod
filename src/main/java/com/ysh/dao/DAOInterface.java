package com.ysh.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DAOInterface {

	public Connection getConnection() throws ClassNotFoundException;

	public void closeConnection(Connection connection) throws SQLException;

}
