package com.onlineTest.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineTest.bean.TestPage;
import com.onlineTest.dao.Basedao;
import com.onlineTest.dao.impl.BaseDaoimpl;
import com.onlineTest.service.TestPageService;

public class TestPageServiceImpl implements TestPageService{
	private Basedao bdi=null;
	public TestPageServiceImpl() {
		// TODO 自动生成的构造函数存根
		bdi=new BaseDaoimpl();
	}

	@Override
	public void inserTestPage(String sql, Object... objects) {
		// TODO 自动生成的方法存根
		try{
			int n=bdi.insert(sql, objects);
			if(n==1){
				System.out.println("试卷生成成功");
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			bdi.close();
		}
	}

	@Override
	public List<TestPage> getTestPage(String sql, Object... objects) {
		// TODO 自动生成的方法存根
		List<TestPage> page=new ArrayList<>();
		try{
			ResultSet re=bdi.getEntity(sql, objects);
			while(re.next()){
				int tpId=re.getInt(1);
				String sno=re.getString(2);
				String cid=re.getString(3);
				int score=re.getShort(4);
				TestPage p=new TestPage(tpId,sno,cid,score);
				page.add(p);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			bdi.close();
		}
		return page;
	}

	@Override
	public void deleteTestPage(String sql, Object... objects) {
		// TODO 自动生成的方法存根
		try{
			int n=bdi.delete(sql, objects);
			if(n==1){
				System.out.println("删除成功，重新生成试卷");
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			bdi.close();
		}
	}

}
