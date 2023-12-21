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
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>共享型汽车租赁系统 - 登录</title>
<link rel="stylesheet" type="text/css" href="css/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/css/component.css" />
<!--[if IE]>
<script src="js/js/html5.js"></script>
<![endif]-->
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>共享型汽车租赁系统</h3>
						<form action="user/login" id="login" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="loginName" id="loginName" class="text" style="color: #FFFFFF !important" type="text" value="${loginName}" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="loginPassword" id="loginPassword" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" value="${loginPassword}" type="password" placeholder="请输入密码">
							</div>
								<font color="red"><c:out value="${messageLogin}"/></font>
							<div class="mb2"><a class="act-but submit" href="javascript:;" onclick="check();" style="color: #FFFFFF">登录</a></div>
							<div class="mb2"><a class="act-but submit" href="request/welcome"  style="color: #FFFFFF">前台页面</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="js/js/TweenLite.min.js"></script>
		<script src="js/js/EasePack.min.js"></script>
		<script src="js/js/rAF.js"></script>
		<script src="js/js/demo-1.js"></script>
		<script src="js/js/background/js/jquery-1.4.4.min.js"></script>
	</body>
<script type="text/javascript">

	function check() {
        var loginName = $("#loginName").val();
        var loginPassword = $("#loginPassword").val();
        if(loginName==""){
            alert("请输入用户名");
            return false;
        }
        if(loginPassword==""){
            alert("请输入密码");
            return false;
		}
		$("#login").submit();
		return true;
    }

</script>
</html>