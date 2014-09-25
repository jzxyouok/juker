<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<META HTTP-EQUIV="Pragma" CONTENT="no-store">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">
<title>用户注册</title>
<script src="js/jquery-formValidator/jquery-1.4.4.js"
	type="text/javascript"></script>
<link type="text/css" rel="stylesheet"
	href="js/jquery-formValidator/style/validator.css"></link>
<script src="js/jquery-formValidator/formValidator-4.0.1.js"
	type="text/javascript" charset="UTF-8"></script>
<script src="js/jquery-formValidator/formValidatorRegex.js"
	type="text/javascript" charset="UTF-8"></script>
<script type="javascript/text"
	src="js/jquery-formValidator/DateTimeMask.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.4/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.4/themes/icon.css">
<script type="text/javascript"
	src="js/jquery-easyui-1.2.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-formValidator/jquery.md5.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.2.4/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/main.css">

<script type="text/javascript">
	$(document).ready(function() {
		$.formValidator.initConfig({
			formID : "form1",
			debug : false,
			submitOnce : true,
			submitAfterAjaxPrompt : '有数据正在异步验证，请稍等...'
		});
		$("#username").formValidator({
			onShow : "请输入用户名",
			onFocus : "用户名至少6个字符,最多10个字符",
			onCorrect : "该用户名可以注册"
		}).inputValidator({
			min : 6,
			max : 10,
			empty : {
				leftEmpty : false,
				rightEmpty : false,
				emptyError : "密码两边不能有空符号"
			},
			onError : "你输入的用户名非法,请确认"
		})//.regexValidator({regExp:"username",dataType:"enum",onError:"用户名格式不正确"})
		.ajaxValidator({
			dataType : "json",
			async : true,
			url : "abc.action",
			data : {
				'username' : $('#username').val(),
				'type' : '2'
			},
			success : function(data) {
				var state = eval("(" + data.result + ")");
				if (state.result == "ok")
					return true;
				return false;
			},
			buttons : $("#button"),
			error : function(jqXHR, textStatus, errorThrown) {
				alert("服务器没有返回数据，可能服务器忙，请重试" + errorThrown);
			},
			onError : "该用户名不可用，请更换用户名",
			onWait : "正在对用户名进行合法性校验，请稍候..."
		});
		$("#name").formValidator({
			onShow : "请输入真实姓名",
			onFocus : "至少6个长度",
			onCorrect : "姓名合法"
		}).inputValidator({
			min : 4,
			empty : {
				leftEmpty : false,
				rightEmpty : false,
				emptyError : "姓名两边不能有空符号"
			},
			onError : "姓名不合法,请确认"
		});
		$("#password").formValidator({
			onShow : "请输入密码",
			onFocus : "至少6个长度",
			onCorrect : "密码合法"
		}).inputValidator({
			min : 6,
			empty : {
				leftEmpty : false,
				rightEmpty : false,
				emptyError : "密码两边不能有空符号"
			},
			onError : "密码不能为空,请确认"
		});
	});

	window.onload = function() {
		var verifyObj = document.getElementById("Verify");
		verifyObj.onclick = function() {
			this.src = "authCodeAction?timestamp=" + new Date().getTime();
		};
	}

	function check() {
		var form2 = document.getElementById("form1");
		form2.submit();
	}
	function reset() {
		var form2 = document.getElementById("form1");
		form2.reset();
	}
</script>
<style type="text/css" media="all">
body,div {
	font-size: 12px;
}

input {
	width: 200px;
	height: 20px;
	border: 1px solid #6699FF;
	color: #cbc9c8;
}
</style>
</head>

<body>
	<div class="box_top">
		<b>新建用户</b>
	</div>
	<center>
		<font size="15" color="red"><s:fielderror></s:fielderror></font>
		<form action="useradd.action" method="post" name="form1" id="form1"
			autocomplete="off">
			<div id="forms">

				<div>
					<table style="font-size: 20px">
						<tr>
							<td align="right">用户名:</td>
							<td><input id="username" name="username"
								style="width: 160px" /></td>
							<td>
								<div id="usernameTip" style="width: 250px"></div>
							</td>
						</tr>
						<tr>
							<td align="right">密码:</td>
							<td><input type="password" name="password" id="password"
								style="width: 160px" /></td>
							<td>
								<div id="passwordTip" style="width: 250px"></div>
							</td>
						</tr>
						<tr>
							<td align="right">姓名:</td>
							<td><input type="text" id="name" name="name"
								style="width: 160px" /></td>
							<td>
								<div id="nameTip" style="width: 250px"></div>
							</td>
						</tr>
						<tr>
							<td align="right">电话:</td>
							<td><input type="text" id="phone" name="phone"
								style="width: 160px" /></td>
							<td>
								<div id="phoneTip" style="width: 250px"></div>
							</td>
						</tr>
						<tr>
							<td align="right">邮箱:</td>
							<td><input type="text" id="email" name="email"
								style="width: 160px" /></td>
							<td>
								<div id="phoneTip" style="width: 250px"></div>
							</td>
						</tr>
						<tr>
							<td align="right">QQ:</td>
							<td><input type="text" id="qq" name="qq"
								style="width: 160px" /></td>
							<td>
								<div id="phoneTip" style="width: 250px"></div>
							</td>
						</tr>
						<tr>
							<td class="td_right">&nbsp;</td>
							<td class=""><input type=submit name="button" class="btn btn82 btn_res"
								 value="保存">
								<input type="reset" class="btn btn82 btn_res"
								value="取消" ></td>
						</tr>
					</table>
				</div>
			</div>
		</form>
	</center>
</body>
</html>