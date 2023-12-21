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
		width : 250		  
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

				<form action="car/informationUpdate" method="POST" enctype="multipart/form-data"
					onsubmit="return checkSubmit();">
					<input type="hidden" name="id" value="${car['id'] }">
					<ul class="forminfo">
						<li><label>车辆名称<b>*</b></label><input id="name" value="${car['name'] }"
							name="name" type="text" class="dfinput" placeholder="请填写车辆名称"
							style="width: 518px;" /></li>
						<li><label>车牌号码<b>*</b></label><input id="code" value="${car['code'] }"
							name="code" type="text" class="dfinput" placeholder="请填写车牌号码"
							style="width: 518px;" /></li>
						<li><label>车辆品牌<b>*</b></label><input id="factory" value="${car['factory'] }"
							name="factory" type="text" class="dfinput" placeholder="请填写车辆品牌"
							style="width: 518px;" /></li>
						<li><label>座位数<b>*</b></label><input id="stand" value="${car['stand'] }" 
							name="stand" type="text" class="dfinput" placeholder="请填写座位数"
							style="width: 518px;" /></li>
						<li><label>所在地址<b>*</b></label><input id="address" value="${car['address'] }" 
							name="address" type="text" class="dfinput" placeholder="请填写所在地址"
							style="width: 518px;" /></li>
						<li><label>租赁价格<b>*</b></label><input id="price" value="${car['price'] }"
							name="price" type="text" class="dfinput" placeholder="请填写车辆价格"
							style="width: 518px;" /></li>
						<li><label>车辆类型<b>*</b></label><div class="vocation">
						 <select class="select3" name="type_id" id="type_id">
									<c:forEach items="${typeList }" var="carType">
											<c:if test="${car['type']['id'] eq carType['id']}" var="s1">
												<option value="${carType['id'] }" selected="selected">${carType['name'] }</option>
											</c:if>
											<c:if test="${!s1}">
												<option value="${carType['id'] }">${carType['name'] }</option>
											</c:if>
									</c:forEach>
							</select></div></li>
						<li><label>上传照片<b>*</b></label><input type="file" id="file" name="file"></li>
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
      var factory = $("#factory").val();
      var code = $("#code").val();
      var price = $("#price").val();
      var stand = $("#stand").val();
      var address = $("#address").val();
		if(!$.trim(name)){
			alert('请输入车辆名称!');
			return false;
		}
		if(!$.trim(code)){
			alert('请输入车牌号码!');
			return false;
		}
		if(!$.trim(factory)){
			alert('请输入车辆品牌!');
			return false;
		}
		if(!$.trim(price)){
			alert('请输入车辆价格!');
			return false;
		}
		if(!$.trim(stand)){
			alert('请输入座位数!');
			return false;
		}
		if(!$.trim(address)){
			alert('请输入所在地址!');
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
