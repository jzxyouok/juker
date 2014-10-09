<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<sx:head/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
      }); 
      
      function check(obj){
    	  var hid=$(obj).parent().parent().children("td").eq(0).find("input").attr("value"); 
    	  var house_type=$(obj).parent().parent().children("td").eq(3).find("select").attr("value"); 
    	  var dealtime=$(obj).parent().parent().children("td").eq(5).find("input").attr("value");
    	  if(dealtime.length>=10)
    		  dealtime=dealtime.substr(0,10);
    	  var money=$(obj).parent().parent().children("td").eq(6).find("input").attr("value");
    	  var commision=$(obj).parent().parent().children("td").eq(7).find("input").attr("value");
    	  var cstate=$(obj).parent().parent().children("td").eq(8).find("select").attr("value");
          var url="deal_update.action?did="+hid+"&house_type="+house_type+"&dealtime="+dealtime+"&money="+money+"&commision="+commision+"&cstate="+cstate+"&page.pageIndex="+$("#page").val();
          
          window.location.href=url;
      }
   </script>
   <style type="text/css">
   td{ text-align:center;}
   input[type="text"]{
   height:25px;
   width:70px;
   }
   </style>
   <title>经纪人佣金列表</title>
 </head>
 <body>
     <div id="table" class="mt10">
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="60">选择</th>
                   <th>成交客户</th>
                   <th>成交房源</th>
                   <th width="130">成交户型</th>
                   <th width="120">客户经纪人</th>
                   <th>成交时间</th>
                   <th>成交价</th>
                   <th>佣金</th>
                   <th>佣金状态</th>
                   <th>操作</th>
                    </tr>
                 <s:iterator value="deals" id="d" >
                 <tr class="tr"> 
                   <td class="td_center"><input type="checkbox" value="${d.id}"></td>
                   <td>${d.customer_name}</td>
                   <td>${d.house_name}</td>
                   <td><s:select list="#{1:'一居',2:'两居',3:'三居',4:'四居',5:'别墅'}"    
                        name="house_type" theme="simple"    
                        value="#d.house_type"></s:select></td>
                   <td>${d.broker_name}</td>
                   <td><sx:datetimepicker name="dealtime"  displayFormat="yyyy-MM-dd" value="#d.dealtime"></sx:datetimepicker></td>
                   <td><input type="text" value="${d.money}"/></td> 
                   <td><input type="text" value="${d.commision}"/></td>
                   <td><s:select list="#{0:'未支付',1:'已支付'}"    
                        name="cstate" theme="simple"    
                        value="#d.cstate"></s:select>
                   </td>
                   <td> <input type="button" 
						class="btn btn82 btn_add" onclick="check(this)" value="保存"></td>            
                 </tr>
                 </s:iterator>
              </table>
               <input type=hidden name="page" id="page" value="${page.pageIndex}">
              <div class="page mt10">
				<div class="pagination">
					<ul>
					    <li class="first-child"><span>一共${page.pageCount}页</span></li>
					    <li class="first-child"><span>当前第${page.pageIndex}页</span></li>
						<li class="first-child"><a href="deal_list.action?dstate=1&type=0&page.pageIndex=1">首页</a></li>
						<s:if test="page.hasPrevious">
						<li class="first-child"><a href="deal_list.action?dstate=1&type=0&page.pageIndex=${page.pageIndex - 1}">上一页</a></span></li>
						</s:if>
						<s:if test="page.hasNext">
						<li class="first-child"><a href="deal_list.action?dstate=1&type=0&page.pageIndex=${page.pageIndex + 1}">下一页</a></span></li>
						</s:if>
						<li class="first-child"><a href="deal_list.action?dstate=1&type=0&page.pageIndex=${page.pageCount}">末页</a></span></li>
					</ul>			
				</div>
			</div>
        </div>
     </div>
 </body>
 </html>