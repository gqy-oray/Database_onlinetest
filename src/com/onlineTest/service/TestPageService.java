package com.onlineTest.service;

import java.util.List;

import com.onlineTest.bean.TestPage;

public interface TestPageService {
	public void inserTestPage(String sql,Object...objects);
	public List<TestPage> getTestPage(String sql,Object...objects);
	public void deleteTestPage(String sql,Object...objects);

}
