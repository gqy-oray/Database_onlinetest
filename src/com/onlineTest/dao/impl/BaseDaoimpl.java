package com.onlineTest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlineTest.dao.Basedao;
import com.onlineTest.tool.ConnectionHelp;

public class BaseDaoimpl implements Basedao{
	private Connection connection=null; 
	private ConnectionHelp connectionhelp=null;
	private PreparedStatement pst=null;
	private ResultSet re=null;
	public BaseDaoimpl() {
		// TODO 自动生成的构造函数存根
		connectionhelp=new ConnectionHelp();//实例化数据库连接对象
		connection=connectionhelp.getConnection();//通过数据库帮助类调用getConnection()给数据库对象赋值
		
	}

	@Override
	public ResultSet getEntity(String sql, Object... objects) throws SQLException {
		// TODO 自动生成的方法存根
		pst=connection.prepareStatement(sql);
		for(int i=0;i<objects.length;i++){//objects表示条件的参数
			pst.setObject(i+1, objects[i]);//给执行sql语句的pst对象执行设置条件
			
		}
		re=pst.executeQuery();//返回一个一直执行结果赋值给re对象
		return re;
	}
	public void close(){
		try{
			if(re!=null){
				re.close();
			}
			if(pst!=null){
				pst.close();
			}
			if(connection!=null){
				connection.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public int insert(String sql, Object... objects) throws SQLException {
		pst=connection.prepareStatement(sql);
		for(int i=0;i<objects.length;i++){
			pst.setObject(i+1, objects[i]);
		}
		return pst.executeUpdate();
	}

	@Override
	public int delete(String sql, Object... objects) throws SQLException {
		// TODO 自动生成的方法存根
		pst=connection.prepareStatement(sql);
		for(int i=0;i<objects.length;i++){
			pst.setObject(i+1, objects[i]);
		}
		return pst.executeUpdate();
	}

}
