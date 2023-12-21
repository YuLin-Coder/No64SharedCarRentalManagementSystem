/**
 * 主要控制后台框架页面显示
 */
function initInner(){
    //108=头部占用的像素88+20底部占用的像素
    var minHeight = ($(window).height()-108)+"px";
    //设置最小的样式
    $(".inner").css("min-height",minHeight);
}
function initIframe(){
    var iframeHeight = $(".mainIframe").contents().find("html").height();
    var iframeWidth = $(".mainIframe").contents().find("html").width();

    var innerHeight
    if($(".inner").scrollLeft()>0){
        innerHeight = $(".inner").innerHeight();
    }else{
        innerHeight = $(".inner").innerHeight()-5;
    }


    var innerWidth ;
    if($("body").scrollTop()>0){
        innerWidth = $(document).innerWidth()-205;
    }else{
        innerWidth = $(document).innerWidth()-188;
    }

    if(iframeHeight<innerHeight){
        $(".mainIframe").height(innerHeight);
    }else{
        $(".mainIframe").height(iframeHeight);
    }

    if(iframeWidth<innerWidth){
        $(".mainIframe").width(innerWidth);
    }else{
        $(".mainIframe").width(iframeWidth);
    }


}
/**框架容器控制*/
$(function () {
    //顶部导航切换点击事件绑定
    $(".nav li a").click(function () {
        //1.移除 selected 样式
        $(".nav li a.selected").removeClass("selected")
        //2.当天元素 selected 选中样式
        $(this).addClass("selected");
    });
    //初始化容器的最小高度
    initInner();
    //监听串口改变事件
    $(window).resize(function(){
        //这里应该对大小进行控制
        initInner();
        initIframe();
    });

});

/**控制导航方面*/
$(function(){
    //导航切换
    $(".menuson li").click(function(){
        $(".menuson li.active").removeClass("active")
        $(this).addClass("active");
    });

    $('.title').click(function(){
        var $ul = $(this).next('ul');
        $('dd').find('.menuson').slideUp();
        if($ul.is(':visible')){
            $(this).next('.menuson').slideUp();
        }else{
            $(this).next('.menuson').slideDown();
        }
    });
});

