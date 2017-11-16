package com.onlineTest.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineTest.bean.ChoiceQuestion;
import com.onlineTest.dao.Basedao;
import com.onlineTest.dao.impl.BaseDaoimpl;
import com.onlineTest.service.ChoiceQuestionService;

public class ChoiceQuestionServiceImpl implements ChoiceQuestionService{
	private Basedao bdi=null;
	private ResultSet re=null;
	private List<ChoiceQuestion> ChoiceQuestion=null;
	public ChoiceQuestionServiceImpl() {
		// TODO 自动生成的构造函数存根
		bdi=new BaseDaoimpl();
		ChoiceQuestion=new ArrayList<ChoiceQuestion>();
	}
	

	@Override
	public List<ChoiceQuestion> getChioceQuestion(String sql, Object... objects) {
		// TODO 自动生成的方法存根
		try{
			re=bdi.getEntity(sql, objects);
			while(re.next()){
				String id=re.getString(1);
				String title=re.getString(2);
				String choiceA=re.getString(3);
				String choiceB=re.getString(4);
				String choiceC=re.getString(5);
				String choiceD=re.getString(6);
				String answer=re.getString(7);
				String analysis=re.getString(8);
				String cid=re.getString(9);
				ChoiceQuestion choiceQuestion=new ChoiceQuestion(id,title,choiceA,choiceB,choiceC,choiceD,answer,analysis,cid);
				ChoiceQuestion.add(choiceQuestion);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			bdi.close();
		}
		return ChoiceQuestion;
	}
	

}
