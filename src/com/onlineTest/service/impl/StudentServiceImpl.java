package com.onlineTest.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineTest.bean.Student;
import com.onlineTest.dao.Basedao;
import com.onlineTest.dao.impl.BaseDaoimpl;
import com.onlineTest.service.StudentService;

public class StudentServiceImpl implements StudentService{
	private Basedao bdi=null;
	private ResultSet rs=null;
	private List<Student> students=null;
	public StudentServiceImpl() {
		// TODO 自动生成的构造函数存根
		bdi=new BaseDaoimpl();
		students=new ArrayList<Student>();
		
		
	}
	@Override
	public List<Student> getStudents(String sql, Object... objects) {
		// TODO 自动生成的方法存根
		try{
			rs=bdi.getEntity(sql, objects);
			while(rs.next()){
				String sno=rs.getString(1);
				String name=rs.getString(2);
				String password=rs.getString(3);
				String departId=rs.getString(4);
				String ssex=rs.getString(5);
				String sphone=rs.getString(6);
				String semail=rs.getString(7);
				Student stu=new Student(sno,name,password,departId,ssex,sphone,semail);
				students.add(stu);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			bdi.close();
		}
		return students;
	}
	

}
