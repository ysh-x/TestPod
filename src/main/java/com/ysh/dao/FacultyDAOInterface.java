package com.ysh.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.ysh.model.FacultyBean;

public interface FacultyDAOInterface {
	
	Connection getConnection()throws ClassNotFoundException;
	FacultyBean getDetails(int ID) throws ClassNotFoundException, SQLException;
}
