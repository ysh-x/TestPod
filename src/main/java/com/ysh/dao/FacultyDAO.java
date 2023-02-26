package com.ysh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ysh.model.FacultyBean;

public class FacultyDAO implements FacultyDAOInterface {

	private final String C1 = "ID";
	private final String C2 = "NAME";
	private final String C3 = "DESIGNATION";
	private final String C4 = "SCHOOL";

	private String url = "jdbc:mysql://localhost:3306/TestPodTest";
	private String userName = "root";
	private String passWord = "Gygshwr#01";

	private final String SELECT_USER_BY_ID = "SELECT * FROM FACULTY_DETAILS WHERE ID = ?";

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

	public FacultyBean getDetails(int ID) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		FacultyBean bean;

		int id = 0;
		String name = null;
		String designation = null;
		String school = null;

		PreparedStatement prepStatement = connection.prepareStatement(SELECT_USER_BY_ID);
		prepStatement.setInt(1, ID);
		ResultSet result = prepStatement.executeQuery();

		while (result.next()) {
			id = result.getInt(C1);
			name = result.getString(C2);
			designation = result.getString(C3);
			school = result.getString(C4);

		}
		connection.close();
		bean = new FacultyBean(id, name, designation, school);
		return bean;
	}

}
