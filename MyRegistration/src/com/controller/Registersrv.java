package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebServlet;

import com.student.bean.Student;
import com.student.dao.StudentDao;
import com.student.dao.StudentDaoImpl;

/**
 * Servlet implementation class Registersrv
 */
//@WebServlet("/Registersrv")
public class Registersrv extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
   
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String contr = request.getParameter("controller");
		if(contr != null && contr.equals("register"))
			register(request,response);
		else if(contr != null && contr.equals("login"))
			login(request,response);
		
	}
	
	public static void register(ServletRequest request, ServletResponse response) {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Student s = new Student();
		s.setFirstname(firstname);
		s.setLastname(lastname);
		s.setAddress(address);
		s.setDob(dob);
		s.setUsername(username);
		s.setPassword(password);
		StudentDaoImpl sd = new StudentDaoImpl();
		int result = sd.registerStudent(s);
		PrintWriter out;
		try {
			out = response.getWriter();
		
		if(result!=0)
			out.println("<h1>Registration successfully done</h1>");
		else
			out.println("<h1>Registration failed</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	
	public static void login(ServletRequest request, ServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Student s = new Student();
		s.setUsername(username);
		s.setPassword(password);
		PrintWriter out=null;
		try {
			out = response.getWriter();
		
		StudentDao sd = new StudentDaoImpl();
		if(sd.validate(s))
			out.println("<h1> Login successfull</h1>");
		else
			out.println("<h1> login failed</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
