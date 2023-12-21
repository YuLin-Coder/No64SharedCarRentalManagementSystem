
if(!Array.prototype.indexOf){Array.prototype.indexOf=function(obj,fromIndex){if(fromIndex==null){fromIndex=0;}else if(fromIndex<0){fromIndex=Math.max(0,this.length+fromIndex);}
for(var i=fromIndex;i<this.length;i++){if(this[i]===obj)
return i;}
return-1;};}
if(!Array.prototype.lastIndexOf){Array.prototype.lastIndexOf=function(obj,fromIndex){if(fromIndex==null){fromIndex=this.length-1;}else if(fromIndex<0){fromIndex=Math.max(0,this.length+fromIndex);}
for(var i=fromIndex;i>=0;i--){if(this[i]===obj)
return i;}
return-1;};}
if(!Array.prototype.forEach){Array.prototype.forEach=function(f,obj){var l=this.length;for(var i=0;i<l;i++){f.call(obj,this[i],i,this);}};}
if(!Array.prototype.filter){Array.prototype.filter=function(f,obj){var l=this.length;var res=[];for(var i=0;i<l;i++){if(f.call(obj,this[i],i,this)){res.push(this[i]);}}
return res;};}
if(!Array.prototype.map){Array.prototype.map=function(f,obj){var l=this.length;var res=[];for(var i=0;i<l;i++){res.push(f.call(obj,this[i],i,this));}
return res;};}
if(!Array.prototype.some){Array.prototype.some=function(f,obj){var l=this.length;for(var i=0;i<l;i++){if(f.call(obj,this[i],i,this)){return true;}}
return false;};}
if(!Array.prototype.every){Array.prototype.every=function(f,obj){var l=this.length;for(var i=0;i<l;i++){if(!f.call(obj,this[i],i,this)){return false;}}
return true;};}
Array.prototype.contains=function(obj){return this.indexOf(obj)!=-1;};Array.prototype.copy=function(obj){return this.concat();};Array.prototype.insertAt=function(obj,i){this.splice(i,0,obj);};Array.prototype.insertBefore=function(obj,obj2){var i=this.indexOf(obj2);if(i==-1)
this.push(obj);else
this.splice(i,0,obj);};Array.prototype.removeAt=function(i){this.splice(i,1);};Array.prototype.remove=function(obj){var i=this.indexOf(obj);if(i!=-1)
this.splice(i,1);};

TB={};TB.common={getCookie:function(name){var value=document.cookie.match('(?:^|;)\\s*'+name+'=([^;]*)');return value?unescape(value[1]):'';},setCookie:function(name,value,expire,domain,path){value=escape(value);value+=(domain)?'; domain='+domain:'';value+=(path)?"; path="+path:'';if(expire){var date=new Date();date.setTime(date.getTime()+(expire*86400000));value+="; expires="+date.toGMTString();}
document.cookie=name+"="+value;},removeCookie:function(name){setCookie(name,'',-1);},pickDocumentDomain:function(){var da=location.hostname.split('.'),len=da.length;var deep=arguments[0]||(len<3?0:1);if(deep>=len||len-deep<2)
deep=len-2;return da.slice(deep).join('.')+(location.port?':'+location.port:'');},trim:function(str){return str.replace(/(^\s*)|(\s*$)/g,'');},escapeHTML:function(str){var div=document.createElement('div');var text=document.createTextNode(str);div.appendChild(text);return div.innerHTML;},unescapeHTML:function(str){var div=document.createElement('div');div.innerHTML=str.replace(/<\/?[^>]+>/gi,'');return div.childNodes[0]?div.childNodes[0].nodeValue:'';},toArray:function(list,start){var array=[];for(var i=start||0;i<list.length;i++){array[array.length]=list[i];}
return array;},applyConfig:function(obj,config){if(obj&&config&&typeof config=='object'){for(var p in config){if(!YAHOO.lang.hasOwnProperty(obj,p))
obj[p]=config[p];}}
return obj;}};

