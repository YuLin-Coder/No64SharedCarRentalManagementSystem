

//读取详情翻页
(function($){
	$.fn.contentPages = function(shopid){
	
	$("div#contentpages").empty();
		
		$.ajax({
			type: "POST",
			url:PDV_RP+"shop/post.php",
			data: "act=contentpages&shopid="+shopid,
			success: function(msg){
				$("div#contentpages").append("<ul>");
				$("div#contentpages").append("<li id='pl' class='cbutton'>上一张</li>");
				$("div#contentpages").append(msg);
				$("div#contentpages").append("<li id='pn' class='pbutton'>下一张</li>");
				$("div#contentpages").append("</ul>");
				
				
				var getObj = $('li.pages');

				if(getObj.length<2){
					$("div#contentpages").hide();
					$().setBg();
					return false;
				}

				
				$('li.pages')[0].className='pagesnow';
				
				getObj.each(function(id) {
					
					var obj = this.id;
					
					$("li#"+obj).click(function() {
						
						$('li.pagesnow')[0].className="pages";
						this.className='pagesnow';
						var clickid=obj.substr(2);
						$().getContent(shopid,clickid);
						if($(".pagesnow").next()[0].id=="pn"){$("li#pn")[0].className="cbutton";}else{$("li#pn")[0].className="pbutton";}
						if($(".pagesnow").prev()[0].id=="pl"){$("li#pl")[0].className="cbutton";}else{$("li#pl")[0].className="pbutton";}
						
					});

				});

				
				//上一页
				$("li#pl").click(function() {
					if($("li#pl")[0].className=="pbutton"){
						var nowObj=$(".pagesnow").prev()[0].id;
						var nextpageid=nowObj.substr(2);
						$().getContent(shopid,nextpageid);
						$('li.pagesnow')[0].className="pages";
						$("#"+nowObj)[0].className="pagesnow";
						if($(".pagesnow").prev()[0].id=="pl"){$("li#pl")[0].className="cbutton";}else{$("li#pl")[0].className="pbutton";}
						if($(".pagesnow").next()[0].id=="pn"){$("li#pn")[0].className="cbutton";}else{$("li#pn")[0].className="pbutton";}
					}else{
						return false;
					}
					
					
				});

				
				//下一页
				$("li#pn").click(function() {
					if($("li#pn")[0].className=="pbutton"){
						var nowObj=$(".pagesnow").next()[0].id;
						var nextpageid=nowObj.substr(2);
						$().getContent(shopid,nextpageid);
						$('li.pagesnow')[0].className="pages";
						$("#"+nowObj)[0].className="pagesnow";
						if($(".pagesnow").prev()[0].id=="pl"){$("li#pl")[0].className="cbutton";}else{$("li#pl")[0].className="pbutton";}
						if($(".pagesnow").next()[0].id=="pn"){$("li#pn")[0].className="cbutton";}else{$("li#pn")[0].className="pbutton";}
					}else{
						return false;
					}
				});

			}
		});
	};
})(jQuery);



//读取图片

(function($){
	$.fn.getContent = function(shopid,shoppageid){

		$("#shoploading").show();
		$("img#shoppic").remove();
		
		$.ajax({
			type: "POST",
			url:PDV_RP+"shop/post.php",
			data: "act=getcontent&shoppageid="+shoppageid+"&shopid="+shopid+"&RP="+PDV_RP,
			success: function(msg){
				
				  $("body").append("<img id='shoppic' class='shoppic' src='"+PDV_RP+msg+"'>");
				   
				  $("img#shoppic").load(function(){
					  var outw=parseInt($("div.piczone").css("width"));
					  var outh=parseInt($("div.piczone").css("height"));

					  var w=$("img#shoppic")[0].offsetWidth;
					  var h=$("img#shoppic")[0].offsetHeight;

					  if(w>=h){
						if(w>outw){$("img#shoppic")[0].style.width=outw+"px";}
					  }else{
						if(h>outh){$("img#shoppic")[0].style.height=outh+"px";}
					  }
					  
					  
						$("#shoploading").hide();
						$("img#shoppic").appendTo($("#shopview"));
					    $().setBg();
				  });

				  $("img#shoppic").click(function(){
						
						
						$("body").append("<img id='pre' src='"+$("img#shoppic")[0].src+"'>");
						
						$.blockUI({  
							message: "<img  src='"+$("img#shoppic")[0].src+"' class='closeit'>",  
							css: {  
								top:  ($(window).height() - $("#pre")[0].offsetHeight) /2 + 'px', 
								left: ($(window).width() - $("#pre")[0].offsetWidth/2) /2 + 'px', 
								width: $("#pre")[0].offsetWidth + 'px',
								backgroundColor: '#fff',
								borderWidth:'3px',
								borderColor:'#fff'
							}  
						}); 
						$("#pre").remove();
						
						$(".closeit").click(function(){
							$.unblockUI(); 
						}); 

					
				});
				 
				
			}
		});
	};
})(jQuery);


