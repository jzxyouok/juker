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
		
		$("#name").formValidator({
			onShow : "",
			onFocus : "至少2个长度",
			onCorrect : "名字合法"
		}).inputValidator({
			min : 4,
			empty : {
				leftEmpty : false,
				rightEmpty : false,
				emptyError : "姓名两边不能有空符号"
			},
			onError : "名字不合法,请确认"
		});
	});
</script>
<style type="text/css" media="all">
body,div {
	font-size: 12px;
}

input {
	width: 200px;
	height: 20px;
	border: 1px solid #6699FF;
	color: black;
}
</style>
</head>

<body>
	<div class="box_top">
		<b>新建开发商</b>
	</div>
	<center>
	<div style="font-size:30px">
	${message}
	</div>
		<font color="red" style="font-size:30px"><s:fielderror></s:fielderror></font>
		<form action="companyadd.action" method="post" name="form1" id="form1"
			autocomplete="off">
			<div id="forms">
				<div>
					<table style="font-size: 20px">
						<tr>
							<td align="right">开发商名字:</td>
							<td><input id="name" name="name"
								style="width: 160px" /></td>
							<td>
								<div id="nameTip" style="width: 250px"></div>
							</td>
						</tr>
						<tr>
							<td align="right">地址:</td>
							<td><input type="text" name="address" id="address"
								style="width: 160px" /></td>
							
						</tr>
						<tr>
							<td align="right">联系电话:</td>
							<td><input type="text" id="phone" name="phone"
								style="width: 160px" /></td>
						</tr>
						<tr>
							<td align="right">邮箱:</td>
							<td><input type="text" id="email" name="email"
								style="width: 160px" /></td>
						</tr>
						<tr>
							<td class="td_right">&nbsp;</td>
							<td class=""><input type=submit name="button"
								class="btn btn82 btn_res" value="保存"> <input
								type="reset" class="btn btn82 btn_res" value="取消"></td>
						</tr>
					</table>
				</div>
			</div>
		</form>
		</center>
</body>
</html>