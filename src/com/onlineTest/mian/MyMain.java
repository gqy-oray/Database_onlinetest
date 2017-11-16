package com.onlineTest.mian;

import java.util.Scanner;

import com.onlineTest.bean.Const;
import com.onlineTest.client.StudentClient;
import com.onlineTest.client.TeacherClient;

public class MyMain {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("============欢迎进入考试系统==============");
		System.out.println("****************请选择身份登陆************");
		System.out.println("*                   学生                *");
		System.out.println("*                   老师                *");
		System.out.println("请输入你的选择                  ");
		Const.CAREER=input.next();
		switch(Const.CAREER){
		case"学生":
			StudentClient stuClient=new StudentClient();
			stuClient.load(input);
			break;
		case "老师":
			TeacherClient teacher=new TeacherClient();
			teacher.load(input);
			break;
			default:System.out.println("身份输入错误，推出系统。。。");
			System.exit(0);
		}
		
		
	}
	

}
