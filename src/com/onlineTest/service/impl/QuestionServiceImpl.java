package com.onlineTest.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineTest.bean.Question;
import com.onlineTest.dao.Basedao;
import com.onlineTest.dao.impl.BaseDaoimpl;
import com.onlineTest.service.QuestionService;

public class QuestionServiceImpl implements QuestionService{
	private Basedao bdi=null;
	private ResultSet re=null;
	private List<Question> question=null;
	public QuestionServiceImpl() {
		bdi=new BaseDaoimpl();
		question=new ArrayList<Question>();
	}

	@Override
	public List<Question> getQuestion(String sql, Object... objects) {
		try{
			re=bdi.getEntity(sql, objects);
			while(re.next()){
				String qid=re.getString(1);
				int tpId=re.getInt(2);
				int qType=re.getInt(3);
				String inputAnswer=re.getString(4);
				Question ques=new Question(qid,tpId,qType,inputAnswer);
				question.add(ques);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			bdi.close();
		}
		return question;
	}

	@Override
	public void insertQuestion(String sql, Object... objects) {
		// TODO 自动生成的方法存根
		try{
			int n=bdi.insert(sql, objects);
			if(n==1){
				System.out.println("题目提交成功");
			}
		}catch(SQLException e){
			System.out.println("题目提交失败");
			e.printStackTrace();
		}finally{
			bdi.close();
		}
		
	}

	@Override
	public void deleteQuestion(String sql, Object... objects) {
		// TODO 自动生成的方法存根
		
	}
	

}
