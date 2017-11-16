package com.onlineTest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Basedao {
	public abstract ResultSet getEntity(String sql,Object...objects)throws SQLException;
	
	public abstract int insert(String sql,Object...objects) throws SQLException;
	
	public abstract int delete(String sql,Object...objects) throws SQLException;
	
	public abstract void close();

}
