/**
 * 使用闭包的形式完成相关操作
 * 1.先完成目的再说
 * 2.由于框架原因,工具类是属于定制版
 *
 * 感觉封装的很烂很烂,还要看基础啊
 */
/*1.通过IIFE这种方式我们可以构造块作用域，通常的模式为：*/
var frameset_layer = function(){
    //定义举报变量
    var toplayer = top.layer;
    //设置默认值
    var settings= {
        /**扩展属性*/
        isCallBack : true,/**开关设置: 是否开启关闭页面后的其他操作*/
        isFull : true,
        method : 'toSub',

        id:'layer'+(new Date().getTime()),
        type : 2,
        title : '共享型汽车租赁系统',
        content:'error.html',
        area: ['600px', '600px'],
        maxmin: false,
        yes: function(index, layero){
            if(this.isCallBack){
                if($.type(this.method)==='string' && $.trim(this.method)!==''){
                    var result = top["layui-layer-iframe" + index][this.method]();
                    console.log(result);
                    if (result != false) {
                        //判断返回的资源类型
                        if($.type(result)==='string'){
                            //解析JSON的字符串
                            var data = JSON.parse(result);
                            if(data.flag==='success' || data.flag==='ok'){
                                toplayer.alert(data.message,{icon: 6,closeBtn: 0},function (index) {
                                    toplayer.closeAll(); //如果设定了yes回调，需进行手工关闭
                                    //刷新页面
                                    window.location.href = window.location.href;
                                });
                            }else{
                                toplayer.alert(data.message,{icon: 2,closeBtn: 0},function (index) {
                                    top.layer.close(index);
                                });
                            }
                        }



                    }
                }


            }

        }
    }
    //options必须为对象
    function getFrameSetOpen(options){
        
        if(typeof(options) !== "undefined"){
            if($.type(options)==="string"){
                settings["content"] = options;
            }else{
                //如果是对象,就进行迭代
                if($.type(options)==="object" && !$.isEmptyObject(options)){
                    //进行迭代
                    $.each(options,function (key,val) {
                        settings[key] = val;
                    });
                }
            }

            if(settings.isFull){
                settings.maxmin = true;
            }

            var index = toplayer.open(settings);

            if(settings.isFull){
                toplayer.full(index);
            }
        }else{
            console.error("options为必选项,可以是访问路径的字符串或者为参数信息");
            return false;
        }
        


    }

    return {
        open : function(options){
            getFrameSetOpen(options);
        }

    };
};

