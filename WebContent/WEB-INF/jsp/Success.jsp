<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
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
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <base href="<%=basepath%>">
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <link href="css/css/background/css/style.css" rel="stylesheet"
          type="text/css" />
    <script type="text/javascript" src="js/js/background/js/jquery.js"></script>
    <title>Insert title here</title>
    <script language="javascript">
        $(function(){
            $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
            $(window).resize(function(){
                $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
            })
        });
    </script>


</head>


<body style="background: #edf6fa;">

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">修改成功</a></li>
    </ul>
</div>

<div class="success">
    <h2>修改成功！</h2>
    <div class="reindex">
        <a href="javascript:;" onclick="request()" target="_parent">返回首页</a>
    </div>
</div>



</body>
<script type="text/javascript">
    function request(){
        var index = parent.layer.getFrameIndex(Window.name);
        parent.layer.iframeAuto(index);
        window.parent.location.reload();
    }
</script>
</html>
