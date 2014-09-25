<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="css/login.css"></link>
    <script type="text/javascript" src="js/jquery.min.js"></script>
	<title>后台登陆</title>
</head>
<body>
	<div id="login_top">
		<div id="welcome">
			欢迎使用聚客通经纪人管理系统
		</div>
	</div>
	<div id="login_center">
		<div id="login_area">
			<div id="login_form">
				<form action="user_login.action" method="post">
					<div id="login_tip">
						用户登录&nbsp;&nbsp;UserLogin ${tip}
					</div>
					<div><s:fielderror></s:fielderror></div>
					<div><input type="text" class="username" name="username"></div>
					<div><input type="password" class="pwd" name="password"></div>
					<div><span type="text" name="message"></span></div>
					<div id="btn_area">
						<input type="submit" name="submit" id="sub_btn" value="登&nbsp;&nbsp;录">&nbsp;&nbsp;
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="login_bottom">
		版权所有
	</div>
</body>
</html>
