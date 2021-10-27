package com.student.dao;

import com.student.bean.Student;

public interface StudentDao {
	public int registerStudent(Student s);
	public boolean validate(Student s);

}
