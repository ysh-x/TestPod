package com.ysh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ysh.model.CreateExamBean;
import com.ysh.model.FacultyLogBean;

public class FacultyLogDAO {
	private final String C1 = "TESTID";
	private final String C2 = "ID";
	private final String C3 = "SUBJECT_NAME";

	private String url = "jdbc:mysql://localhost:3306/TestPodTest";
	private String userName = "root";
	private String passWord = "Gygshwr#01";

	private final String SELECT_USER_BY_ID = "SELECT * FROM TEST_LOG WHERE ID = ?";
	private final String SELECT_EXAM_BY_ID = "SELECT * FROM TEST_LOG WHERE ID = ? AND TESTID = ?";
	private final String INSERT_TEST = "INSERT INTO TEST_LOG VALUES(?,?,?)";

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

	public List<FacultyLogBean> getDetails(int ID) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		FacultyLogBean bean;
		List<FacultyLogBean> ans = new ArrayList<FacultyLogBean>();
		int id = 0;
		int testId = 0;
		String subject = null;

		PreparedStatement prepStatement = connection.prepareStatement(SELECT_USER_BY_ID);
		prepStatement.setInt(1, ID);
		ResultSet result = prepStatement.executeQuery();

		while (result.next()) {
			testId = result.getInt(C1);
			id = result.getInt(C2);
			subject = result.getString(C3);
			bean = new FacultyLogBean(testId, id, subject);
			ans.add(bean);
		}
		connection.close();
		return ans;
	}
	public boolean ifExamPresent(CreateExamBean bean) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		PreparedStatement checkStmt = connection.prepareStatement(SELECT_EXAM_BY_ID);
		checkStmt.setInt(1,bean.getFacultyID());
		checkStmt.setInt(2,bean.getTestID());
		
		ResultSet resultTemp = checkStmt.executeQuery();
		int count = 0;
		while(resultTemp.next()) {
			count = resultTemp.getInt("COUNT(*)");
		}	
		if(count == 0)
			return false;

		return true;
	
	}
	
	public FacultyLogBean getExamDetails(int facultyID, int testID) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		
		PreparedStatement checkStmt = connection.prepareStatement(SELECT_EXAM_BY_ID);
		checkStmt.setInt(1,testID);
		checkStmt.setInt(2,facultyID);
		
		ResultSet resultTemp = checkStmt.executeQuery();
		int facultyid = 0;
		int testid = 0;
		String subjectName = null;
		
		while(resultTemp.next()) {
			testid = resultTemp.getInt(C1);
			facultyid = resultTemp.getInt(C2);
			subjectName = resultTemp.getString(C3);
			System.out.println(subjectName);
			
		}
		FacultyLogBean bean = new FacultyLogBean(testid,facultyid,subjectName);
		return bean;
	}
	
	public int insertLog(CreateExamBean bean) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		PreparedStatement prepStatement = connection.prepareStatement(INSERT_TEST);
		prepStatement.setInt(1, bean.getTestID());
		prepStatement.setInt(2, bean.getFacultyID());
		prepStatement.setString(3, bean.getSubjectName());		
		int result = prepStatement.executeUpdate();
		connection.close();
		return result;
	}

}
