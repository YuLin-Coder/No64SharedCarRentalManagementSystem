<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html;" charset=UTF-8">
<link href="css/css/foreground/common.css" rel="stylesheet" type="text/css" />
<link href="css/css/foreground/a.css" rel="stylesheet" type="text/css" />
<link href="css/css/foreground/searchform.css" rel="stylesheet" type="text/css" />
<link href="css/css/foreground/pagetitlemenu_b2.css" rel="stylesheet" type="text/css" />
<link href="css/css/foreground/jobform.css" rel="stylesheet" type="text/css" />
<link href="css/css/foreground/jobcontent.css" rel="stylesheet" type="text/css" />
<link href="css/css/foreground/f.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/js/foreground/base.js"></script>
<script type="text/javascript" src="js/js/foreground/common.js"></script>
<script type="text/javascript" src="js/js/foreground/form.js"></script>
<script type="text/javascript" src="js/js/foreground/blockui.js"></script>
<script type="text/javascript" src="js/js/foreground/channelmenu_1030.js"></script>
<script type="text/javascript" src="js/js/foreground/jobform.js"></script>
<title>共享型汽车租赁系统</title>
</head>
<body style='background:#ffffff'>
<script>
var PDV_PAGEID='293'; 
var PDV_RP='index.html'; 
var PDV_COLTYPE='job'; 
var PDV_PAGENAME='detail'; 
</script>

<div id='contain' style='width:900px;background:#ffffff;margin:0px auto;padding:10px'>

<div id='top' style='width:900px;height:133px;background:none transparent scroll repeat 0% 0%'>


<!-- 二级导航菜单 -->

<div id='pdv_3507' class='pdv_class'   style='width:900px;height:71px;top:60px;left:0px; z-index:2'>
<div id='spdv_3507' class='pdv_top' style='overflow:hidden;width:100%;height:100%'>
<div class="pdv_border" style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
	<div style="height:25px;margin:1px;display:none;background:;">
		<div style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">
		导航菜单
		</div>
		<div style="float:right;margin-right:10px;display:none">
		<a href="-13.html" style="line-height:25px;color:">更多</a>
		</div>
	</div>
<div style="padding:0px">


<div id="channelmenu">
<div id="channelmenumain">


<a href="request/welcome" target="_self" class="channelmenu_main" id="channelmenu_main_0" onMouseOver="showSubMenu('channelmenu_main','channelmenu_sub','0')">首页</a>
<c:if test="${sessionScope['User'] ne null and sessionScope['User'] ne '' }">
	<a href="car/informationLoadFore" target="_self" class="channelmenu_main" id="channelmenu_main_1" onMouseOver="showSubMenu('channelmenu_main','channelmenu_sub','1')">汽车租赁</a>

	<a href="request/login" target="_self" class="channelmenu_main" id="channelmenu_main_5" onMouseOver="showSubMenu('channelmenu_main','channelmenu_sub','5')">后台系统</a>
		<a href="user/queryOneFore?id=${sessionScope['User']['id'] }" target="_self" class="channelmenu_main" id="channelmenu_main_6" onMouseOver="showSubMenu('channelmenu_main','channelmenu_sub','6')">个人中心</a>
</c:if>
</div>
	<div id="channelmenu_sub">
		<div id="channelmenu_sub_left"></div><div id="channelmenu_sub_right"></div>
		<ul>
</ul>
<ul>
</ul>
<ul>
</ul>
<ul>
</ul>
<ul>
</ul>
<ul>
</ul>
<ul>
</ul>
<ul>
</ul>


		</div>
</div>


<script>initSubMenu('channelmenu_main','channelmenu_sub','');</script>

</div>
</div>

</div>
</div>

<!-- 网站标志 -->

<div id='pdv_3604' class='pdv_class'  title='网站标志' style='width:180px;height:70px;top:5px;left:6px; z-index:3'>
<div id='spdv_3604' class='pdv_top' style='overflow:hidden;width:100%;height:100%'>
<div class="pdv_border" style="margin:0;padding:0;height:100%;border:0px #dddddd solid;background:#fff;">
	<div style="height:25px;margin:1px;display:none;background:#cccccc;">
		<div style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:#fff">
		网站标志
		</div>
		<div style="float:right;margin-right:10px;display:none">
		<a href="-13.html" style="line-height:25px;color:#fff">更多</a>
		</div>
	</div>
<div style="padding:0px">


<h2>共享型汽车租赁系统</h2>


</div>
</div>

