package com.onlineTest.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineTest.bean.Course;
import com.onlineTest.dao.Basedao;
import com.onlineTest.dao.impl.BaseDaoimpl;
import com.onlineTest.service.CourseService;

public class CourseServiceImpl implements CourseService{
	private Basedao bdi=null;
	private ResultSet re=null;
	private List<Course> course=null;
	  public CourseServiceImpl() {
		  bdi=new BaseDaoimpl();
		  course=new ArrayList<Course>();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public List<Course> getCourse(String sql, Object... objects) {
		// TODO 自动生成的方法存根
		try{
			re=bdi.getEntity(sql, objects);
			while(re.next()){
				String id=re.getString(1);
				String name=re.getString(2);
				int credit=re.getInt(3);
				String departId=re.getString(4);
				String tno=re.getString(5);
				Course cou=new Course(id,name,credit,departId,tno);
				course.add(cou);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			bdi.close();
		}
		return course;
	}

}
