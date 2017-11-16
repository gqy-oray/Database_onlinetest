package com.onlineTest.service;

import java.util.List;

import com.onlineTest.bean.Question;

public interface QuestionService {
	public List<Question> getQuestion(String sql,Object...objects);
	public void insertQuestion(String sql,Object...objects);
	public void deleteQuestion(String sql,Object...objects);

}
