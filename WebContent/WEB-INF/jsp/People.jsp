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
					Hi，<b>${sessionScope['User']['userName']}</b>，欢迎您使用信息编辑功能！
				</div>

				<!-- form表单 -->

				<form action="people/informationUpdate" method="POST"
					onsubmit="return checkSubmit();">
					<input type="hidden" name="id" value="${people['id'] }">
					<ul class="forminfo">
						<li><label>姓名<b>*</b></label><input id="name" value="${people['name'] }"
							name="name" type="text" class="dfinput" placeholder="请填写姓名"
							style="width: 518px;" /></li>
						<li><label>年龄<b>*</b></label><input id="age" value="${people['age'] }"
							name="age" type="text" class="dfinput" placeholder="请填写年龄"
							style="width: 518px;" /></li>
						<li><label>性别<b>*</b></label><div class="vocation"> 
							<select class="select3" name="sex" id="sex">
									<c:if test="${people['sex'] eq 1}" var="s1">
										<option value="1" selected="selected">男</option>
									</c:if>
									<c:if test="${!s1}">
										<option value="1">男</option>
									</c:if>
									<c:if test="${people['sex'] eq 2}" var="s2">
										<option value="2" selected="selected">女</option>
									</c:if>
									<c:if test="${!s2}">
										<option value="2">女</option>
									</c:if>
						</select></div></li>
						<li><label>地址<b>*</b></label><input id="address" value="${people['address'] }"
							name="address" type="text" class="dfinput" placeholder="请填写地址"
							style="width: 518px;" /></li>
						<li><label>电话<b>*</b></label><input id="phone" value="${people['phone'] }"
							name="phone" type="text" class="dfinput" placeholder="请填写电话"
							style="width: 518px;" /></li>
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value="修改信息" /></li>
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
var birth = {
		  elem: '#birth',
		  format: 'YYYY-MM-DD',
		  min: '1900-01-01', //设定最小日期为当前日期
		  max: '2099-06-16', //最大日期
		  istime: true,
		  istoday: false,
		  choose: function(datas){
		     end.min = datas; //开始日选好后，重置结束日的最小日期
		     end.start = datas //将结束日的初始值设定为开始日
		  }
		};
		laydate(birth);
    var checkSubmitFlg = false; 
    function checkSubmit() { 
      if (checkSubmitFlg == true) { 
         return false; 
      } 
      var name = $("#name").val();
      var age = $("#age").val();
      var phone = $("#phone").val();
      var address = $("#address").val();
		if(!$.trim(name)){
			alert('请输入姓名!');
			return false;
		}
		if(!$.trim(age)){
			alert('请输入年龄!');
			return false;
		}
		if(!$.trim(address)){
			alert('请输入地址!');
			return false;
		}
		if(!$.trim(phone)){
			alert('请输入电话!');
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
