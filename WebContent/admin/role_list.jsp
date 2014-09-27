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
					<th>角色</th>
					<th>创建时间</th>
					<th width="130">創建者</th>
					<th width="130">描述</th>
					<th>操作</th>
				</tr>
				<s:iterator value="roles" id="h">
				<tr class="tr">
					<td>${h.name}</td>
					<td>${h.create_time}</td>
					<td>${h.creature}</td>
					<td>${h.descr}</td>
					<td>
					<a href="role_edit.action?rid=${h.id}" target="right"><input
							type="button" name="button" class="btn btn82 btn_add" value="编辑"></a>
					</td>
				</tr>
				</s:iterator>

			</table>
			<div class="page mt10">
				<div class="pagination">
					<ul>
						<li>&nbsp;&nbsp;&nbsp;</li>
						<li><input type="button" name="button"
							class="btn btn82 btn_save2" value="新建"
							onClick="location.href='role_add.jsp' "></li>
					</ul>
				</div>

			</div>
			<div class="page mt10">
				<div class="pagination">
					<ul>
					    <li class="first-child"><span>一共${page.pageCount}页</span></li>
					    <li class="first-child"><span>当前第${page.pageIndex}页</span></li>
						<li class="first-child"><a href="role_list.action?page.pageIndex=1">首页</a></li>
						<s:if test="page.hasPrevious">
						<li class="first-child"><a href="role_list.action?page.pageIndex=${page.pageIndex - 1}">上一页</a></span></li>
						</s:if>
						<s:if test="page.hasNext">
						<li class="first-child"><a href="role_list.action?page.pageIndex=${page.pageIndex + 1}">下一页</a></span></li>
						</s:if>
						<li class="first-child"><a href="role_list.action?page.pageIndex=${page.pageCount}">末页</a></span></li>
					</ul>			
				</div>
			</div>
		</div>
	</div>
</body>
</html>