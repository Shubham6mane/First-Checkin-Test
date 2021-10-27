package com.student.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.student.bean.Student;
import com.student.db.MysqlConn;

public class StudentDaoImpl implements StudentDao{
	public int registerStudent(Student s){
		int result = 0;
		PreparedStatement ps = null;
		String query = "insert into student(name,lastname,address,dob,username,password) values(?,?,?,?,?,?)";
		try {
			ps = MysqlConn.getConnection().prepareStatement(query);
			ps.setString(1, s.getFirstname());
			ps.setString(2, s.getLastname());
			ps.setString(3, s.getAddress());
			ps.setString(4, s.getDob());
			ps.setString(5, s.getUsername());
			ps.setString(6, s.getPassword());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean validate(Student s) {
		boolean status = false;
		Statement st = null;
		ResultSet rs = null;
		try {
			st = MysqlConn.getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = st.executeQuery("select * from student where username = "+s.getUsername()+ " and pasword ="+ s.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			status = rs.next();
			System.out.println(status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
