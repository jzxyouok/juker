<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
 <head>
   <meta charset="UTF-8">
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
   dt{ padding-left:30px; float:left;}
   dd{ padding-left:120px;}
   .pageContent{ background-color:#F7FFFE; height:100%; padding-top:20px;}
   </style>
   <title>Document</title>
 </head>
 <body>
    <div class="pageContent">
			<div class="pageFormContent nowrap" layoutH="56">
				<dl id="title_div">				
						<dt>城市名称：</dt>					
					<dd style="width: 1200px;">
					    ${house.city}
					</dd>
				</dl><br>	
				<dl id="title_div">
					<dt>项目名称：</dt>
					<dd style="width: 1200px;">
					  ${house.name}
					</dd>
				</dl><br>					
				<dl id="title_div">
					<dt>项目地址：</dt>
					<dd style="width: 1200px;">
					  ${house.adress}
					</dd>
				</dl><br>					
				<dl id="title_div">
					<dt>面积范围：</dt>
					<dd style="width: 1200px;">
					 ${house.area}
					</dd>
				</dl><br>	
			   <dl id="title_div">
					<dt>单价：</dt>
					<dd style="width: 1200px;">
					 ${house.price}
					</dd>
				</dl><br>
               <dl id="title_div">
					<dt>特色：</dt>
					<dd style="width: 1200px;">
						${house.feature}
					</dd>
				</dl><br>
				<dl id="title_div">
					<dt>优惠信息：</dt>
					<dd style="width: 1200px;">
						${house.discount}
					</dd>
				</dl><br>		
				<dl id="pic">
					<dt>楼盘相册：</dt>
					<dd style="width: 1200px;">
					            <s:iterator value="pics" id="p">
								<div style='float:left;border:0px solid gray;'>
									<div style='border:0px solid gray;float:left;backgroud-color:white;margin-right:5px;'>
										<img style='position: relative;z-index: 1;height:110px;width:138px' src='admin/images/houses/${p}.JPG'/> 
									</div>
								</div>	
								</s:iterator>					
								
					</dd>
				</dl><br><br><br><br><br><br><br>				
				<dl id="title_div">
					<dt>开盘时间：</dt>
					<dd style="width: 1200px;">
						${house.saleTime}
					</dd>
				</dl><br>						
				<dl id="title_div">
					<dt>楼盘简介：</dt>
					<dd style="width: 1200px;">	
					${house.descr}																																																														
					</dd>
				</dl><br>
				<dl id="title_div">
					<dt>楼盘类型：</dt>
					<dd style="width: 1200px;">							
						${house.btype}
					</dd>
				</dl><br>				
				<dl id="title_div">
					<dt>装修类型：</dt>
					<dd style="width: 1200px;">
					${house.dtype}
					</dd>
				</dl><br>
				
				<dl id="title_div">
					<dt>开发商简介：</dt>
					<dd style="width: 1200px;">
					${house.developer}
					</dd>
				</dl><br>
								
				<dl id="title_div">
					<dt>售楼地址：</dt>
					<dd style="width: 1200px;">
					 ${house.saleAdress}
					</dd>
				</dl><br>
				
				<dl id="title_div">
					<dt>售楼电话：</dt>
					<dd style="width: 1200px;">
					${house.salePhone}
					</dd>
				</dl><br>
								
				<dl id="title_div">
					<dt>交通状况：</dt>
					<dd style="width: 1200px;">
				     ${house.transport}
					</dd>
				</dl><br>

				<dl id="title_div">
					<dt>车位信息：</dt>
					<dd style="width: 1200px;">
						${house.stop}
					</dd>
				</dl><br>
				
				<dl id="title_div">
					<dt>相关信息：</dt>
					<dd style="width: 1200px;">
					${house.relat}						
					</dd>
				</dl><br><br>
                
                <dl id="title_div">
					<dt>录入时间：</dt>
					<dd style="width: 1200px;">
                     ${house.modifyTime}
					</dd>
				</dl>
                <br/><br/>
			</div>
	</div>
 </body>
 </html>