//详情页加入购物车
$(document).ready(function(){

	$("#buynums").change(function(){
		if($(this)[0].value=="" || parseInt($(this)[0].value)<1 || isNaN($(this)[0].value) || Math.ceil($(this)[0].value)!=parseInt($(this)[0].value)){
			$(this)[0].value="1";
		}
	});

	$("#addtocart").click(function(){
		var gid=$("#gid")[0].value;
		var nums=$("#buynums")[0].value;
		
		//检查库存

		$.ajax({
			type: "POST",
			url:PDV_RP+"shop/post.php",
			data: "act=chkkucun&gid="+gid+"&nums="+nums,
			success: function(msg){
				if(msg=="OK"){

					$.ajax({
						type: "POST",
						url:PDV_RP+"post.php",
						data: "act=setcookie&cookietype=add&cookiename=SHOPCART&gid="+gid+"&nums="+nums+"&fz=",
						success: function(msg){
							if(msg=="OK"){
								window.location=PDV_RP+'shop/cart.php';
							}else if(msg=="1000"){
								alert("订购数量错误");
							}else{
								alert(msg);
								
							}
						}
					});

				}else if(msg=="1000"){
					alert("该商品缺货");
				}else{
					alert(msg);
					
				}
			}
		});
	});

});


//初始化获取翻页和图片
$(document).ready(function(){
	var shopid=$("input#shopid")[0].value;
	$().contentPages(shopid);
	$().getContent(shopid,0);
});

//切换介绍和参数
$(document).ready(function(){
	$("#switch_body").click(function(){
		$("#switch_body")[0].className="bodyzone_cap_now";
		$("#switch_canshu")[0].className="bodyzone_cap_list";
		$("#bodyzone").show();
		$("#canshuzone").hide();
		$().setBg();
	});
	$("#switch_canshu").click(function(){
		$("#switch_body")[0].className="bodyzone_cap_list";
		$("#switch_canshu")[0].className="bodyzone_cap_now";
		$("#bodyzone").hide();
		$("#canshuzone").show();
		$().setBg();
	});
});



//支持反对投票
$(document).ready(function(){

	$("span#zhichi").click(function(){
		
		var shopid=$("input#shopid")[0].value;

		$.ajax({
			type: "POST",
			url:PDV_RP+"shop/post.php",
			data: "act=zhichi&shopid="+shopid,
			success: function(msg){
				if(msg=="L0"){
					$().popLogin(0);
				}else if(msg=="L1"){
					$().alertwindow("对不起，您已经投过票了","");
				}else{
					$("span#zhichinum").html(msg);
				}
			}
		});
	});


	$("span#fandui").click(function(){
		
		var shopid=$("input#shopid")[0].value;

		$.ajax({
			type: "POST",
			url:PDV_RP+"shop/post.php",
			data: "act=fandui&shopid="+shopid,
			success: function(msg){
				if(msg=="L0"){
					$().popLogin(0);
				}else if(msg=="L1"){
					$().alertwindow("对不起，您已经投过票了","");
				}else{
					$("span#fanduinum").html(msg);
				}
			}
		});
	});
		
});


//加入收藏
$(document).ready(function(){

	$("span#addfav").click(function(){
		
		var shopid=$("input#shopid")[0].value;

		$.ajax({
			type: "POST",
			url:PDV_RP+"shop/post.php",
			data: "act=addfav&shopid="+shopid+"&url="+window.location.href,
			success: function(msg){
				if(msg=="L0"){
					$().popLogin(0);
				}else if(msg=="L1"){
					$().alertwindow("您已经收藏了当前网址","");
				}else if(msg=="OK"){
					$().alertwindow("已经加入到收藏夹",PDV_RP+"member/member_fav.php");
				}else{
					alert(msg);
				}
			}
		});
	});

	$("img#addtofav").click(function(){
		
		var shopid=$("input#shopid")[0].value;

		$.ajax({
			type: "POST",
			url:PDV_RP+"shop/post.php",
			data: "act=addfav&shopid="+shopid+"&url="+window.location.href,
			success: function(msg){
				if(msg=="L0"){
					$().popLogin(0);
				}else if(msg=="L1"){
					$().alertwindow("您已经收藏了当前网址","");
				}else if(msg=="OK"){
					$().alertwindow("已经加入到收藏夹",PDV_RP+"member/member_fav.php");
				}else{
					alert(msg);
				}
			}
		});
	});
		
});


