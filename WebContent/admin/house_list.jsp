<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
					<th>项目名称</th>
					<th>项目地址</th>
					<th width="130">单价</th>
					<th width="200">房源类型</th>
					<th width="200">售楼电话</th>
					<th>优惠信息</th>
					<th>操作</th>
				</tr>
				<s:iterator value="houses" id="h">
				<tr class="tr">
					<td>${h.name}</td>
					<td>${h.adress}</td>
					<td>${h.price}</td>
					<td>${h.btype}</td>
					<td>${h.salePhone}</td>
					<td>${h.discount}</td>
					<td><a href="house_detail.action?hid=${h.id}&operate=1" target="right"><input
							type="button" name="button" class="btn btn82 btn_add" value="预览"></a>
						&nbsp;&nbsp;<a href="house_detail.action?hid=${h.id}&operate=2" target="right"> <input type="button" name="button"
						class="btn btn82 btn_add" value="修改"></a></td>
				</tr>
				</s:iterator>

			</table>
			<div class="page mt10">
				<div class="pagination">
				</div>
			</div>
			<div class="page mt10">
				<div class="pagination">
					<ul>
					    <li class="first-child"><span>一共${page.pageCount}页</span></li>
					    <li class="first-child"><span>当前第${page.pageIndex}页</span></li>
						<li class="first-child"><a href="house_list.action?page.pageIndex=1">首页</a></li>
						<s:if test="page.hasPrevious">
						<li class="first-child"><a href="house_list.action?page.pageIndex=${page.pageIndex - 1}">上一页</a></span></li>
						</s:if>
						<s:if test="page.hasNext">
						<li class="first-child"><a href="house_list.action?page.pageIndex=${page.pageIndex + 1}">下一页</a></span></li>
						</s:if>
						<li class="first-child"><a href="house_list.action?page.pageIndex=${page.pageCount}">末页</a></span></li>
					</ul>			
				</div>
			</div>
		</div>
	</div>
</body>
</html>