
$(document).ready(function(){


	
	$("div.shoptwoclass_topright").toggle(function(){
		var topcatid=this.id.substr(13);
		$("ul#shopclasssub_"+topcatid).hide();
		$(this)[0].className="shoptwoclass_topright_open";
		$().setBg();
	},function(){
		var topcatid=this.id.substr(13);
		$("ul#shopclasssub_"+topcatid).show();
		$(this)[0].className="shoptwoclass_topright";
		$().setBg();
	});
	

	$("#shoptwoclass_brand_cat").mouseover(function(){
		$(".shoptwoclass").show();
		$(".shoptwoclass_brand").hide();
		$("#shoptwoclass_brand_cat")[0].className="shoptwoclass_brand_cat";
		$("#shoptwoclass_brand_brand")[0].className="shoptwoclass_brand_brand";
		$().setBg();
	});

	$("#shoptwoclass_brand_brand").mouseover(function(){
		$(".shoptwoclass").hide();
		$(".shoptwoclass_brand").show();
		$("#shoptwoclass_brand_cat")[0].className="shoptwoclass_brand_cat_on";
		$("#shoptwoclass_brand_brand")[0].className="shoptwoclass_brand_brand_on";
		$().setBg();
	});

});