</div>
</div>

<!-- 商品搜索表单 -->




<!-- 购物车提示信息 -->

</div>
<div id='content' style='width:900px;height:1417px;background:none transparent scroll repeat 0% 0%;margin:10px auto'>


<!-- 网页标题(菜单) -->

<div id='pdv_3363' class='pdv_class'  title='客户中心' style='width:169px;height:355px;top:0px;left:0px; z-index:1'>
<div id='spdv_3363' class='pdv_content' style='overflow:hidden;width:100%;height:100%'>
<div class="pdv_border" style="margin:0;padding:0;height:100%;border:1px #e0e0e0 solid;background:;">
	<div style="height:25px;margin:1px;display:none;background:;">
		<div style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">
		客户中心
		</div>
		<div style="float:right;margin-right:10px;display:none">
		<a href="-13.html" style="line-height:25px;color:">更多</a>
		</div>
	</div>
<div style="padding:0px">


<div class="titlemenu_b2" >


<a href="custom/informationLoadOneUser?user_id=${sessionScope['User']['id'] }" target="_self" class="titlemenu_b2">我的信息</a>


<a href="bargain/informationLoadFore" target="_self" class="titlemenu_b2">我的订单</a>


<!-- <a href="request/updateUserPassword?id=${sessionScope['User']['id'] }" target="_self" class="titlemenu_b2">修改密码</a>-->


 
</div>

</div>
</div>

</div>
</div>

<!-- 应聘申请表单 -->

<div id='pdv_3366' class='pdv_class'  title='职位信息' style='width:716px;height:480px;top:49px;left:184px; z-index:8'>
<div id='spdv_3366' class='pdv_content' style='overflow:visible;width:100%;'>
<div class="pdv_border" style="border:1px #d4d4d4 solid;height:100%;padding:0;margin:0;background:#fff">
<div style="position:relative;height:30px;border:0px;margin:-1px -1px 0px -1px;background:url(image/image/foreground/top-2.gif) left no-repeat">
	<div style="float:left;height:30px;font:bold 12px/30px Verdana, Arial, Helvetica, sans-serif;text-align:left;padding:0px 0px 0px 24px;color:#f26522;">
	用户注册
	</div>
	<div style="float:right;width:50px;height:30px;text-align:right;background:url(image/image/foreground/top-2.gif) -750px no-repeat">
	<a href="-13.html" style="font:12px/28px simsun;color:#555;margin-right:8px;display:none">更多&gt;&gt;</a>
	</div>
</div>
<div style="padding:20px">

<div  id="notice" class="noticediv"></div>
<form id="jobform" method="post" action="user/userAddF" name="jobform">
<table width="100%" border="0" cellspacing="0" cellpadding="3" >

<tr> 
      <td width="80" align="right">用 户 名：</td>
      <td> 
        <input type="text" name="loginName"  class="input" style="width:200px" />
        <font style='color:red'>*</font> <div style="padding-top:3px;color:#666"></div>  </td>
    </tr>

    <tr> 
      <td width="80" align="right">密   码：</td>
      <td> 
        <input type="text" name="loginPassword"  class="input" style="width:200px" />
        <font style='color:red'>*</font> <div style="padding-top:3px;color:#666"></div> </td>
    </tr>
    
     <tr> 
      <td width="80" align="right">姓   名：</td>
      <td> 
        <input type="text" name="userName" class="input" style="width:200px" />
        <font style='color:red'>*</font> <div style="padding-top:3px;color:#666"></div> </td>
    </tr>


	<tr> 
      <td width="80" align="right">QQ：</td>
      <td> 
        <input type="text" name="selfId" class="input" style="width:200px" />
        <font style='color:red'>*</font> <div style="padding-top:3px;color:#666"></div>  </td>
    </tr>

	<tr> 
      <td width="80" align="right">电   话：</td>
      <td> 
       <input type="text" name="phoneNo" class="input" style="width:200px" />
        <font style='color:red'>*</font> <div style="padding-top:3px;color:#666"></div> </td>
    </tr>
	<tr> 
      <td width="80" align="right"></td>
      <td>
	  </td>
    </tr>
    <tr> 
      <td width="80" align="right">&nbsp;</td>
      <td height="30">
        <input type="submit" name="ccc" value="提交" class="submit">
    		<input type="hidden" name="roleId" value="0" class="input" style="width:200px" />
        <input type="hidden" value="1" name="control">
	  </td>
    </tr>
  </table>
</form>


