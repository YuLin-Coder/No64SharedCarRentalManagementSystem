/**
 * Created by Administrator on 2016/6/18 0018.
 */
$(function(){
    $(".imglist2 li").click(function () {


        $(".imglist2 li.selected").removeClass("selected")
        $(this).addClass("selected");

        //console.log($(this).offset().left)
        //console.log($(this).offset().top)

        //异常所有遮罩
        $(".loadMask").hide();

        var loadMask = $("<div class='loadMask'></div>");

        loadMask.css({
            "position":"absolute",
            "zIndex": "1000",
            "top": $(this).offset().top+"px",
            "left": $(this).offset().left+"px",
            "height":"169px",
            "width":"169px",
            "background": "#000",
            "opacity":"0.8",
            "font-size":"16px",
            "text-align":"center",
            "color":"#FFF",
            "margin": "15px",
            "border-radius": "50%"
        });

        var p = $("<p class='p1'></p>")
        p.css({
            "height":"169px",
            "line-height":"169px"

        });



        p.html("已选中");

        //判断是否添加过选中模版
        if( $(".loadMask").length===0){
            loadMask.append(p);
            $("body").append(loadMask);
        }else{
            $(".loadMask").css({
                "top": $(this).offset().top+"px",
                "left": $(this).offset().left+"px"
            });
            $(".loadMask").show();
        }

    })
});//绑定点击事件完成遮罩