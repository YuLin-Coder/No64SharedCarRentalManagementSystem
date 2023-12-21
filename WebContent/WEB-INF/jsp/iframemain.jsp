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

<title>共享型汽车租赁系统</title>

<!-- 基础定义的样式  -->

<!-- 后台框架页面样式 -->
<link rel="stylesheet" href="css/css/background/css2/admin.css"
	type="text/css" />
<!-- 引入字体图表 -->
<link
	href="css/css/background/css/Font-Awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Jquery支持 -->
<script type="text/javascript" src="js/js/background/js/jquery.js"></script>

<script src="js/js/background/js/tooltip.js" type="text/javascript"></script>
<link href="css/css/background/css/tooltip.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="js/js/background/layer/layer.js"></script>
<!-- 后台框架控制 -->
<script type="text/javascript" src="js/js/background/js/admin.js"></script>
</head>

<body>
	<div class="backAdmin">
		<div class="top">
			&nbsp;&nbsp;&nbsp; <img
				src="image/image/background/images/act.png" width="310"
				height="24" style="margin-top: 13px" />


			<div class="topright">
				<ul>
					</li>
					<li><a href="javascript:void(0)" onclick="logout()">安全退出</a><sup></sup></li>
				</ul>


			</div>
		</div>
		<div class="left">
			<div class="lefttop">
				<i class="icon-cloud icon-large pull-left icon-border"></i> <span><a
					href="request/right" target="rightFrame"><font
						color='white'>首页</font></a></span>
			</div>

			<dl class="leftmenu">
					<dd>
						<div class="title">
							<i class="icon-edit icon-large pull-left icon-border"></i>${sessionScope['Admin']['roleInfo']['title'] }
						</div>
						<ul class="menuson">
						 <c:forEach items="${sessionScope['Admin']['functionRoleRel'] }" var="functionRoleRel">
							<li><i class="icon-list"></i> <a
								href="${functionRoleRel['functionInfo']['url'] }" target="rightFrame">${functionRoleRel['functionInfo']['title'] }</a></li>
						</c:forEach>
						</ul>
					</dd>


			</dl>


		</div>
		<div class="right">
			<div class="inner">
				<div class="scroll-wrapper">
					<!-- 设置iframe -->
					<iframe id="rightFrame" name="rightFrame" class="mainIframe"
						scrolling="yes" frameborder="1" src="request/right"
						onload="initIframe()" style="width: auto; height: auto;"></iframe>
				</div>
			</div>
		</div>
		<div class="bottom">
			<span>共享型汽车租赁系统</span> <i> 版权所有 @ 2018 </i>
		</div>
	</div>
</body>
<script type="text/javascript">
function logout(){
    $(function(){
        if(window.confirm("您确定要退出该系统吗?")){
            window.top.location.href="user/logout";
        }
    })
}
/* ${path}/jzcm/ */
</script>
</html>