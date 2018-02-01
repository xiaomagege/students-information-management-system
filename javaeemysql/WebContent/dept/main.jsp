<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.neusoft.dao.Dept"%>
       <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=basePath %>dept/insert.jsp" method="post">

<table border="1" width="80%" align="center" cellspacing="0">
<caption>学生信息表</caption>
<tr><th>学生学号</th><th>学生姓名</th><th>家庭地址</th><th>操作</th><tr>
<%List<Dept>  depts=(List<Dept>)request.getAttribute("depts");
if(depts==null)
{
%>
<tr><td colspan="3">没有符合条件的数据</td></tr>
<%}else{ 
	for(Dept dept:depts)
	{
 
%>
<tr><td><%=dept.getDeptno() %></td>
<td><%=dept.getDname() %></td>
<td><%=dept.getLoc()  %></td>
<td><a href="DeptServlet?service=modify&deptno=<%=dept.getDeptno()%>">修改</a>
<a href="DeptServlet?service=delete&deptno=<%=dept.getDeptno() %>" >删除</a></td>
<tr>

<%}} %>
</table>
<input type="submit" value="添加" >
</form>
</body>
</html>