</div>
</div>

</div>
</div>

<!-- 职位信息详情 -->


<!-- 当前位置提示条 -->

<div id='pdv_3365' class='pdv_class'  title='当前位置' style='width:717px;height:38px;top:0px;left:183px; z-index:9'>
<div id='spdv_3365' class='pdv_content' style='overflow:hidden;width:100%;height:100%'>
<div class="pdv_border" style="border:0px;background:url(image/image/foreground/top-2.png) 0px 0px no-repeat;margin:0px;height:35px">
<div style="float:right;width:10px;height:35px;background:url(image/image/foreground/top-2.png) -890px 0px no-repeat">
</div>
<div style="margin:0px;padding:8px">
 


</div>
</div>

</div>
</div>
</div>
<div id='bottom' style='width:900px;height:208px;background:none transparent scroll repeat 0% 0%'>


<!-- 底部信息编辑区 -->

<div id='pdv_3839' class='pdv_class'  title='脚注信息' style='width:900px;height:175px;top:38px;left:0px; z-index:7'>
<div id='spdv_3839' class='pdv_bottom' style='overflow:hidden;width:100%;height:100%'>
<div class="pdv_border" style="border:1px #ddd solid;height:100%;padding:0;margin:0;background:#f8f8f8">
<div style="position:relative;height:8px;line-height:8px;border:0px;padding:0;margin:-1px -1px 0px -1px;background:url(image/image/foreground/top.png) 0px 0px no-repeat;">
	<div style="float:left;width:8px;height:8px;line-height:8px;background:url(image/image/foreground/top.png) 0px 0px no-repeat">
	</div>
	<div style="float:right;width:8px;height:8px;line-height:8px;background:url(image/image/foreground/top.png) -892px 0px no-repeat">
	</div>
	
</div>

<div style="margin:0px 7px 0px 7px;padding:15px">
<div style="width:100%;text-align:center;font:12px/20px Arial, Helvetica, sans-serif">
<div style="LINE-HEIGHT: 22px">Copyright ? 2018&nbsp;All Rights Reserved. 共享型汽车租赁系统 版权所有&nbsp;&nbsp;&nbsp;<a class=icp href="http://www.miibeian.gov.cn/" target=_blank><font color=#648675>沪ICP备01234567号</font></a><br />服务时间：<span class=red><strong><font color=#ff0000>周一至周日 08:30 — 20:00</font></strong></span>&nbsp; 全国订购及服务热线：<span class=red><strong><font color=#ff0000>021-98765432</font></strong></span>&nbsp; <br />联系地址：上海市某某路某大厦20楼B座2008室&nbsp;&nbsp;&nbsp;邮政编码：210000&nbsp;&nbsp;<br /><br /><img alt="" src="image/image/foreground/200910221256198928725.gif" border=0 />&nbsp;<img alt="" src="image/image/foreground/200910221256198943820.gif" border=0 />&nbsp;<img alt="" src="image/image/foreground/200910221256198954080.gif" border=0 /></div><!# footer end -->
</div>

</div>
</div>
<div style="margin-top:-9px;height:9px;line-height:9px;background:url(image/image/foreground/top.png) 0px -98px no-repeat">&nbsp;</div>
<div style="float:right;margin-top:-9px;width:10px;height:9px;line-height:9px;background:url(image/image/foreground/top.png) -890px -98px no-repeat">&nbsp;</div>

</div>
</div>

<!-- 底部菜单（一级） -->

<div id='pdv_3792' class='pdv_class'   style='width:900px;height:38px;top:0px;left:0px; z-index:10'>
<div id='spdv_3792' class='pdv_bottom' style='overflow:hidden;width:100%;height:100%'>
<div class="pdv_border" style="border:0px;background:url(image/image/foreground/top-2.png) 0px 0px no-repeat;margin:0px;height:35px">
<div style="float:right;width:10px;height:35px;background:url(image/image/foreground/top-2.png) -890px 0px no-repeat">
</div>
<div style="margin:0px;padding:3px">


<div id="bottommenu">


 
</div>


</div>
</div>

</div>
</div>
</div>
</div><div id='bodyex'>

</div>

</body>
<script type="text/javascript">
function check(){
	var account = $("#account").val();
	var password = $("#password").val();
	if(account==null||account==''){
		alert("请输入用户名!");
		return false;
	}
	if(password==null||password==''){
		alert("请输入密码!");
		return false;
	}
	return true;
}
</script>
<!-- awwwb.com -->
</html>