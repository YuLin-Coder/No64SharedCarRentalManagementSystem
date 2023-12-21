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
<link href="css/css/foreground/shopquery.css" rel="stylesheet" type="text/css" />
<link href="css/css/foreground/shoptwoclass_brand.css" rel="stylesheet" type="text/css" />
<link href="css/css/foreground/style.css" rel="stylesheet" type="text/css" />
<link href="css/css/foreground/shopclass.css" rel="stylesheet" type="text/css" />
<link href="css/css/foreground/f.css" rel="stylesheet" type="text/css" />
<script type=text/javascript src="js/js/foreground/shopclass_brand.js"></script>
<script type=text/javascript src="js/js/foreground/cart.js"></script>
<script type="text/javascript" src="js/js/foreground/channelmenu_1030.js"></script>
<script type="text/javascript" src="js/js/foreground/base.js"></script>
<script type="text/javascript" src="js/js/foreground/common.js"></script>
<script type="text/javascript" src="js/js/foreground/form.js"></script>
<script type="text/javascript" src="js/js/foreground/blockui.js"></script>
<script type=text/javascript src="js/js/foreground/jquery.min.js"></script>
<title>共享型汽车租赁系统</title>
</head>
<body style='background:#ffffff'>
<script>
var PDV_PAGEID='301'; 
var PDV_RP='index.html'; 
var PDV_COLTYPE='shop'; 
var PDV_PAGENAME='query'; 
</script>

<div id='contain' style='width:900px;background:#ffffff;margin:0px auto;padding:10px'>

<div id='top' style='width:900px;height:133px;background:none transparent scroll repeat 0% 0%'>


<!-- 二级导航菜单 -->

<div id='pdv_3496' class='pdv_class'   style='width:900px;height:71px;top:60px;left:0px; z-index:1'>
<div id='spdv_3496' class='pdv_top' style='overflow:hidden;width:100%;height:100%'>
<div class="pdv_border" style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
	<div style="height:25px;margin:1px;display:none;background:;">
		<div style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">
		导航菜单
		</div>
		<div style="float:right;margin-right:10px;display:none">
		<a href="-2.html" style="line-height:25px;color:">更多</a>
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
</c:if></div>
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

<!-- 商品搜索表单 -->


<!-- 网站标志 -->

<div id='pdv_3593' class='pdv_class'  title='网站标志' style='width:180px;height:70px;top:5px;left:6px; z-index:4'>
<div id='spdv_3593' class='pdv_top' style='overflow:hidden;width:100%;height:100%'>
<div class="pdv_border" style="margin:0;padding:0;height:100%;border:0px #dddddd solid;background:#fff;">
	<div style="height:25px;margin:1px;display:none;background:#cccccc;">
		<div style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:#fff">
		网站标志
		</div>
		<div style="float:right;margin-right:10px;display:none">
		<a href="-2.html" style="line-height:25px;color:#fff">更多</a>
		</div>
	</div>
<div style="padding:0px">


<h2>共享型汽车租赁系统</h2>


</div>
</div>

</div>
</div>

<!-- 购物车提示信息 -->

<div id='pdv_3716' class='pdv_class'  title='购物车' style='width:452px;height:27px;top:10px;left:448px; z-index:5'>
<div id='spdv_3716' class='pdv_top' style='overflow:hidden;width:100%;height:100%'>
<div class="pdv_border" style="margin:0;padding:0;height:100%;border:0px  solid;background:;">
	<div style="height:25px;margin:1px;display:none;background:;">
		<div style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">
		购物车
		</div>
		<div style="float:right;margin-right:10px;display:none">
		<a href="-2.html" style="line-height:25px;color:">更多</a>
		</div>
	</div>
<div style="padding:0px">




</div>
</div>

</div>
</div>
</div>
<div id='content' style='width:900px;height:1019px;background:none transparent scroll repeat 0% 0%;margin:10px auto'>


<!-- 商品检索搜索 -->

<div id='pdv_3613' class='pdv_class'  title='' style='width:701px;height:500px;left:199px; z-index:3'>
<div id='spdv_3613' class='pdv_content' style='overflow:visible;width:100%;'>
<div class="pdv_border" style="margin:0;padding:0;height:100%;border:0px  solid;background:#fff;">
	<div style="height:25px;margin:1px;display:none;background:;">
		<div style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">
		
		</div>
		<div style="float:right;margin-right:10px;display:none">
		<a href="-2.html" style="line-height:25px;color:">更多</a>
		</div>
	</div>
<div style="padding:0px">

<form action="car/informationLoadFore" method="post">
汽车搜索:<input type="text" name="searchName" value="${car['searchName'] }">
<input type="submit" value="查询">
</form>
<div class="shopquery_cap">
	<div class="shopquery_cap_left"></div>
	<div class="shopquery_cap_right"></div>
	<div class="shopquery_paixu">
	<form id="shopquerysxform" method="get" action="http://demo.vhostgo.com/1030/shop/class/index.php">
	
	 <input name="catid" type="hidden"  value="92">
	 <input name="showbrandid" type="hidden" value="">
	 <input id="showmethod" name="showmethod" type="hidden" value="cc">
	 <input name="pricefrom" type="hidden" value="">
	 <input name="priceto" type="hidden" value="">
	 <input name="key" type="hidden" value="">
	 
	 <script>
	$(function() {
	 	$("#shopquery_paixu").attr("value","uptime");
	 	$("#shopquery_shownums").attr("value","9");
		$("#showquery_showmethod_cc")[0].className="showquery_showmethod_cc";
		$("#showquery_showmethod_lb")[0].className="showquery_showmethod_lb";
		$("#showquery_showmethod_tu")[0].className="showquery_showmethod_tu";
		$("#showquery_showmethod_cc")[0].className="showquery_showmethod_cc_now";
		$("#showquery_showmethod_cc").click(function(){
			$("input#showmethod")[0].value="cc";
			$("#shopquerysxform").submit();
		});
		$("#showquery_showmethod_lb").click(function(){
			$("input#showmethod")[0].value="lb";
			$("#shopquerysxform").submit();
		});
		$("#showquery_showmethod_tu").click(function(){
			$("input#showmethod")[0].value="tu";
			$("#shopquerysxform").submit();
		});
	 
	});
	</script>
	</form>
	</div>
	
