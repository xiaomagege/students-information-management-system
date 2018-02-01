package com.neusoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DeptDaoImpl implements DeptDao {

	@Override
	public void insertDept(Dept dept) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
				try {
					conn=DbUtils.getConnection();
					//3.操作数据库					
					String sql="insert into dept(deptno,dname,loc) values(?,?,?)";					
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, dept.getDeptno());
					pstmt.setString(2, dept.getDname());
					pstmt.setString(3,dept.getLoc());
					
					pstmt.executeUpdate();
					
				}  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
			
				//4.关闭数据库		
					DbUtils.closePreparedStatement(pstmt);
					DbUtils.closeConnection(conn);
				}
			
				
	}

	@Override
	public void updateDept(Dept dept) {
		// TODO Auto-generated method stub
Connection conn=null;
PreparedStatement pstmt=null;


try {
	conn=DbUtils.getConnection();
	String sql="update dept set dname=?,loc=? where deptno=?";
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, dept.getDname());
	pstmt.setString(2, dept.getLoc());
	pstmt.setInt(3, dept.getDeptno());
	
	pstmt.executeUpdate();
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally
{
	//4.关闭数据库		
	DbUtils.closePreparedStatement(pstmt);
	DbUtils.closeConnection(conn);
	}

	}

	@Override
	public void deleteDept(int deptno) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DbUtils.getConnection();
			String sql="delete from dept where deptno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			//4.关闭数据库		
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
		
	}

	@Override
	public List<Dept> getDepts() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Dept>  depts=new ArrayList<Dept>();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			String sql="select * from dept";			
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Dept dept=new Dept();
				dept.setDeptno(rs.getInt("DEPTNO"));//
				dept.setDname(rs.getString("DNAME"));
				dept.setLoc(rs.getString("LOC"));
				depts.add(dept);
				
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
	    DbUtils.closeResultSet(rs);
		DbUtils.closePreparedStatement(pstmt);
		DbUtils.closeConnection(conn);
		
		}
		return depts;
	}

	@Override
	public Dept getDeptByDeptno(int deptno) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Dept  dept=new Dept();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			String sql="select * from dept where deptno=?";			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dept.setDeptno(rs.getInt("DEPTNO"));
				dept.setDname(rs.getString("DNAME"));
				dept.setLoc(rs.getString("LOC"));
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
	    DbUtils.closeResultSet(rs);
		DbUtils.closePreparedStatement(pstmt);
		DbUtils.closeConnection(conn);
		
		}
		return dept;
	}

}