TB.widget={};TB.widget.SimpleScroll={};TB.widget.SimpleMarquee={};

TB.widget.SimpleTab=new function(){var Y=YAHOO.util;var defConfig={eventType:'click',currentClass:'Current',tabClass:'',autoSwitchToFirst:true,stopEvent:true,delay:0.3};var getImmediateDescendants=function(p){var ret=[];if(!p)return ret;for(var i=0,c=p.childNodes;i<c.length;i++){if(c[i].nodeType==1)
ret[ret.length]=c[i];}
return ret;};this.decorate=function(container,config){container=Y.Dom.get(container);config=TB.common.applyConfig(config||{},defConfig);var tabPanels=getImmediateDescendants(container);var tab=tabPanels.shift(0);var tabTriggerBoxs=tab.getElementsByTagName('li');var tabTriggers,delayTimeId;if(config.tabClass){tabTriggers=Y.Dom.getElementsByClassName(config.tabClass,'*',container);}else{tabTriggers=TB.common.toArray(tab.getElementsByTagName('a'));}
var onSwitchEvent=new Y.CustomEvent("onSwitch",null,false,Y.CustomEvent.FLAT);if(config.onSwitch){onSwitchEvent.subscribe(config.onSwitch);}
var handler={switchTab:function(idx){Y.Dom.setStyle(tabPanels,'display','none');Y.Dom.removeClass(tabTriggerBoxs,config.currentClass);Y.Dom.addClass(tabTriggerBoxs[idx],config.currentClass);Y.Dom.setStyle(tabPanels[idx],'display','block');},subscribeOnSwitch:function(func){onSwitchEvent.subscribe(func);}}
var focusHandler=function(ev){if(delayTimeId)
cacelHandler();var idx=tabTriggers.indexOf(this);handler.switchTab(idx);onSwitchEvent.fire(idx);if(config.stopEvent)
Y.Event.stopEvent(ev);return!config.stopEvent;}
var delayHandler=function(){var target=this;delayTimeId=setTimeout(function(){focusHandler.call(target);},config.delay*1000);if(config.stopEvent)
Y.Event.stopEvent(ev);return!config.stopEvent;}
var cacelHandler=function(){clearTimeout(delayTimeId);}
for(var i=0;i<tabTriggers.length;i++){Y.Event.on(tabTriggers[i],'focus',focusHandler);if(config.eventType=='mouse'){Y.Event.on(tabTriggers[i],'mouseover',config.delay?delayHandler:focusHandler);Y.Event.on(tabTriggers[i],'mouseout',cacelHandler);}
else{Y.Event.on(tabTriggers[i],'click',focusHandler);}}
Y.Dom.setStyle(tabPanels,'display','none');if(config.autoSwitchToFirst)
handler.switchTab(0);return handler;}};

