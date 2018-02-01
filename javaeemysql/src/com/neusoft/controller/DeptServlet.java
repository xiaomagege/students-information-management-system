package com.neusoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.Dept;
import com.neusoft.service.DeptService;
import com.neusoft.service.DeptServiceImpl;

/**
 * Servlet implementation class DeptServlet
 */
@WebServlet("/DeptServlet")
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeptServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String service=request.getParameter("service");
		if("all".equals(service))
		{
			DeptService deptService=new DeptServiceImpl();
			List<Dept> depts=deptService.getDepts();
			
			request.setAttribute("depts", depts);
			
			request.getRequestDispatcher("dept/main.jsp").forward(request, response);
		}else if("add".equals(service))
		{
			//处理请求
			int deptno=Integer.parseInt(request.getParameter("deptno"));
			String dname=request.getParameter("dname");
			String loc=request.getParameter("loc");
			Dept dept=new Dept();
			dept.setDeptno(deptno);
			dept.setDname(dname);
			dept.setLoc(loc);
			
			//调用相应的业务逻辑
			DeptService deptService=new DeptServiceImpl();
			deptService.insertDept(dept);
			
			//找到某个视图响应回去
			request.getRequestDispatcher("DeptServlet?service=all").forward(request, response);
		}else if("update".equals(service))
		{
			//处理请求
			int deptno=Integer.parseInt(request.getParameter("deptno"));
			String dname=request.getParameter("dname");
			String loc=request.getParameter("loc");
			Dept dept=new Dept();
			dept.setDeptno(deptno);
			dept.setDname(dname);
			dept.setLoc(loc);
			
			//调用相应的业务逻辑
			DeptService deptService=new DeptServiceImpl();
			deptService.updateDept(dept);
			
			//找到某个视图响应回去
		
			request.getRequestDispatcher("DeptServlet?service=all").forward(request, response);
			
		}
		else if("delete".equals(service))
		{
			
			int deptno=Integer.parseInt(request.getParameter("deptno"));
			//调用相应的业务逻辑
			DeptService deptService=new DeptServiceImpl();
			deptService.deleteDept(deptno);
			
			//找到某个视图响应回去
			request.getRequestDispatcher("DeptServlet?service=all").forward(request, response);
			
		}else if("modify".equals(service))
		{
			int deptno=Integer.parseInt(request.getParameter("deptno"));
			//调用相应的业务逻辑
			DeptService deptService=new DeptServiceImpl();
		Dept dept=	deptService.getDeptByDeptno(deptno);
		
		request.setAttribute("dept", dept);
			//找到某个视图响应回去
			request.getRequestDispatcher("dept/update.jsp").forward(request, response);
			
		}
	}

}
