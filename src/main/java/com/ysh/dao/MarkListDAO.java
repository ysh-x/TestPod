package com.ysh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ysh.model.CreateExamBean;
import com.ysh.model.StudentReportBean;

public class MarkListDAO {

	private String url = "jdbc:mysql://localhost:3306/TestPodTest";
	private String userName = "root";
	private String passWord = "Gygshwr#01";

	private final String BATCH_UPDATE = "INSERT INTO MARKLIST VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String SELECT = "SELECT STUDENT_ID FROM MARKLIST WHERE TEST_ID = ? AND R1 != 'Remarks'";
	private final String SELECT_STUDENT = "SELECT COUNT(*) FROM MARKLIST WHERE TEST_ID = ? AND STUDENT_ID = ?";
	private final String SELECT_TOTAL = "SELECT TOTAL FROM MARKLIST WHERE TEST_ID = ?";

	private final String SELECT_MARKS = "SELECT TEST_ID,STUDENT_ID,FACULTY_ID,Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10,TOTAL,R1,R2,R3,R4,R5,R6,R7,R8,R9,R10 FROM MARKLIST WHERE TEST_ID = ? AND STUDENT_ID = ?";
	private final String UPDATE_MARKS = "UPDATE MARKLIST SET Q1=?,Q2=?,Q3=?,Q4=?,Q5=?,Q6=?,Q7=?,Q8=?,Q9=?,Q10=?,TOTAL=?,R1=?,R2=?,R3=?,R4=?,R5=?,R6=?,R7=?,R8=?,R9=?,R10=? WHERE TEST_ID = ? AND STUDENT_ID = ?";

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

