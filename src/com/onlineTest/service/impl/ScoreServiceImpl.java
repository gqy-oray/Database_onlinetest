package com.onlineTest.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineTest.bean.Course;
import com.onlineTest.dao.Basedao;
import com.onlineTest.dao.impl.BaseDaoimpl;
import com.onlineTest.service.CourseService;
import com.onlineTest.service.ScoreService;

public class ScoreServiceImpl implements ScoreService{
	private Basedao bdi=null;
	public ScoreServiceImpl() {
		// TODO 自动生成的构造函数存根
		bdi=new BaseDaoimpl();
		
	}
	
	@Override
	public void insertScore(String sql, Object... objects) {
		// TODO 自动生成的方法存根
		try{
			int n=bdi.insert(sql, objects);
			if(n==1){
				System.out.println("选课成功");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			bdi.close();
		}
	}

}
