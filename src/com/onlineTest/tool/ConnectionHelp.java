package com.onlineTest.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelp {
	private Connection connection=null;
	private String url="jdbc:mysql://localhost:3306/online";
	private String driver="com.mysql.jdbc.Driver";
	private String user="root";
	private String password="123456";
	public ConnectionHelp() {
		// TODO 自动生成的构造函数存根
		try{
			Class.forName(driver);
			connection=DriverManager.getConnection(url,user,password);
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
