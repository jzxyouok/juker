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

		var all_checked = false;
        $(":checkbox").click(function() {
            var table = $(this).parents("table");
            if($(this).attr("id") === "all") {
                table.find(":checkbox").prop("checked", !all_checked);
                all_checked = !all_checked;
            }
            else {
                table.find(":checkbox[id!=all]").each(function (i) {
                    if(!$(this).is(":checked")) {
                        table.find("#all").prop("checked", false);
                        all_checked = false;
                        return false;
                    }
                    $("#all").prop("checked", true);
                    all_checked = true;
                });
            }
        });
      }); 
      
      function transfer(v){
    	    var m = 0;
    	    var checkbox = document.getElementsByName("susers"); 
    	    for(var i=0;i<checkbox.length;i++){
    	    if(checkbox[i].checked == true)
    	    m = m + 1;}
    	    if(m==0){
    	    	alert("请选中至少一个");
    	    	return;
    	    	}
    	    var to=v;
    	    var arg;
    	    if(to=="激活")
    	    	arg="1";
    	    else if(to=="冻结")
    	    	arg="2";
    	    $("#operate").val(arg);
    	    $("#form2").submit();
      }
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
		<form action="userActive.action" method="post" id="form2">
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="list_table">
				<tr>
					<th width="20"><input type="checkbox" name="all" id="all" />选择</th>
					<th width="40">用户名</th>
					<th width="40">姓名</th>
					<th width="50">公司</th>
					<th width="30">状态</th>
					<th width="60">电话</th>
					<th width="60">QQ</th>
					<th width="80">注册日期</th>
					<th width="120">操作</th>
				</tr>
				<s:iterator value="users" id="h">
				<tr class="tr">
	                <td class="td_center" ><input type="checkbox"  name="susers" id="susers" value="${h.id}"></td>
					<td>${h.username}</td>
					<td>${h.name}</td>
					<td>${h.company.name}</td>
					<td><s:if test='#h.state=="0"'>冻结</s:if><s:elseif test='#h.state=="1"'>正常</s:elseif></td>
					<td>${h.phone}</td>
					<td>${h.qq}</td>
					<td>${h.create_time}</td>
					<td>
					<s:if test='#h.state=="0"'><a href="user_edit.action?hid=${h.id}&operate=1" target="right"><input
							type="button" name="button" class="btn btn82 btn_add" value="激活"></a></s:if>
					<s:elseif test='#h.state=="1"'><a href="user_edit.action?hid=${h.id}&operate=2" target="right"><input
							type="button" name="button" class="btn btn82 btn_add" value="冻结"></a></s:elseif>
						&nbsp;&nbsp;<a href="cde.action?hid=${h.id}" target="right"> <input type="button" name="button"
						class="btn btn82 btn_add" value="授权"></a></td>
				</tr>
				</s:iterator>

			</table>
			<div class="page mt10">
				<div class="pagination">
					<ul>
						<li>&nbsp;&nbsp;&nbsp;</li>
						<li><input type="button" onClick="window.location.href='user_add.jsp'"
							class="btn btn82 btn_del" value="新建"></li>	
					 
					</ul>
				</div>

			</div>
			<div class="page mt10">
				<div class="pagination">
					<ul>
					    <li class="first-child"><span>一共${page.pageCount}页</span></li>
					    <li class="first-child"><span>当前第${page.pageIndex}页</span></li>
						<li class="first-child"><a href="user_list.action?page.pageIndex=1">首页</a></li>
						<s:if test="page.hasPrevious">
						<li class="first-child"><a href="user_list.action?page.pageIndex=${page.pageIndex - 1}">上一页</a></span></li>
						</s:if>
						<s:if test="page.hasNext">
						<li class="first-child"><a href="user_list.action?page.pageIndex=${page.pageIndex + 1}">下一页</a></span></li>
						</s:if>
						<li class="first-child"><a href="user_list.action?page.pageIndex=${page.pageCount}">末页</a></span></li>
					</ul>			
				</div>
			</div>
			<input type="hidden" id="operate" name="operate"/>
			</form>
		</div>
	</div>
</body>
</html>