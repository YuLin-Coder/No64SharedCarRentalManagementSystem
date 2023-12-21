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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href=" css/css/background/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="css/css/background/css/select.css" rel="stylesheet"
	type="text/css" />
<link href="js/js/background/js/laydate/need/laydate.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="js/js/background/js/laydate/laydate.js"></script>
<script type="text/javascript" src="js/js/background/js/jquery.js"></script>
<script type="text/javascript"
	src="js/js/background/js/jquery.idTabs.min.js"></script>
<script type="text/javascript"
	src="js/js/background/js/select-ui.min.js"></script>
<script type="text/javascript"
	src="js/js/background/editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>

<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>


	<div class="formbody">


		<div id="usual1" class="usual">

			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">发布信息</a></li>
				</ul>
			</div>

			<div id="tab1" class="tabson">

				<div class="formtext">
					Hi，<b>${sessionScope['Admin']['userName']}</b>，欢迎您使用信息编辑功能！
				</div>

				<!-- form表单 -->

				<form action="user/userAdd" method="POST"
					onsubmit="return checkSubmit();">
					<ul class="forminfo">
						<li><label>登录名<b>*</b></label><input id="loginName"
							name="loginName" type="text" class="dfinput" placeholder="请填写登录名"
							style="width: 518px;" /></li>
						<li><label>用户姓名<b>*</b></label><input id="userName"
							name="userName" type="text" class="dfinput" placeholder="请填写用户姓名"
							style="width: 518px;" /></li>
						<li><label>登录密码<b>*</b></label><input id="loginPassword"
							name="loginPassword" type="text" class="dfinput"
							placeholder="请填写登录密码" style="width: 518px;" /></li>
						<li><label>电话<b>*</b></label><input id="phone" name="phoneNo"
							type="text" class="dfinput" placeholder="请填写电话"
							style="width: 518px;" /></li>
						<li><label>角色<b>*</b></label><div class="vocation"> <c:if test="${message!=null }">
								<c:out value="${message }"></c:out>
							</c:if> <select class="select3" name="roleId" id="roleId">
								<c:forEach items="${role }" var="role">
									<option value="${role['id'] }">${role['title'] }</option>
								</c:forEach>
						</select></div></li>
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="添加信息" /></li>
					</ul>

				</form>
			</div>

		</div>

		<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>

		<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>





	</div>


</body>
<script type="text/javascript"> 
    var checkSubmitFlg = false; 
    function checkSubmit() { 
      if (checkSubmitFlg == true) { 
         return false; 
      } 
      var userName = $("#userName").val();
      var loginName = $("#loginName").val();
      var loginPassword = $("#loginPassword").val();
      var phone = $("#phone").val();
      var address = $("#address").val();
		if(!$.trim(userName)){
			alert('请输入用户名!');
			return false;
		}
        if(!$.trim(loginName)){
            alert('请输入登录名!');
            return false;
        }
        if(!$.trim(phone)){
            alert('请输入电话!');
            return false;
        }
        if(!$.trim(loginPassword)){
            alert('请输入登录密码!');
            return false;
        }
      checkSubmitFlg = true;
      return true; 
   } 
   document.ondblclick = function docondblclick() { 
    window.event.returnValue = false; 
   } 
   document.onclick = function doconclick() { 
       if (checkSubmitFlg) { 
         window.event.returnValue = false; 
       } 
   } 
</script>
</html>
