package com.onlineTest.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineTest.bean.JudgleQuestion;
import com.onlineTest.dao.Basedao;
import com.onlineTest.dao.impl.BaseDaoimpl;
import com.onlineTest.service.JudgleQuestionService;

public class JudgleQuestionServiceImpl implements JudgleQuestionService{
	private Basedao bdi=null;
	private ResultSet re=null;
	private List<JudgleQuestion> JudgleQuestion=null;
	public JudgleQuestionServiceImpl() {
		// TODO 自动生成的构造函数存根
		bdi=new BaseDaoimpl();
		JudgleQuestion=new ArrayList<>();
	}

	@Override
	public List<JudgleQuestion> getJudgleQuestion(String sql, Object... objects) {
		// TODO 自动生成的方法存根
		try{
			re=bdi.getEntity(sql, objects);
			while(re.next()){
				String jqId=re.getString(1);
				String jqTitle=re.getString(2);
				String jqAnswer=re.getString(3);
				String jqAnalysis=re.getString(4);
				String cid=re.getString(5);
				JudgleQuestion juq=new JudgleQuestion(jqId,jqTitle,jqAnswer,jqAnalysis,cid);
				JudgleQuestion.add(juq);
				
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			bdi.close();
		}
		return JudgleQuestion;
	}


}
