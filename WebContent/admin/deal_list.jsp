<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
   </script>
   <style type="text/css">
   td{ text-align:center;}
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
                    </tr>
                 <s:iterator value="deals" id="d">
                 <tr class="tr"> 
                   <td class="td_center"><input type="checkbox"></td>
                   <td>${d.customer_name}</td>
                   <td>${d.house_name}</td>
                   <td>${d.house_btype}</td>
                   <td>${d.broker_name}</td>
                   <td>${d.dealtime}</td>
                   <td>${d.money}</td> 
                   <td>${d.commision}</td>
                   <td><s:if test='#d.cstate=="1"'>已支付</s:if>
                   <s:elseif test='#d.cstate=="0"'>未支付</s:elseif>
                   </td>            
                 </tr>
                 </s:iterator>
                 
              
              </table>
              <div class="page mt10">
				<div class="pagination">
					<ul>
					    <li class="first-child"><span>一共${page.pageCount}页</span></li>
					    <li class="first-child"><span>当前第${page.pageIndex}页</span></li>
						<li class="first-child"><a href="deal_list.action?page.pageIndex=1">首页</a></li>
						<s:if test="page.hasPrevious">
						<li class="first-child"><a href="deal_list.action?page.pageIndex=${page.pageIndex - 1}">上一页</a></span></li>
						</s:if>
						<s:if test="page.hasNext">
						<li class="first-child"><a href="deal_list.action?page.pageIndex=${page.pageIndex + 1}">下一页</a></span></li>
						</s:if>
						<li class="first-child"><a href="deal_list.action?page.pageIndex=${page.pageCount}">末页</a></span></li>
					</ul>			
				</div>
			</div>
        </div>
     </div>
 </body>
 </html>