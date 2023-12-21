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
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basepath%>">
<meta charset="UTF-8">
<link href="css/css/background/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="js/js/background/js/laydate/need/laydate.css"
	rel="stylesheet" type="text/css" />
<link href="css/css/background/css/select.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="js/js/background/js/jquery.js"></script>
<script type="text/javascript" src="js/js/background/layer/layer.js"></script>
<script type="text/javascript"
	src="js/js/background/commons/hp_layer_helper-v0.1.js"></script>
<script type="text/javascript"
	src="js/js/background/js/laydate/laydate.js"></script>
<script type="text/javascript"
	src="js/js/background/js/jquery.idTabs.min.js"></script>
<script type="text/javascript"
	src="js/js/background/js/select-ui.min.js"></script>
<script type="text/javascript">
        $(function(){
        	$("#add").click(function () {
                frameset_layer().open("request/functionAdd");
            });

            
	        })
	        function update(id){
	            	frameset_layer().open("function/queryOne?id="+id);
	        }
        function deleteAll(power){
    		var check = document.getElementsByName("subBox");
    		var len=check.length;
    		var idAll="";
    		var list=new Array();
    		for(var i=0;i<len;i++){
    		if(check[i].checked){
    			idAll+=check[i].value+",";
    			}
    		}
    		if(idAll==''){
    			return false;
    		}
    		if(window.confirm("您确定删除这些数据吗?")){
    			window.location.href="active/informationDeleteAll?idAll="+idAll;
    		}
    		}
        </script>
<script type="text/javascript">
			$(document).ready(function(e) {
			
				$(".select3").uedSelect({
					width : 152
				});
			});
		</script>
