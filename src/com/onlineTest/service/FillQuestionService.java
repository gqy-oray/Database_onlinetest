package com.onlineTest.service;

import java.util.List;

import com.onlineTest.bean.FillQuestion;

public interface FillQuestionService {
	public abstract List<FillQuestion> getFillQuestion(String sql,Object...objects);

}