</div>
<div class="shopquery_out">
<c:forEach items="${pager.datas }" var="car" varStatus="vs">
<div class="shopquery">
		<div class="fang" style="width:120px;height:120px">
			<div class="picFit" style="width:120px;height:120px">
			<a href="car/informationLoadOneFore?id=${car['id'] }" target="_self" ><img src="upload/upload/${car['url'] }" style="width:120px;height:120px" border="0" /></a>
			</div>
		</div>
		<div class="prop">
		价格：<span class="hb">￥</span><span class="price">${car['price'] }</span><br />
		</div>
		<a href="car/informationLoadOneFore?id=${car['id'] }" target="_self" class="prodtitle"   >${car['name'] }</a>
		<div class="memo" >
		${car['name'] }
		</div>
</div>
</c:forEach>
</div>
<script>
$(function() {
$().picFit("fill");
});
</script>
<br clear="all" />
<br />
<div id="showpages" >
	  <div id="pagesinfo">共${pager.totalCount }条 每页9条 页次：${pager.pageNow}/${pager.totalPages }</div>
	  <div id="pages"><ul><li class="pbutton">
	  <c:if test="${pager.pageNow le 1 }" var="pagele">
	  <a href="car/informationLoadFore?pageNow=${pager.pageNow }&searchName=${car['searchName']}">上一页</a>
	  </c:if>
	   <c:if test="${!pagele}">
	  <a href="car/informationLoadFore?pageNow=${pager.pageNow -1}&searchName=${car['searchName']}">上一页</a>
	  </c:if>
	  </li>
	  <li class="pbutton">
	  <c:if test="${pager.pageNow ge pager.totalPages }" var="pagege">
	  <a href="car/informationLoadFore?pageNow=${pager.pageNow }&searchName=${car['searchName']}">
	  下一页
	  </a>
	  </c:if>
	  <c:if test="${!pagege }">
	  <a href="car/informationLoadFore?pageNow=${pager.pageNow+1 }&searchName=${car['searchName']}">
	  下一页
	  </a>
	  </c:if>
	  </li></ul></div>
 </div>


</div>
</div>

</div>
</div>

<!-- 分类品牌组合查询 -->

<div id='pdv_3611' class='pdv_class'  title='' style='width:180px;height:400px;top:0px;left:0px; z-index:7'>
<div id='spdv_3611' class='pdv_content' style='overflow:visible;width:100%;'>
<div class="pdv_border" style="margin:0;padding:0;height:100%;border:0px  solid;background:#fff;">
	<div style="height:25px;margin:1px;display:none;background:;">
		<div style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:">
		
		</div>
		<div style="float:right;margin-right:10px;display:none">
		<a href="-1.html" style="line-height:25px;color:">更多</a>
		</div>
	</div>
<div style="padding:0px">


<div class="shoptwoclass">

<div id="shopclasstop_1" class="shoptwoclass_top">
<div id="shopclasscap_1" class="shoptwoclass_topright"></div>
<a href="index45e7.html?1.html" target="_self" >用户</a></div>
<c:if test="${sessionScope['User'] eq null or sessionScope['User'] eq '' }" var="login">
<form action="user/loginF" method="post" onsubmit="return check();" id="login">
<ul id="shopclasssub_1" style="height: 40px;">

<li>用户:<input type="text" name="loginName" id="account" style="width: 120px;"></li>

<li>密码:<input type="password" name="loginPassword" id="password" style="width: 120px; margin-top: 5px;"></li>


<li><input type="submit" value="登录" style="margin-top: 5px;"><a href="request/sign">注册</a><font color="red">${messageLogin }</font></li>

</ul>
</form>
</c:if>
<c:if test="${!login }">
<ul id="shopclasssub_1" style="height: 40px;">

<li><c:out value="${sessionScope['User']['userName'] },您好"></c:out></li>

<li><a href="javascript:;" onclick="return logout();" style="color: blue;">退出</a></li>


</ul>
</c:if>
<div id="shopclasstop_2" class="shoptwoclass_top">
<div id="shopclasscap_2" class="shoptwoclass_topright"></div>
<a href="index0b5f.html?2.html" target="_self" >欢迎</a></div>
<ul id="shopclasssub_2">

<li>欢迎来到共享型汽车租赁系统</li>

</ul>

 
<br clear="all" />
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
		var account = $("#account").val()
		var password = $("#password").val()
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
	function logout(){
		if(window.confirm("您确定要退出吗?")){
			window.location.href="user/logoutF";
			return true;
		}
		return false;
	}
	}
</script>
<!-- awwwb.com -->
</html>