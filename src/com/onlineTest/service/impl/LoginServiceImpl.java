package com.onlineTest.service.impl;

import java.util.List;

import com.onlineTest.bean.Const;
import com.onlineTest.bean.Student;
import com.onlineTest.service.LoginService;
import com.onlineTest.service.StudentService;

public class LoginServiceImpl implements LoginService{
	private StudentService stuService=null;
	private List<Student> stus=null;
	public LoginServiceImpl(){
		stuService=new StudentServiceImpl();
	}
	@Override
	public String login(String sql, Object... objects) {
		// TODO 自动生成的方法存根
		stus=stuService.getStudents(sql, objects);
		if(stus!=null&&stus.size()==1){
			Const.USER=stus.get(0);
			return Const.SUCCESS;
		}
		return Const.ERROR;
	}

}
