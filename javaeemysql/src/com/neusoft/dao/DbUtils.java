package com.neusoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtils {
private DbUtils(){}
private static final String url="jdbc:mysql://localhost:3306/smartstyle";;
private static final  String user="root";
private static  final String password="857289";
static
{
	//1.创建驱动类对象
	//new oracle.jdbc.driver.OracleDriver();
	try {
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
public static  Connection getConnection()
{
	Connection conn=null;	
	try {
		conn=DriverManager.getConnection(url, user, password);
		System.out.println("Ok");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
	}
public static void closeConnection(Connection conn)
{
	try {
		if(conn!=null)
		{
		conn.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
public static void closePreparedStatement(PreparedStatement pstmt)
{
	try {
		if(pstmt!=null)
		{
		pstmt.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
public static void closeResultSet(ResultSet rs)
{
	//4.关闭数据库
			try {
				if(rs!=null)
				{
				rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


public static void beginTransaction(Connection conn) {
	try {
		conn.setAutoCommit(false);
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
}

public static void commit(Connection conn) {
	try {
		conn.commit();
		conn.setAutoCommit(true);
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
}

public static void rollback(Connection conn) {
	try {
		conn.rollback();
		conn.setAutoCommit(true);
	} catch (SQLException ex) {
		ex.printStackTrace();
	}
}
public static void main(String[] ars)
{
	 getConnection();
	}
}
