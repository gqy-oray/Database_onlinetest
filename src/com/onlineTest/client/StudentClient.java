package com.onlineTest.client;


import java.util.List;
import java.util.Scanner;

import com.onlineTest.bean.ChoiceQuestion;
import com.onlineTest.bean.Const;
import com.onlineTest.bean.Course;
import com.onlineTest.bean.FillQuestion;
import com.onlineTest.bean.JudgleQuestion;
import com.onlineTest.bean.TestPage;
import com.onlineTest.service.ChoiceQuestionService;
import com.onlineTest.service.CourseService;
import com.onlineTest.service.FillQuestionService;
import com.onlineTest.service.JudgleQuestionService;
import com.onlineTest.service.LoginService;
import com.onlineTest.service.QuestionService;
import com.onlineTest.service.ScoreService;
import com.onlineTest.service.TestPageService;
import com.onlineTest.service.impl.ChoiceQuestionServiceImpl;
import com.onlineTest.service.impl.CourseServiceImpl;
import com.onlineTest.service.impl.FillQuestionServiceImpl;
import com.onlineTest.service.impl.JudgleQuestionServiceImpl;
import com.onlineTest.service.impl.LoginServiceImpl;
import com.onlineTest.service.impl.QuestionServiceImpl;
import com.onlineTest.service.impl.ScoreServiceImpl;
import com.onlineTest.service.impl.TestPageServiceImpl;
import com.onlineTest.tool.MD5Encodes;

