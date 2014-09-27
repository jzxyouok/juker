<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/button.css">
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
<title>经纪人列表</title>
</head>
<body>
	<div id="table" class="mt10">
		<div class="box span10 oh">
			<form action="#" method="post" id="form2">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					class="list_table">
					<tr>
						<th width="25">经纪人</th>
						<th width="40">房源</th>
						<th width="30">户型</th>
						<th width="30">客户</th>
						<th width="30">状态</th>
						<th width="30">价格</th>
						<th width="30">佣金</th>
						<th width="30">支付状态</th>
						<th width="50">推荐时间</th>
						<th width="50">成交时间</th>
						<th width="50">客户负责人</th>
					</tr>
					<s:iterator value="deals" id="b">
						<tr class="tr">
							<td>${b.broker_name}</td>
							<td>${b.house_name}</td>
							<td>${b.house_type_name}</td>
							<td>${b.customer_name}</td>
							<td>${b.status_name}</td>
							<td>${b.money}</td>
							<td>${b.commision}</td>
							<td>${b.cstate_name}</td>
							<td>${b.createtime}</td>
							<td>${b.dealtime}</td>
							<td>${b.dealer}</td>
						</tr>
					</s:iterator>
				</table>
				<div class="page mt10">
					<div class="pagination">
						<ul>
							<li class="first-child"><span>一共${page.pageCount}页</span></li>
							<li class="first-child"><span>当前第${page.pageIndex}页</span></li>
							<li class="first-child"><a
								href="broker_deals.action?page.pageIndex=1&did=${did}">首页</a></li>
							<s:if test="page.hasPrevious">
								<li class="first-child"><a
									href="broker_deals.action?page.pageIndex=${page.pageIndex - 1}&did=${did}">上一页</a></span></li>
							</s:if>
							<s:if test="page.hasNext">
								<li class="first-child"><a
									href="broker_deals.action?page.pageIndex=${page.pageIndex + 1}&did=${did}">下一页</a></span></li>
							</s:if>
							<li class="first-child"><a
								href="broker_deals.action?page.pageIndex=${page.pageCount}&did=${did}">末页</a></span></li>
						</ul>
					</div>
				</div>
				<input type="hidden" name="user" id="user" value="${username}">
				<input type="hidden" name="crflag" id="crflag" value="${crflag}">
			</form>
		</div>
	</div>
</body>
</html>
