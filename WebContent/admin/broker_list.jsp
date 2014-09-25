<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <link rel="stylesheet" href="css/common.css">
   <link rel="stylesheet" href="css/main.css">
   <script type="text/javascript" src="js/jquery.min.js"></script>
   <script type="text/javascript" src="js/colResizable-1.3.min.js"></script>
   <script type="text/javascript" src="js/common.js"></script>
   
   <script type="text/javascript">
      $(function(){  
        $(".list_table").colResizable({
          liveDrag:true,
          gripInnerHtml:"<div class='grip'></div>", 
          draggingClass:"dragging", 
          minWidth:30
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
  	    var checkbox = document.getElementsByName("sbrokers"); 
  	    for(var i=0;i<checkbox.length;i++){
  	    if(checkbox[i].checked == true)
  	    m = m + 1;}
  	    if(m==0){
  	    	alert("请选中至少一个");
  	    	return;
  	    	}
  	    $("#form2").submit();
    } 
      function check(obj){
    	  if($("#user").val()=="admin")
    		  $(obj).find("span").css("display","");
      }
   </script>
   <style type="text/css">
   td{ text-align:center;}
   </style>
   <title>经纪人列表</title>
 </head>
 <body>
     <div id="table" class="mt10">
        <div class="box span10 oh">
        <form action="brokers_update.action" method="post" id="form2">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="20"><input type="checkbox" name="all" id="all" />选择</th>
                   <th width="40">姓名</th>
                   <th width="60">手机</th>
                   <th width="30">推荐数</th>
                   <th width="30">到访数</th>
                   <th width="30">成交数</th>
                   <th width="80">账号</th>
                   <th width="50">注册时间</th>
                   <th width="80">操作</th>
                    </tr>
                    
                <s:iterator value="brokers" id="b">
                <tr class="tr">
                   <td class="td_center" ><input type="checkbox"  name="sbrokers" id="sbrokers" value="${b.id}"></td>
                   <td>${b.name}</td>
                   <td>${b.phone}</td>
                   <td>${b.recNum}</td>
                   <td>${b.arvNum}</td>
                   <td>${b.dealNum}</td>
                   <td onclick=check(this)>
                    <span style="display:none">${b.account}</span> 
                   </td>
                   <td>${b.createtime}</td>
                   <td>
                       <a href="broker_delete.action?bid=${b.id}&page.pageIndex=${page.pageIndex}" target="right"><input type="button" name="button" class="btn btn82 btn_del" value="删除"></a>
                   </td>
                 </tr>
                 </s:iterator>                
              </table>
              <div class="page mt10">
				<div class="pagination">
					<ul>
						<li>&nbsp;&nbsp;</li>
						<li><input type="button" onClick="transfer(this.value)"
							class="btn btn82 btn_del" value="删除"></li>
					</ul>
				</div>
              <div class="page mt10">
				<div class="pagination">
					<ul>
					    <li class="first-child"><span>一共${page.pageCount}页</span></li>
					    <li class="first-child"><span>当前第${page.pageIndex}页</span></li>
						<li class="first-child"><a href="broker_list.action?page.pageIndex=1">首页</a></li>
						<s:if test="page.hasPrevious">
						<li class="first-child"><a href="broker_list.action?page.pageIndex=${page.pageIndex - 1}">上一页</a></span></li>
						</s:if>
						<s:if test="page.hasNext">
						<li class="first-child"><a href="broker_list.action?page.pageIndex=${page.pageIndex + 1}">下一页</a></span></li>
						</s:if>
						<li class="first-child"><a href="broker_list.action?page.pageIndex=${page.pageCount}">末页</a></span></li>
					</ul>			
				</div>
			</div>
			<input type="hidden" name="user" id="user" value="${username}">
			</form>
        </div>
     </div>
 </body>
 </html>
  