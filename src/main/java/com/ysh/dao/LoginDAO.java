package com.ysh.dao;

import java.sql.*;

import com.ysh.model.LoginBean;

public class LoginDAO {

	private final String C1 = "ID";
	private final String C2 = "PASSWORD";
	private final String C3 = "SALT";

	private String url = "jdbc:mysql://localhost:3306/TestPodTest";
	private String userName = "root";
	private String passWord = "Gygshwr#01";

	private final String SELECT_USER_BY_ID = "SELECT * FROM FACULTY_LOGIN WHERE ID = ?";
	private final String IS_USER_PRESENT = "SELECT COUNT(*) FROM FACULTY_LOGIN WHERE ID = ?";

	public Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, userName, passWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void closeConnection(Connection connection) throws SQLException {
		connection.close();
	}

	public boolean isUserPresent(int ID) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		int count = 0;
		PreparedStatement prepStatement = connection.prepareStatement(IS_USER_PRESENT);
		prepStatement.setInt(1, ID);
		ResultSet result = prepStatement.executeQuery();
		
		while(result.next()) {
			count = result.getInt("COUNT(*)");
		}
		connection.close();
		if(count != 0)
			return true;
		return false;
	}
	
	public LoginBean getLoginDetails(int ID) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		LoginBean bean;
		
		int id = 0;
		String password = null;
		String salt = null;
		
		PreparedStatement prepStatement = connection.prepareStatement(SELECT_USER_BY_ID);
		prepStatement.setInt(1, ID);
		ResultSet result = prepStatement.executeQuery();
		
		while(result.next()) {
			id = result.getInt(C1);
			password = result.getString(C2);
			salt = result.getString(C3);
		}
		connection.close();
		bean = new LoginBean(id,password,salt);
		return bean;
	}
}
