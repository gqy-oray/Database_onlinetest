package com.onlineTest.service;

import java.util.List;

import com.onlineTest.bean.Student;

public interface StudentService {
	public abstract List<Student> getStudents(String sql,Object...objects);

}
