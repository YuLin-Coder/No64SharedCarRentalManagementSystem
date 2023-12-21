<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%
   String path = request.getContextPath();
   String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
   /*
   @Author:Jaylan Zhou
   @Date:
   @projectName:
   @TEL:13166803607
   @QQ:764540631
   */

	/*
	    全路径,形式如下:
	    request.getScheme():获取http协议
	    request.getServerName():获取本地服务器名
	    request.getServerPort():获取服务器端口号
	    path:访问路径
	*/

%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basepath%>">
<meta charset="UTF-8">
<title>网站信息</title>
<link href="css/css/background/css/style.css" rel="stylesheet"
	type="text/css" />

</head>

<body>
	<div class="footer">
		<span>码迷码迷吽, 仅供学习交流，请勿用于任何商业用途</span> <i> 版权所有 @ 2016
			http://pangsir8983.github.io </i>
	</div>
</body>
</html>