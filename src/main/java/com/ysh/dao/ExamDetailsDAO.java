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
import com.ysh.model.QuestionPaperBean;

public class ExamDetailsDAO {
	private final String C1 = "TESTID";
	private final String C2 = "ID";
	private final String C3 = "SUBJECT_NAME";

	private String url = "jdbc:mysql://localhost:3306/TestPodTest";
	private String userName = "root";
	private String passWord = "Gygshwr#01";

	private final String SELECT_USER_BY_ID = "SELECT * FROM TEST_LOG WHERE ID = ?";
	private final String SELECT_QUESTIONS = "SELECT ID,FACULTY_ID,SUBJECT_NAME,Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10 FROM EXAM_DETAILS WHERE ID = ?";
	private final String INSERT_EXAM = "INSERT INTO EXAM_DETAILS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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

	public CreateExamBean getDetails(int ID) throws ClassNotFoundException, SQLException {
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
		return null;
	}

	public int insertDetails(CreateExamBean bean) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		PreparedStatement prepStatement = connection.prepareStatement(INSERT_EXAM);
		prepStatement.setInt(1, bean.getTestID());
		prepStatement.setInt(2, bean.getFacultyID());
		prepStatement.setString(3, bean.getSubjectName());
		prepStatement.setString(4, bean.getStudents().toString());
		prepStatement.setString(5, bean.getQuestions().get(0));
		prepStatement.setString(6, bean.getQuestions().get(1));
		prepStatement.setString(7, bean.getQuestions().get(2));
		prepStatement.setString(8, bean.getQuestions().get(3));
		prepStatement.setString(9, bean.getQuestions().get(4));
		prepStatement.setString(10, bean.getQuestions().get(5));
		prepStatement.setString(11, bean.getQuestions().get(6));
		prepStatement.setString(12, bean.getQuestions().get(7));
		prepStatement.setString(13, bean.getQuestions().get(8));
		prepStatement.setString(14, bean.getQuestions().get(9));
		prepStatement.setString(15, bean.getAnswers().get(0));
		prepStatement.setString(16, bean.getAnswers().get(1));
		prepStatement.setString(17, bean.getAnswers().get(2));
		prepStatement.setString(18, bean.getAnswers().get(3));
		prepStatement.setString(19, bean.getAnswers().get(4));
		prepStatement.setString(20, bean.getAnswers().get(5));
		prepStatement.setString(21, bean.getAnswers().get(6));
		prepStatement.setString(22, bean.getAnswers().get(7));
		prepStatement.setString(23, bean.getAnswers().get(8));
		prepStatement.setString(24, bean.getAnswers().get(9));

		int result = prepStatement.executeUpdate();
		connection.close();
		return result;
	}

	public QuestionPaperBean getQuestions(int ID) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		QuestionPaperBean bean = new QuestionPaperBean();

		PreparedStatement prepStatement = connection.prepareStatement(SELECT_QUESTIONS);
		prepStatement.setInt(1, ID);
		ResultSet result = prepStatement.executeQuery();

		while (result.next()) {
			bean.setTestID(result.getInt(1));
			bean.setFacultyID(result.getInt(2));
			bean.setSubjectName(result.getString(3));
			bean.setQ1(result.getString(4));
			bean.setQ2(result.getString(5));
			bean.setQ3(result.getString(6));
			bean.setQ4(result.getString(7));
			bean.setQ5(result.getString(8));
			bean.setQ6(result.getString(9));
			bean.setQ7(result.getString(10));
			bean.setQ8(result.getString(11));
			bean.setQ9(result.getString(12));
			bean.setQ10(result.getString(13));
			System.out.print(bean.toString());
			return bean;
		}
		connection.close();
		return null;
	}

}
