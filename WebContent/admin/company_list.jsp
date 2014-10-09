<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/main.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/colResizable-1.3.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>

<script type="text/javascript">
	$(function() {
		$(".list_table").colResizable({
			liveDrag : true,
			gripInnerHtml : "<div class='grip'></div>",
			draggingClass : "dragging",
			minWidth : 30
		});
</script>
<style type="text/css">
td {
	text-align: center;
}
</style>
<title>Document</title>
</head>
<body>
	<div id="table" class="mt10">
		<div class="box span10 oh">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="list_table">
				<tr>
					<th width="40">公司</th>
					<th width="40">地址</th>
					<th width="50">联系电话</th>
					<th width="30">邮箱</th>
				</tr>
				<s:iterator value="companies" id="h">
				<tr class="tr">	                
					<td>${h.name}</td>
					<td>${h.address}</td>
					<td>${h.phone}</td>
					<td>${h.email}</td>
				</tr>
				</s:iterator>

			</table>
			<div class="page mt10">
				<div class="pagination">
					<ul>				
						<li>&nbsp;&nbsp;</li>
						<li><input type="button" onClick="window.location.href='./company_add.jsp'"
							class="btn btn82 btn_del" value="新建"></li>	
					 
					</ul>
				</div>

			</div>
			<div class="page mt10">
				<div class="pagination">
					<ul>
					    <li class="first-child"><span>一共${page.pageCount}页</span></li>
					    <li class="first-child"><span>当前第${page.pageIndex}页</span></li>
						<li class="first-child"><a href="cde.action?page.pageIndex=1">首页</a></li>
						<s:if test="page.hasPrevious">
						<li class="first-child"><a href="cde.action?page.pageIndex=${page.pageIndex - 1}">上一页</a></span></li>
						</s:if>
						<s:if test="page.hasNext">
						<li class="first-child"><a href="cde.action?page.pageIndex=${page.pageIndex + 1}">下一页</a></span></li>
						</s:if>
						<li class="first-child"><a href="cde.action?page.pageIndex=${page.pageCount}">末页</a></span></li>
					</ul>			
				</div>
			</div>
			<input type="hidden" id="operate" name="operate"/>
		</div>
	</div>
</body>
</html>