package com.onlineTest.client;

import java.util.List;
import java.util.Scanner;

import com.onlineTest.bean.ChoiceQuestion;
import com.onlineTest.bean.Const;
import com.onlineTest.bean.Course;
import com.onlineTest.bean.FillQuestion;
import com.onlineTest.bean.JudgleQuestion;
import com.onlineTest.bean.Question;
import com.onlineTest.bean.Student;
import com.onlineTest.service.ChoiceQuestionService;
import com.onlineTest.service.CourseService;
import com.onlineTest.service.FillQuestionService;
import com.onlineTest.service.JudgleQuestionService;
import com.onlineTest.service.LoginService;
import com.onlineTest.service.QuestionService;
import com.onlineTest.service.StudentService;
import com.onlineTest.service.impl.ChoiceQuestionServiceImpl;
import com.onlineTest.service.impl.CourseServiceImpl;
import com.onlineTest.service.impl.FillQuestionServiceImpl;
import com.onlineTest.service.impl.JudgleQuestionServiceImpl;
import com.onlineTest.service.impl.LoginServiceImpl;
import com.onlineTest.service.impl.QuestionServiceImpl;
import com.onlineTest.service.impl.StudentServiceImpl;
import com.onlineTest.tool.MD5Encodes;

public class TeacherClient {
	private String result=null;
	public void load(Scanner input){
		login(input);
		do{
			String sno=loadStudent(input);
			String cid=loadCourse(sno,input);
			loadTestPage(sno,cid);
			System.out.println("是否继续查看学生的考试情况（y/n）");
			
			
		}while("y".equals(input.next()));
	}
	private void loadTestPage(String sno, String cid) {
		String sql="select *from Question_db where tpId=(select tpId from TestPage_db where sno=? and cid=?)";
		QuestionService questionservice=new QuestionServiceImpl();
		List<Question> questions=questionservice.getQuestion(sql,sno,cid);
		System.out.println(questions.size());
		for(int i=0;i<questions.size();i++){
			Question q=questions.get(i);
			switch(q.getqType()){
			case 1:
				
					System.out.println("一、选择题（每题两分，10题，共20分）");
				
				loadChoiceQuestion(q,i%10+1);
				break;
			case 2:
				
					System.out.println("二、填空题（每题两分，10题，共20分）");
				
				loadFillQuestion(q,i%10+1);
				break;
			case 3:
				
					System.out.println("三、判断题（每题两分，10题，共20分）");
				
				loadJudgleQuestion(q,i%10+1);
				break;
				default:
					break;
			}
		}
		
	}
	private void loadJudgleQuestion(Question q, int count) {
		String sql="select*from JudgleQuestion_db where jqId=?";
		JudgleQuestionService judgleQuestionService=new JudgleQuestionServiceImpl();
		List<JudgleQuestion> judgleQuestions=judgleQuestionService.getJudgleQuestion(sql,q.getQid());
		JudgleQuestion jq=judgleQuestions.get(0);
		System.out.println(count+"."+jq.getJqTitle());
		if(jq.getJqAnswer().equals(q.getInputAnswer())){
			System.out.println("正确：\t答案是："+jq.getJqAnswer()+"\t你的答案是："+q.getInputAnswer());
		}else{
			System.out.println("错误：\t答案是："+jq.getJqAnswer()+"\t你的答案是："+q.getInputAnswer());
		}
		
	}
	private void loadFillQuestion(Question q, int count) {
		String sql="select*from FillQuestion_db where fqId=?";
		FillQuestionService fillQuestionService=new FillQuestionServiceImpl();
		List<FillQuestion> fillQuestions=fillQuestionService.getFillQuestion(sql,q.getQid());
		FillQuestion fq=fillQuestions.get(0);
		System.out.println(count+"."+fq.getFqTitle());
		if(fq.getFqAnswer().equals(q.getInputAnswer())){
			System.out.println("正确：\t答案是："+fq.getFqAnswer()+"\t你的答案是："+q.getInputAnswer());
		}else{
			System.out.println("错误：\t答案是："+fq.getFqAnswer()+"\t你的答案是："+q.getInputAnswer());
		}
		
	}
	private void loadChoiceQuestion(Question q, int count) {
		String sql="select*from choiceQuestion_db where cqId=?";
		ChoiceQuestionService choiceQuestionService=new ChoiceQuestionServiceImpl();
		List<ChoiceQuestion> question=choiceQuestionService.getChioceQuestion(sql,q.getQid());
		ChoiceQuestion cq=question.get(0);
		System.out.println(count + "." + cq.getTitle());
		System.out.println(cq.getChoiceA());
		System.out.println(cq.getChoiceB());
		System.out.println(cq.getChoiceC());
		System.out.println(cq.getChoiceD());
		if (cq.getAnswer().equals(q.getInputAnswer())) {
			System.out.println("正确：\t答案是：" + cq.getAnswer() + "\t你的答案是：" + q.getInputAnswer());
		} else {
			System.out.println("错误：\t答案是：" + cq.getAnswer() + "\t你的答案是：" + q.getInputAnswer());
		}

		
	}
	private String loadCourse(String sno, Scanner input) {
		String sql="select co.cid,co.cname,co.credit,co.departId,co.tno from Course_db co,Score_db sc where co.cid=sc.cid and co.tno=? and sc.sno=?";
		System.out.println("==============查看选中学生选了你的哪些课===========");
		CourseService courseService=new CourseServiceImpl();
		List<Course> courses=courseService.getCourse(sql,Const.USER.getId(),sno);
		for(Course co:courses){
			System.out.println("*"+co.getName()+"("+co.getId()+")");
		}
		// TODO 自动生成的方法存根
		System.out.println("请输入课程编号，查看学生的考试情况");
		return input.next();
	}
	private String loadStudent(Scanner input) {
		String sql="select s.sno,s.sname,s.spaaword,s.departId,s.ssex,s.sphone,s.semail from Student_db s,Score_db sc where s.sno=sc.sno and sc.cid in (select cid from Course_db where tno=?)";
		System.out.println("=======选了你课的学生");
		StudentService studentService=new StudentServiceImpl();
		List<Student> students=studentService.getStudents(sql,Const.USER.getId());
		for(Student stu:students){
			System.out.println("*"+stu.getName()+"("+stu.getId()+")");
		}
		// TODO 自动生成的方法存根
		System.out.println("请输入要查看的学生的编号");
		return input.next();
		}
	private void login(Scanner input) {
		// TODO 自动生成的方法存根
		String sql="select*from Teacher_db where tno=? and tpassword=?";
		System.out.println("==========输入登陆信息登陆===========");
		do{
			System.out.println("******用户名*******");
			String tno=input.next();
			System.out.println("\n*****密码********");
			String pwd=input.next();
			LoginService loginservice=new LoginServiceImpl();
			MD5Encodes md5=new MD5Encodes();
			result=loginservice.login(sql,tno,md5.EncodeByMD5(pwd));
			
		}while(!Const.SUCCESS.equals(result));
		System.out.println("登陆成功");
		
	}

}
