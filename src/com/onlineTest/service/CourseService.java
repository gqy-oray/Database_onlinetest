package com.onlineTest.service;

import java.util.List;

import com.onlineTest.bean.Course;

public interface CourseService {
	public abstract List<Course> getCourse(String sql,Object...objects);

}