	public int batchInsert(CreateExamBean bean) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		ArrayList<Integer> studentMarks = bean.getStudents();
		float initialMarks = 0.0f;
		String remarks = "Remarks";
		int result = 0;
		for (Integer a : studentMarks) {
			PreparedStatement prepStatement = connection.prepareStatement(BATCH_UPDATE);
			prepStatement.setInt(1, bean.getTestID());
			prepStatement.setInt(2, a);
			prepStatement.setInt(3, bean.getFacultyID());
			prepStatement.setFloat(4, initialMarks);
			prepStatement.setFloat(5, initialMarks);
			prepStatement.setFloat(6, initialMarks);
			prepStatement.setFloat(7, initialMarks);
			prepStatement.setFloat(8, initialMarks);
			prepStatement.setFloat(9, initialMarks);
			prepStatement.setFloat(10, initialMarks);
			prepStatement.setFloat(11, initialMarks);
			prepStatement.setFloat(12, initialMarks);
			prepStatement.setFloat(13, initialMarks);
			prepStatement.setFloat(14, initialMarks);
			prepStatement.setString(15, remarks);
			prepStatement.setString(16, remarks);
			prepStatement.setString(17, remarks);
			prepStatement.setString(18, remarks);
			prepStatement.setString(19, remarks);
			prepStatement.setString(20, remarks);
			prepStatement.setString(21, remarks);
			prepStatement.setString(22, remarks);
			prepStatement.setString(23, remarks);
			prepStatement.setString(24, remarks);
			result = prepStatement.executeUpdate();
		}
		closeConnection(connection);
		return result;
	}

	public ArrayList<Integer> getStudents(int testID) throws ClassNotFoundException, SQLException {
		ArrayList<Integer> students = new ArrayList<Integer>();
		Connection connection = getConnection();

		PreparedStatement checkStmt = connection.prepareStatement(SELECT);
		checkStmt.setInt(1, testID);

		ResultSet resultTemp = checkStmt.executeQuery();

		while (resultTemp.next()) {
			students.add(resultTemp.getInt("STUDENT_ID"));
		}
		return students;
	}

	public boolean isStudentPresent(int testID, int studentID) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();

		PreparedStatement checkStmt = connection.prepareStatement(SELECT_STUDENT);
		checkStmt.setInt(1, testID);
		checkStmt.setInt(2, studentID);
		int count = 0;
		ResultSet resultTemp = checkStmt.executeQuery();

		while (resultTemp.next()) {
			count = (resultTemp.getInt("COUNT(*)"));
		}
		return count == 0 ? false : true;
	}

	public StudentReportBean getStudentMarks(int testID, int studentID) throws ClassNotFoundException, SQLException {
		StudentReportBean studentBean = new StudentReportBean();
		ArrayList<Float> students = new ArrayList<Float>();
		ArrayList<String> remarks = new ArrayList<String>();
		ArrayList<Integer> number = new ArrayList<Integer>();

		Connection connection = getConnection();

		PreparedStatement checkStmt = connection.prepareStatement(SELECT_MARKS);
		checkStmt.setInt(1, testID);
		checkStmt.setInt(2, studentID);

		ResultSet resultTemp = checkStmt.executeQuery();

		while (resultTemp.next()) {
			studentBean.setStudentID(resultTemp.getInt("STUDENT_ID"));
			studentBean.setTestID(resultTemp.getInt("TEST_ID"));
			studentBean.setFacultyID(resultTemp.getInt("FACULTY_ID"));

			students.add(resultTemp.getFloat("Q1"));
			students.add(resultTemp.getFloat("Q2"));
			students.add(resultTemp.getFloat("Q3"));
			students.add(resultTemp.getFloat("Q4"));
			students.add(resultTemp.getFloat("Q5"));
			students.add(resultTemp.getFloat("Q6"));
			students.add(resultTemp.getFloat("Q7"));
			students.add(resultTemp.getFloat("Q8"));
			students.add(resultTemp.getFloat("Q9"));
			students.add(resultTemp.getFloat("Q10"));

			remarks.add(resultTemp.getString("R1"));
			remarks.add(resultTemp.getString("R2"));
			remarks.add(resultTemp.getString("R3"));
			remarks.add(resultTemp.getString("R4"));
			remarks.add(resultTemp.getString("R5"));
			remarks.add(resultTemp.getString("R6"));
			remarks.add(resultTemp.getString("R7"));
			remarks.add(resultTemp.getString("R8"));
			remarks.add(resultTemp.getString("R9"));
			remarks.add(resultTemp.getString("R10"));

			studentBean.setTotal(resultTemp.getFloat("TOTAL"));
		}
		studentBean.setMarks(students);
		studentBean.setRemarks(remarks);
		for (int i = 1; i <= 10; i++) {
			number.add(i);
		}
		studentBean.setQSno(number);
		return studentBean;
	}

	public int updateStudentMarks(List<Float> marks, float total, List<String> remarks, int testID, int studentID)
			throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement prepStatement = connection.prepareStatement(UPDATE_MARKS);
		prepStatement.setFloat(1, marks.get(0));
		prepStatement.setFloat(2, marks.get(1));
		prepStatement.setFloat(3, marks.get(2));
		prepStatement.setFloat(4, marks.get(3));
		prepStatement.setFloat(5, marks.get(4));
		prepStatement.setFloat(6, marks.get(5));
		prepStatement.setFloat(7, marks.get(6));
		prepStatement.setFloat(8, marks.get(7));
		prepStatement.setFloat(9, marks.get(8));
		prepStatement.setFloat(10, marks.get(9));
		prepStatement.setFloat(11, total);
		prepStatement.setString(12, remarks.get(0));
		prepStatement.setString(13, remarks.get(1));
		prepStatement.setString(14, remarks.get(2));
		prepStatement.setString(15, remarks.get(3));
		prepStatement.setString(16, remarks.get(4));
		prepStatement.setString(17, remarks.get(5));
		prepStatement.setString(18, remarks.get(6));
		prepStatement.setString(19, remarks.get(7));
		prepStatement.setString(20, remarks.get(8));
		prepStatement.setString(21, remarks.get(9));
		prepStatement.setInt(22, testID);
		prepStatement.setInt(23, studentID);

		int result = prepStatement.executeUpdate();
		return result;
	}

	public ArrayList<Float> getMarks(int testID) throws ClassNotFoundException, SQLException {
		ArrayList<Float> students = new ArrayList<Float>();
		Connection connection = getConnection();

		PreparedStatement checkStmt = connection.prepareStatement(SELECT_TOTAL);
		checkStmt.setInt(1, testID);

		ResultSet resultTemp = checkStmt.executeQuery();

		while (resultTemp.next()) {
			students.add(resultTemp.getFloat("TOTAL"));
		}
		return students;
	}
}