(function(){var Y=YAHOO.util;TB.widget.Slide=function(container,config){this.init(container,config);}
TB.widget.Slide.defConfig={slidesClass:'Slides',triggersClass:'SlideTriggers',currentClass:'Current',eventType:'click',autoPlayTimeout:5,disableAutoPlay:false};TB.widget.Slide.prototype={init:function(container,config){this.container=Y.Dom.get(container);this.config=TB.common.applyConfig(config||{},TB.widget.Slide.defConfig);try{this.slidesUL=Y.Dom.getElementsByClassName(this.config.slidesClass,'ul',this.container)[0];this.slides=this.slidesUL.getElementsByTagName('li');}catch(e){throw new Error("can't find slides!");}
this.delayTimeId=null;this.autoPlayTimeId=null;this.curSlide=-1;this.sliding=false;this.pause=false;this.onSlide=new Y.CustomEvent("onSlide",this,false,Y.CustomEvent.FLAT);if(YAHOO.lang.isFunction(this.config.onSlide)){this.onSlide.subscribe(this.config.onSlide,this,true);}
this.initSlides();this.initTriggers();if(this.slides.length>0)
this.play(1);if(!this.config.disableAutoPlay){this.autoPlay();}},initTriggers:function(){var ul=document.createElement('ul');this.container.appendChild(ul);for(var i=0;i<this.slides.length;i++){var li=document.createElement('li');li.innerHTML=i+1;ul.appendChild(li);}
ul.className=this.config.triggersClass;this.triggersUL=ul;if(this.config.eventType=='mouse'){Y.Event.on(this.triggersUL,'mouseover',this.mouseHandler,this,true);Y.Event.on(this.triggersUL,'mouseout',function(e){clearTimeout(this.delayTimeId);},this,true);}else{Y.Event.on(this.triggersUL,'click',this.clickHandler,this,true);}},initSlides:function(){Y.Event.on(this.slides,'mouseover',function(){this.pause=true;},this,true);Y.Event.on(this.slides,'mouseout',function(){this.pause=false;},this,true);Y.Dom.setStyle(this.slides,'display','none');},clickHandler:function(e){var t=YAHOO.util.Event.getTarget(e);var idx=parseInt(t.innerHTML);while(t!=this.container){if(t.nodeName.toUpperCase()=="LI"){if(!this.sliding){this.play(idx,true);}
break;}else{t=t.parentNode;}}},mouseHandler:function(e){var t=Y.Event.getTarget(e);var idx=parseInt(t.innerHTML);while(t!=this.container){if(t.nodeName.toUpperCase()=="LI"){var self=this;this.delayTimeId=setTimeout(function(){self.play(idx,true);},(self.sliding?.5:.1)*1000);break;}else{t=t.parentNode;}}},play:function(n,flag){n=n-1;if(n==this.curSlide)return;if(this.curSlide==-1)
this.curSlide=0;if(flag&&this.autoPlayTimeId)
clearInterval(this.autoPlayTimeId);var triggersLis=this.triggersUL.getElementsByTagName('li');triggersLis[this.curSlide].className='';triggersLis[n].className=this.config.currentClass;this.slide(n);this.curSlide=n;if(flag&&!this.config.disableAutoPlay)
this.autoPlay();},slide:function(n){this.sliding=true;Y.Dom.setStyle(this.slides[this.curSlide],'display','none');Y.Dom.setStyle(this.slides[n],'display','block');this.sliding=false;this.onSlide.fire(n);},autoPlay:function(){var self=this;var callback=function(){if(!self.pause&&!self.sliding){var n=(self.curSlide+1)%self.slides.length+1;self.play(n,false);}}
this.autoPlayTimeId=setInterval(callback,this.config.autoPlayTimeout*1000);}}
TB.widget.ScrollSlide=function(container,config){this.init(container,config);}
YAHOO.extend(TB.widget.ScrollSlide,TB.widget.Slide,{initSlides:function(){TB.widget.ScrollSlide.superclass.initSlides.call(this);Y.Dom.setStyle(this.slides,'display','');},slide:function(n){var args={scroll:{by:[0,this.slidesUL.offsetHeight*(n-this.curSlide)]}};var anim=new Y.Scroll(this.slidesUL,args,.5,Y.Easing.easeOutStrong);anim.onComplete.subscribe(function(){this.sliding=false;this.onSlide.fire(n);},this,true);anim.animate();this.sliding=true;}});})();TB.widget.SimpleSlide=new function(){this.decoration=function(container,config){if(!container)return;config=config||{};if(config.effect=='scroll'){if(navigator.product&&navigator.product=='Gecko'){if(YAHOO.util.Dom.get(container).getElementsByTagName('iframe').length>0){new TB.widget.Slide(container,config);return;}}
new TB.widget.ScrollSlide(container,config);}
else{new TB.widget.Slide(container,config);}}}
