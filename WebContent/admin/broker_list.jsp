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
      
      function ord(type){
    	  if($("#crflag").val()==undefined)
    		  $("#crflag").val("1");
    	  else if($("#crflag").val()=="1")
    		  $("#crflag").val("2");
    	  else  $("#crflag").val("1");
    	  window.location.href="broker_list.action?page.pageIndex=1&crflag="+$("#crflag").val()+"&type="+type;  
      }
      
      function detail(obj){
    	  var bid=$(obj).parent().parent().children("td").eq(0).find("input").attr("value"); 
    	  window.location.href="broker_deals.action?did="+bid+"&page.pageIndex=1";
      }
      
      function ord(type){
    	  if($("#crflag").val()==undefined)
    		  $("#crflag").val("1");
    	  else if($("#crflag").val()=="1")
    		  $("#crflag").val("2");
    	  else  $("#crflag").val("1");
    	  window.location.href="broker_list.action?page.pageIndex=1&crflag="+$("#crflag").val()+"&type="+type;  
      }
      
      function skip(v){
    	  var page=parseInt($("#index").val());
    	  if(v==1)
    		  page=1;
    	  else if(v==2)
    		  page=page-1;
    	  else if(v==3)
    		  page=page+1;
    	  else if(v==4)
    		  page=$("#pageCount").val();
    	  window.location.href="broker_list.action?page.pageIndex="+page+"&crflag="+$("#crflag").val()+"&type="+$("#type").val();
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
                   <th width="25">姓名</th>
                   <th width="40">手机</th>
                   <th width="30"><input type="button" value="推荐数" class="white" onclick="ord(2)"/></th>
                   <th width="30"><input type="button" value="到访数" class="white" onclick="ord(3)"/></th>
                   <th width="30"><input type="button" value="成交数" class="white" onclick="ord(4)"/></th>
                   <th width="80">账号</th>
                   <th width="60" ><input type="button" value="注册时间" class="white" onclick="ord(1)"/></th>
                   <th width="50">操作</th>
                    </tr>
                    
                <s:iterator value="brokers" id="b">
                <tr class="tr">
                   <td class="td_center" ><input type="checkbox"  name="sbrokers" id="sbrokers" value="${b.id}"></td>
                   <td><input type=button onclick="detail(this)" class="white" value="${b.name}"></td>
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
						<li class="first-child"><span><input class="blue"  type=button onclick="skip(1)" value="首页"></span></li>
						<s:if test="page.hasPrevious">
						<li class="first-child"><span><input  class="blue" type=button onclick="skip(2)" value="上一页"></span></li>
						</s:if>
						<s:if test="page.hasNext">
						<li class="first-child"><span><input  class="blue" type=button onclick="skip(3)" value="下一页"></span></li>
						</s:if>
						<li class="first-child"><span><input  class="blue" type=button onclick="skip(4)" value="末页"></span></li>
					</ul>			
				</div>
			</div>
			<input type="hidden" name="user" id="user" value="${username}">
			<input type="hidden" name="crflag" id="crflag" value="${crflag}">
			<input type="hidden" name="type" id="type" value="${type}">
			<input type="hidden" name="index" id="index" value="${page.pageIndex}">
			<input type="hidden" name="pageCount" id="pageCount" value="${page.pageCount}">
			</form>
        </div>
     </div>
 </body>
 </html>
  