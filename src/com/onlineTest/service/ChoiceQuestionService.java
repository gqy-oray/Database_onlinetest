package com.onlineTest.service;

import java.util.List;

import com.onlineTest.bean.ChoiceQuestion;

public interface ChoiceQuestionService {
	public List<ChoiceQuestion> getChioceQuestion(String sql,Object...objects);

}
