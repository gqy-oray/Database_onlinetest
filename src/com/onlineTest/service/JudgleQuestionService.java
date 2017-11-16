package com.onlineTest.service;

import java.util.List;

import com.onlineTest.bean.JudgleQuestion;

public interface JudgleQuestionService {
	public abstract List<JudgleQuestion> getJudgleQuestion(String sql,Object...objects);
}
