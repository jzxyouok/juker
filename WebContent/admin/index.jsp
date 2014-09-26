<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript">
	$(function() {
		$(".sideMenu").slide({
			titCell : "h3",
			targetCell : "ul",
			defaultIndex : 0,
			effect : 'slideDown',
			delayTime : '500',
			trigger : 'click',
			triggerTime : '150',
			defaultPlay : true,
			returnDefault : false,
			easing : 'easeInQuint',
			endFun : function() {
				scrollWW();
			}
		});
		$(".nl").click(function (){
	      var ha=document.getElementById("ha");
	      ha.innerHTML=this.innerHTML;
	      this.style.color="red";
	      $(".nl").not(this).each(function() {
	            $(this).css({color: "black"});
	        });
	    });
		
		$(window).resize(function() {
			scrollWW();
		});
		
		$("#go").click(function (){
			var ha=document.getElementById("ha");
			var uri;
			var stext=$("#stext").val();
			if($("#stext").val()==""){
				alert("请输入查询条件");
				return;
			}
		  else if($("#stype").val()=="1") {
			   ha.innerHTML="经纪人列表";
			   uri="broker_listByName.action?name="+stext;			   
		}
			else if($("#stype").val()=="2") {
			   ha.innerHTML="客户列表";
			   uri="customer_listByName.action?name="+stext;			
			}
			 parent.right.location.href=uri;
		});
	});
	function scrollWW() {
		if ($(".side").height() < $(".sideMenu").height()) {
			$(".scroll").show();
			var pos = $(".sideMenu ul:visible").position().top - 38;
			$('.sideMenu').animate({
				top : -pos
			});
		} else {
			$(".scroll").hide();
			$('.sideMenu').animate({
				top : 0
			});
			n = 1;
		}
	}
	var n = 1;
	function menuScroll(num) {
		var Scroll = $('.sideMenu');
		var ScrollP = $('.sideMenu').position();
		/*alert(n);
		alert(ScrollP.top);*/
		if (num == 1) {
			Scroll.animate({
				top : ScrollP.top - 38
			});
			n = n + 1;
		} else {
			if (ScrollP.top > -38 && ScrollP.top != 0) {
				ScrollP.top = -38;
			}
			if (ScrollP.top < 0) {
				Scroll.animate({
					top : 38 + ScrollP.top
				});
			} else {
				n = 1;
			}
			if (n > 1) {
				n = n - 1;
			}
		}
	}
</script>
<title>后台首页</title>
</head>
<body>
	<div class="top">
		<div id="top_t">
			<div id="logo" class="fl">
			
			</div>
			


<select id="stype">
<option value="1" selected>经纪人</option>
<option value="2">客戶</option>
</select>
<input type="text" id="stext" style="width:30px height:20px" /> 
<input type="image" src="http://files.jb51.net/demoimg/200912/btn_search_box.gif" width="27" height="24" id="go" alt="Search" title="Search" /> 
		
			<div id="photo_info" class="fr">
				<div id="photo" class="fl">
					<a href="#"><img src="images/a.png" alt="" width="60"
						height="60"></a>
				</div>
			   
				<div id="base_info" class="fr">
					<div class="help_info">
						<a href="1" id="hp">&nbsp;</a> <a href="2" id="gy">&nbsp;</a> <a
							href="login.html" id="out">&nbsp;</a>
					</div>
					<div class="info_center">
						${user.username} <span id="nt">通知</span><span><a href="#" id="notice">3</a></span>
					</div>
				</div>
			</div>
		</div>
		<div id="side_here">
			<div id="side_here_l" class="fl"></div>
			<div id="here_area" class="fl">当前位置：<span id="ha">首页</span></div>
		</div>
	</div>
	<div class="side">
		<div class="sideMenu" style="margin: 0 auto">
			<s:iterator value="root.children" id="c">
				<h3>${c.name}</h3>
				<ul>
					<s:iterator value="#c.children" id="cc">
						<li><a class="nl" href="${cc.url}" target="right">${cc.name}</a></li>
					</s:iterator>
				</ul>
			</s:iterator>
		</div>
	</div>
	<div class="main">
		<iframe name="right" id="rightMain"
			src="main.jsp" frameborder="no"
			scrolling="auto" width="100%" height="auto" allowtransparency="true"></iframe>
	</div>
	<div class="bottom">
		<div id="bottom_bg">版权</div>
	</div>
	<div class="scroll">
		<a href="javascript:;" class="per" title="使用鼠标滚轴滚动侧栏"
			onClick="menuScroll(1);"></a> <a href="javascript:;" class="next"
			title="使用鼠标滚轴滚动侧栏" onClick="menuScroll(2);"></a>
	</div>
</body>
</html>
