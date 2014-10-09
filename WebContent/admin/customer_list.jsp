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
   
   <script type="text/javascript" charset="utf-8">
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
    	    var checkbox = document.getElementsByName("scustomers"); 
    	    for(var i=0;i<checkbox.length;i++){
    	    if(checkbox[i].checked == true)
    	    m = m + 1;}
    	    if(m==0){
    	    	alert("请选中至少一个");
    	    	return;
    	    	}
    	    var to=v;
    	    var arg;
    	    if(to=="转无效")
    	    	arg="1";
    	    else if(to=="转意向")
    	    	arg="2";
    	    else if(to=="转到访")
    	    	arg="3";
    	    else if(to=="转定金")
    	    	arg="4";
    	    else if(to=="转成交")
    	    	arg="5";
    	    $("#t_status").val(arg);
    	    $("#form2").submit();
      }
      
      function check(obj){
    	  var der=$(obj).parent().parent().children("td").eq(8).find("input").attr("value");  
    	  var hid=$(obj).parent().parent().children("td").eq(0).find("input").attr("value"); 
          var url="customer_stats.action?hid="+hid+"&to_status=2&page.pageIndex="+$("#page").val()+"&der="+der;
          window.location.href=url;
      }
   </script>
   <style type="text/css">
   td{ text-align:center;}
   </style>
   <title>Document</title>
 </head>
 <body>
     <div id="table" class="mt10">
        <div class="box span10 oh">
        <form action="customer_update.action" method="post" id="form2">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="60">选择</th>
                   <th>客户名称</th>
                   <th>客户电话</th>
                   <th>推荐经纪人</th>
                   <th width="200">意向房源</th>
                   <th>微信号</th>
                   <th>状态</th>
                   <th>推荐时间</th>
                   <th>客户负责人</th>
                   <th>操作</th>
                </tr>
           
              <s:iterator value="customers" id="h">
				<tr class="tr">
					<td class="td_center" ><input type="checkbox"  name="scustomers" id="scustomers" value="${h.id}"></td>
					<td>${h.name}</td>
					<td>${h.phone}</td>
					<td>${h.broker_name}</td>
					<td>${h.house_name}</td>
					<td>${h.weixin}</td>
					<td>${h.statusName}</td>
					<td>${h.dealtime}</td>
					<td><input style="width:100px;height:30px" value="${h.dealer}"/></td>
					<td>
					<s:if test="cstatus==0">
					<a href="customer_stats.action?hid=${h.id}&to_status=1&page.pageIndex=${page.pageIndex}" target="right"><input
							type="button" name="button" class="btn btn82 btn_add" value="转无效"></a>
						&nbsp;&nbsp;
					 <input type="button" name="button"
						class="btn btn82 btn_add" onclick="check(this)" value="转意向">
					</s:if>	
					<s:elseif test="cstatus==1">
						 <input type="button" name="button"
						class="btn btn82 btn_add" onclick="check(this)" value="转意向">
					</s:elseif>
					<s:elseif test="cstatus==2">
						<a href="customer_stats.action?hid=${h.id}&to_status=1&page.pageIndex=${page.pageIndex}" target="right"><input
							type="button" name="button" class="btn btn82 btn_add" value="转无效"></a>
						&nbsp;&nbsp;<a href="customer_stats.action?hid=${h.id}&to_status=3&page.pageIndex=${page.pageIndex}" target="right"> <input type="button" name="button"
						class="btn btn82 btn_add" value="转到访"></a>
					</s:elseif>
					<s:elseif test="cstatus==3">
						<a href="customer_stats.action?hid=${h.id}&to_status=1&page.pageIndex=${page.pageIndex}" target="right"><input
							type="button" name="button" class="btn btn82 btn_add" value="转无效"></a>
						&nbsp;&nbsp;<a href="customer_stats.action?hid=${h.id}&to_status=4&page.pageIndex=${page.pageIndex}" target="right"> <input type="button" name="button"
						class="btn btn82 btn_add" value=转定金></a>
					</s:elseif>
					<s:elseif test="cstatus==4">
						<a href="customer_stats.action?hid=${h.id}&to_status=1&page.pageIndex=${page.pageIndex}" target="right"><input
							type="button" name="button" class="btn btn82 btn_add" value="转无效"></a>
							<a href="customer_stats.action?hid=${h.id}&to_status=5&page.pageIndex=${page.pageIndex}" target="right"><input
							type="button" name="button" class="btn btn82 btn_add" value="转成交"></a>
					</s:elseif>
					</td>
				</tr>
				</s:iterator>
              </table>
              <div class="page mt10">
				<div class="pagination">
				    <s:if test="cstatus==0">
					<ul>
						<li>&nbsp;&nbsp;&nbsp;</li>
						<li><input type="button" 
							class="btn btn82 btn_save2" value="转无效"
							onClick="transfer(this.value)"></li>
						<li>&nbsp;&nbsp;</li>
						<li><input type="button" 
							class="btn btn82 btn_del" value="转意向"
							onClick="transfer(this.value)"></li>
					</ul>
					</s:if>
					<s:elseif test="cstatus==1">
					<ul>
						<li>&nbsp;&nbsp;&nbsp;</li>
						<li><input type="button" 
							class="btn btn82 btn_save2" value="转意向"
							onClick="transfer(this.value)"></li>
					</ul>
					</s:elseif>
					<s:elseif test="cstatus==2">
					<ul>
					    <li>&nbsp;&nbsp;&nbsp;</li>
						<li><input type="button" 
							class="btn btn82 btn_save2" value="转无效"
							onClick="transfer(this.value)"></li>
						<li>&nbsp;&nbsp;&nbsp;</li>
						<li><input type="button" 
							class="btn btn82 btn_save2" value="转到访"
							onClick="transfer(this.value)"></li>
					</ul>
					</s:elseif>
					<s:elseif test="cstatus==3">
					<ul>
					    <li>&nbsp;&nbsp;&nbsp;</li>
						<li><input type="button" 
							class="btn btn82 btn_save2" value="转无效"
							onClick="transfer(this.value)"></li>
						<li>&nbsp;&nbsp;&nbsp;</li>					    
						<li>&nbsp;&nbsp;&nbsp;</li>
						<li><input type="button" 
							class="btn btn82 btn_save2" value="转定金"
							onClick="transfer(this.value)"></li>
					</ul>
					</s:elseif>
					<s:elseif test="cstatus==4">
					<ul>
						<li>&nbsp;&nbsp;&nbsp;</li>
						<li><input type="button" 
							class="btn btn82 btn_save2" value="转无效"
							onClick="transfer(this.value)"></li>
						<li>&nbsp;&nbsp;</li>
						<li><input type="button" 
							class="btn btn82 btn_del" value="转成交"
							onClick="transfer(this.value)"></li>
					</ul>
					</s:elseif>
					<input type="hidden" id="t_status" name="t_status"/>
				</div>
			</div>
              </form>
              <input type=hidden name="page" id="page" value="${page.pageIndex}">
             <div class="page mt10">
				<div class="pagination">
					<ul>
					    <li class="first-child"><span>一共${page.pageCount}页</span></li>
					    <li class="first-child"><span>当前第${page.pageIndex}页</span></li>
						<li class="first-child"><a href="customer_list.action?page.pageIndex=1&cstatus=${cstatus}">首页</a></li>
						<s:if test="page.hasPrevious">
						<li class="first-child"><a href="customer_list.action?page.pageIndex=${page.pageIndex - 1}&cstatus=${cstatus}">上一页</a></span></li>
						</s:if>
						<s:if test="page.hasNext">
						<li class="first-child"><a href="customer_list.action?page.pageIndex=${page.pageIndex + 1}&cstatus=${cstatus}">下一页</a></span></li>
						</s:if>
						<li class="first-child"><a href="customer_list.action?page.pageIndex=${page.pageCount}&cstatus=${cstatus}">末页</a></span></li>
					</ul>			
				</div>
			</div>
        </div>
     </div>
 </body>
 </html>
  