public class StudentClient {
	private String result=null;
	public StudentClient() {
		// TODO 自动生成的构造函数存根
	}
	public void load(Scanner input){
		login(input);
		selectCourse(input);
		String courseId=loadCourse(input);//加载课程，选择课程进行考试
		int tpId=createPaper(input,courseId);//生成试卷
		
		loadChoiceQuestion(courseId,tpId,input);//加载选择提，并添加在试卷里
		loadFillQuestion(courseId,tpId,input);//加载填空题
		loadJudgleQuestion(courseId,tpId,input);//加载判断题
		
	}
	private void loadJudgleQuestion(String courseId, int tpId, Scanner input) {
		// TODO 自动生成的方法存根
		String sql="select*from JudgleQuestion_db where cid=?";
		System.out.println("三、判断题（每题2分，10题，共20分）");
		JudgleQuestionService questionService=new JudgleQuestionServiceImpl();
		List<JudgleQuestion> judgleQuestions=questionService.getJudgleQuestion(sql, courseId);
		int index=0;
		for(int i=1;i<=10&&judgleQuestions.size()>0;i++){
			index=(int) (Math.random()*judgleQuestions.size());
			JudgleQuestion jq=judgleQuestions.get(index);
			judgleQuestions.remove(index);
			System.out.println(i+"."+jq.getJqTitle());
			System.out.println("请输入你的答案");
			String answer=input.next();
			if(jq.getJqAnswer().equals(answer)){
				System.out.println("正确：\t答案是："+jq.getJqAnswer()+"\t你的答案是："+answer);
				
			}else{
				System.out.println("错误：\t答案是："+jq.getJqAnswer()+"\t你的答案是："+answer);
			}
			QuestionService qs=new QuestionServiceImpl();
			qs.insertQuestion("insert into Question_db(qid,tpId,qtype,inputAnswer) values(?,?,?,?)",jq.getJqId(),tpId,3,answer);
			
		}
	}
	/**
	 * 填空题
	 * @param courseId
	 * @param tpId
	 * @param input
	 */
	private void loadFillQuestion(String courseId, int tpId, Scanner input) {
		// TODO 自动生成的方法存根
		String sql="select*from FillQuestion_db where cid=?";
		System.out.println("二、填空题（每题两分，10题，共20分）");
		FillQuestionService questionService=new FillQuestionServiceImpl();
		List<FillQuestion> fillQuestions=questionService.getFillQuestion(sql, courseId);
		int index=0;
		for(int i=1;i<=10&fillQuestions.size()>0;i++){
			index=(int) (Math.random()*fillQuestions.size());
			FillQuestion fq=fillQuestions.get(index);
			fillQuestions.remove(index);
			System.out.println(i+"."+fq.getFqTitle());
			System.out.println("请输入你的答案");
			String answer=input.next();
			if(fq.getFqAnswer().equals(answer)){
				System.out.println("正确：\t答案是：" + fq.getFqAnswer() + "\t你的答案是：" + answer);
			}else{
				System.out.println("错误：\t答案是："+fq.getFqAnswer()+"\t你的答案是："+answer);
			}
			QuestionService qs=new QuestionServiceImpl();
			qs.insertQuestion("insert into Question_db(qid,tpId,qType,inputAnswer)values(?,?,?,?)", fq.getFqId(),tpId,2,answer);
		}
	}
	/**
	 * 选择题
	 * @param courseId
	 * @param tpId
	 * @param input
	 */
	private void loadChoiceQuestion(String courseId, int tpId, Scanner input) {
		// TODO 自动生成的方法存根
		String sql="select*from ChoiceQuestion_db where cid=?";
		System.out.println("========================");
		System.out.println("================答题区==========");
		System.out.println("一、选择题（每题2分，10题，共20分）");
		ChoiceQuestionService questionService=new ChoiceQuestionServiceImpl();
		List<ChoiceQuestion> choiceQuestion=questionService.getChioceQuestion(sql, courseId);
		int index=0;
		for(int i=1;i<=10&&choiceQuestion.size()>0;i++){//一共加载十个选择题
			index=(int)(Math.random()*choiceQuestion.size());//随机选取一个
			ChoiceQuestion cq=choiceQuestion.get(index);
			choiceQuestion.remove(index);
			System.out.println(i+"."+cq.getTitle());//输出题目标题
			System.out.println(i+"."+cq.getChoiceA());
			System.out.println(i+"."+cq.getChoiceB());
			System.out.println(i+"."+cq.getChoiceC());
			System.out.println(i+"."+cq.getChoiceD());
			System.out.println("请输入你的答案");
			String answer=input.next();
			if(!cq.getAnswer().equals(answer)){
				System.out.println("错误：\t答案是："+cq.getAnswer()+"\t你的答案是："+answer);
			}else{
				System.out.println("正确：\t答案是："+cq.getAnswer()+"\t你的答案是："+answer);
			}
			QuestionService qs=new QuestionServiceImpl();
			qs.insertQuestion("insert into Question_db(qid,tpId,qType,inputAnswer)values(?,?,?,?)", cq.getId(),tpId,1,answer);
		}
	}
	/**
	 * 创建试卷
	 * @param input
	 * @param courseId
	 * @return
	 */
	private int createPaper(Scanner input, String courseId) {
		// TODO 自动生成的方法存根
		if(clearTest(input,courseId)==false){
			System.out.println("取消考试，推出系统");
			System.exit(0);
		}
		TestPageService paperService=new TestPageServiceImpl();
		paperService.inserTestPage("insert into TestPage_db(sno,cid) values(?,?)", Const.USER.id,courseId);
		paperService=new TestPageServiceImpl();
		List<TestPage> paper=paperService.getTestPage("select *from TestPage_db where sno=? and cid=?", Const.USER.id,courseId);
		if(paper!=null&&paper.size()==1){
			TestPage tp=paper.get(0);
			return tp.getTpId();
		}
		return -1;
	}
	/**
	 * 删除学生指定课程的卷子
	 * @param input
	 * @param courseId
	 * @return
	 */
	private boolean clearTest(Scanner input, String courseId) {
		// TODO 自动生成的方法存根
		TestPageService paperService=new TestPageServiceImpl();
		List<TestPage> paper=paperService.getTestPage("select*from TestPage_db where sno=? and cid=?",Const.USER.id,courseId);
		if(paper!=null&&paper.size()==1){
			System.out.println("该门课程已经考试过，继续考试前面考试将作废，你要继续考试吗？（y/n）");
			String cho=input.next();
			if("y".equals(cho)){//如果继续就删除指定课程的卷子
				ClearQustion(paper.get(0).getTpId());//清空题目
				paperService=new TestPageServiceImpl();
				paperService.deleteTestPage("delete from TestPage_db where sno=? and cid=?", Const.USER.id,courseId);
				//删除试卷
				return true;//删除后可以重新创建
				
			}
			return false;//没有删除不能继续答题，将退出系统
		}
		return true;//如果原来的数据库中不存在该门课程学生的考试记录， 就可以创建卷子
	}
	/**
	 * 删除指定的卷子题目
	 * @param tpId
	 */
	private void ClearQustion(int tpId) {
		// TODO 自动生成的方法存根
		QuestionService questionService=new QuestionServiceImpl();
		questionService.deleteQuestion("delete from Question_db where tpId=?", tpId);//删除题目
		
	}
	private String loadCourse(Scanner input) {
		String sql="select c.cid,c.cname,c.credit,c.departId,c.tno from Course_db c,Score_db sc where sc.cid=c.cid and sc.sno=? and c.departId=?";
		System.out.println("************请选择要考试的课程********");
		CourseService courseService=new CourseServiceImpl();
		List<Course> course=courseService.getCourse(sql, Const.USER.getId(),Const.USER.departid);
		for(Course cou:course){
			System.out.println("*        "+cou.getName()+"("+cou.getId()+")");
		}
		System.out.println("***************请输入你的选择（输入编号）*********");
		
		// TODO 自动生成的方法存根
		return input.next();
	}
	private void selectCourse(Scanner input) {
		// TODO 自动生成的方法存根
		String cid="o";
		String conti="y";
		do{
			CourseService courseService=new CourseServiceImpl();
			ScoreService scoreService=new ScoreServiceImpl();
			System.out.println("************本专业可供你选择学习的课程***********");
			List<Course> course=courseService.getCourse("select*from Course_db where departId=? and cid not in(select cid from Score_db where sno=?)", 
				Const.USER.departid,Const.USER.id);
			if(course==null||course.size()==0){
				System.out.println("没有可供选择的课程了，即将推出选课");
				break;
			}
			for(Course cou:course){
				System.out.println("*      "+cou.getName()+"("+cou.getId()+")");
			}
				cid=input.next();
				if(cid.equals("e")){
					break;
				}
				//============不等于o,就插入到成绩表中=========
				scoreService.insertScore("insert into Score_db(sno,cid) values(?,?)", Const.USER.id,cid);
				System.out.println("是否继续选课？（y/n）");
				conti=input.next();
				
			}while("y".equals(conti));
		
		
	}
	private void login(Scanner input) {
		// TODO 自动生成的方法存根
		String sql="select *from Student_db where sno=? and spassword=?";
		System.out.println("*********请输入登陆信息进行登陆**********");
		do{
			System.out.println("*请输入用户账号：");
			String sno=input.next();
			System.out.println("\n*请输入登陆密码：");
			String pwd=input.next();
			LoginService loginService=new LoginServiceImpl();
			MD5Encodes md5=new MD5Encodes();
			result=loginService.login(sql, sno,md5.EncodeByMD5(pwd));
			
		}while(!Const.SUCCESS.equals(result));
		System.out.println("登陆成功");
	}

}
