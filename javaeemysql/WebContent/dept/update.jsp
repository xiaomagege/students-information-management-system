<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.neusoft.dao.Dept"%>
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
<form action="<%=basePath %>DeptServlet?service=update" method="post">

<center>
<h1>修改信息</h1>
<% Dept dept=(Dept)request.getAttribute("dept"); %>
学生学号：<input type="text" name="deptno" value="<%=dept.getDeptno()   %>"><br>
学生姓名:<input type="text" name="dname" value="<%=dept.getDname() %>"><br>
家庭地址：<input type="text" name="loc" value="<%=dept.getLoc()%>  "><br>
<input type="submit" value="修改信息">

</body>
</html>