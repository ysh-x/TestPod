package com.ysh.exam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.ysh.model.CreateExamBean;

public interface Exam {
	
	public CreateExamBean createExam(CreateExamBean examBean) throws ClassNotFoundException, SQLException, InvalidFormatException, IOException;
	public ArrayList<String> getDetails(CreateExamBean bean);
}
