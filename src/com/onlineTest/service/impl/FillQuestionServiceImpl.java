package com.onlineTest.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineTest.bean.FillQuestion;
import com.onlineTest.dao.Basedao;
import com.onlineTest.dao.impl.BaseDaoimpl;
import com.onlineTest.service.FillQuestionService;

public class FillQuestionServiceImpl implements FillQuestionService{
	private Basedao bdi=null;
	private ResultSet re=null;
	private List<FillQuestion> fillQuestion=null;
	public FillQuestionServiceImpl() {
		// TODO 自动生成的构造函数存根
		bdi=new BaseDaoimpl();
		fillQuestion=new ArrayList<>();
	}
	@Override
	public List<FillQuestion> getFillQuestion(String sql, Object... objects) {
		// TODO 自动生成的方法存根
		try{
			re=bdi.getEntity(sql, objects);
			while(re.next()){
			String id=re.getString(1);
			String title=re.getString(2);
			String answer=re.getString(3);
			String analysis=re.getString(4);
			String cid=re.getString(5);
			FillQuestion fill=new FillQuestion(id,title,answer,analysis,cid);
			fillQuestion.add(fill);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			bdi.close();
		}

		
		return fillQuestion;
	}

}