</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="javascript:void(0);">首页</a></li>
			<li><a href="javascript:void(0);">基本操作</a></li>
		</ul>
	</div>
	<form action="active/informationLoad" method="POST"
		onsubmit="return check();">

		<div class="rightinfo">
			${messageadd }

			<div class="tools">
				<ul class="toolbar">
					<li class="click" id="add1"><span><img
							src="image/image/background/images/t01.png" /></span><a
						href="javascript:;" id="add">新建</a></li>

					<li class="click"><font color="#0099cc">总数量(<b>${pager.totalCount}</b>)
					</font></li>

				</ul>
		</div>

			<table class="tablelist">
				<thead>
					<tr>
						<th>标题</th>
						<th>名称</th>
						<th>地址</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${message ne null }" var="null">
						<tr>
							<td colspan="7" align="center">${message }</td>
						</tr>
					</c:if>
					<c:forEach items="${pager.datas }" var="function" varStatus="vg">
						<tr>
							<td><c:out value="${function['title'] }"></c:out></td>
							<td><c:out value="${function['name'] }"></c:out></td>
							<td><c:out value="${function['url'] }"></c:out></td>
							<td><a href="javascript:;" onclick="update(${function['id']})"
								class="tablelink">查看</a> <a href="javascript:;"
								onclick="deletecheck(${function['id']})"
								class="tablelink"> 删除</a></td>
						</tr>
					</c:forEach>


				</tbody>
			</table>
			<div class="pagin">
				<div class="message">
					共<i class="blue">${pager.totalCount}</i>条记录， 当前显示第&nbsp;<input
						type="text" value="${pager.pageNow }" name="pageNow" id="pageNow"
						class="scinput2" onkeyup="limitInput(this);" width="10px">&nbsp;&nbsp;页
					/ ${pager.totalPages }页 <a href="javascript:;"
						onclick="$('#cx1').click()"><i class="blue">跳转</i></a> <input
						type="hidden" id="totalPages" value="${pager.totalPages }">
				</div>
				<ul class="paginList">
					<li class="paginItem"><c:if test="${pager.pageNow le 1 }"
							var="pagele">
							<a
								href="function/queryAll?pageNow=${pager.pageNow }">
								<span class="pagepre"></span>
							</a>
						</c:if> <c:if test="${!pagele }" var="pagele">
							<a
								href="function/queryAll?pageNow=${pager.pageNow-1 }">
								<span class="pagepre"></span>
							</a>
						</c:if></li>

					<c:if test="${pager.totalPages lt 10}">
						<c:forEach var="count" begin="1" end="${pager.totalPages }"
							varStatus="vs">
							<c:if test="${vs.count eq pager.pageNow }" var="current">
								<li class="paginItem current"><a
								href="function/queryAll?pageNow=${vs.count }">${vs.count}</a></li>
							</c:if>
							<c:if test="${!current }">
								<li class="paginItem"><a
								href="function/queryAll?pageNow=${vs.count }">${vs.count}</a></li>
							</c:if>
						</c:forEach>
					</c:if>
					<c:if test="${pager.totalPages gt 10 }">
						<c:if
							test="${pager.pageNow gt pager.totalPages-4 and pager.pageNow le pager.totalPages }">
							<c:forEach var="count" begin="${pager.totalPages-9}"
								end="${pager.totalPages }" varStatus="vs1">
								<c:if test="${count eq pager.pageNow }" var="current">
									<li class="paginItem current"><a
									href="function/queryAll?pageNow=${count }">${count}</a></li>
								</c:if>
								<c:if test="${!current }">
									<li class="paginItem"><a
									href="function/queryAll?pageNow=${count }">${count}</a></li>
								</c:if>
							</c:forEach>
						</c:if>
						<c:if
							test="${pager.pageNow gt 6 and pager.pageNow le pager.totalPages-4 }">
							<c:forEach var="count" begin="${pager.pageNow-5 }"
								end="${pager.pageNow+4 }" varStatus="vs2">
								<c:if test="${count eq pager.pageNow }" var="current">
									<li class="paginItem current"><a
									href="function/queryAll?pageNow=${count }">${count}</a></li>
								</c:if>
								<c:if test="${!current }">
									<li class="paginItem"><a
									href="function/queryAll?pageNow=${count }">${count}</a></li>
								</c:if>
							</c:forEach>
						</c:if>
						<c:if test="${pager.pageNow ge 1 and pager.pageNow le 6 }">
							<c:forEach var="count" begin="1" end="10" varStatus="vs3">
								<c:if test="${count eq pager.pageNow }" var="current">
									<li class="paginItem current"><a
									href="function/queryAll?pageNow=${count }">${count}</a></li>
								</c:if>
								<c:if test="${!current }">
									<li class="paginItem"><a
									href="function/queryAll?pageNow=${count }">${count}</a></li>
								</c:if>
							</c:forEach>
						</c:if>
					</c:if>
					<li class="paginItem"><c:if
							test="${pager.pageNow ge pager.totalPages }" var="pagege">
							<a
									href="function/queryAll?pageNow=${pager.pageNow }">
								<span class="pagenxt"></span>
							</a>
						</c:if> <c:if test="${!pagege }">
							<a
									href="function/queryAll?pageNow=${pager.pageNow+1 }">
								<span class="pagenxt"></span>
							</a>
						</c:if></li>
				</ul>
			</div>

		</div>
	</form>
	<script type="text/javascript">
        $('.tablelist tbody tr:odd').addClass('odd');
        function deletecheck(id){
        	$(function(){
                if(window.confirm("您确定删除该条数据吗?")){
        			window.location.href="function/functionDelete?id="+id;
        		}
        	})
        }
        $(function() {
            $("#checkAll").click(function() {
                 $('input[name="subBox"]').attr("checked",this.checked); 
             });
             var $subBox = $("input[name='subBox']");
             $subBox.click(function(){
                 $("#checkAll").attr("checked",$subBox.length == $("input[name='subBox']:checked").length ? true : false);
             });
         });
        
        function deletes(){
        	
        }
    </script>
	<script type="text/javascript">
		$(document).ready(function(){
		  $("#scbtn1").click(function(){
		  $(".seachform2").fadeIn(200);
		  }); 
		
		
		});
		
		$(document).ready(function() 
				{ 
				    $("#scbtn1").click(function() 
				    {      
				        if( $(".seachform2").hasClass("hideclass") ) 
				        { 
				            $(".seachform2").removeClass("hideClass"); 
				        } 
				        else 
				        { 
				            $(".seachform2").addClass("hideClass"); 
				        }    
				    }); 
				}); 
	</script>
	<script>
var start = {
  elem: '#start',
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
var end = {
  elem: '#end',
  format: 'YYYY-MM-DD',
  min: '1900-01-01',
  max: '2099-06-16',
  istime: true,
  istoday: false,
  choose: function(datas){
    start.max = datas; //结束日选好后，重置开始日的最大日期
  }
};
laydate(start);
laydate(end);
</script>
	<script type="text/javascript"> 
    		 var pageNow=$("#pageNow").val();
    	 function limitInput(o){
             var value=o.value;
             var min=1;
             var max=$("#totalPages").val();
             if(parseInt(value)<min||parseInt(value)>max){
                 alert('输入错误');
                 o.value=pageNow;
             }
         }
    	 function check(){
    		 var pageNow=$("#pageNow").val();
    		 var myreg = /^\+?[1-9][0-9]*$/;
    		 if(!$.trim(pageNow)){
    			 alert("请输入页数");
    			 return false;
    		 }
    		 if($("#pageNow").val()!=''&&!myreg.test($("#pageNow").val())){
    			 alert("请输入正确的页码");
    			 return false;
    		 }
    		 return true;
    	 }
    	 $("#cx").click(function(){
 			$("#pageNow").val('1');
 		});
</script>
</body>

</html>