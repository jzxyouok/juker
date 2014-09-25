<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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
   <script type="text/javascript" src="js/geo.js"></script>
   <script type="text/javascript">
      $(function(){  
        $(".list_table").colResizable({
          liveDrag:true,
          gripInnerHtml:"<div class='grip'></div>", 
          draggingClass:"dragging", 
          minWidth:30
        }); 
        
      }); 
      
      function check(){
    	  var form2=document.getElementById("form2");
    	  form2.submit();
      }
      function reset(){
    	  var form2=document.getElementById("form2");
    	  form2.reset();
      }
   </script>
   <title>Document</title>
 </head>
 <body >
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">新建用户</b></div>
            <div class="box_center">
              <s:fielderror></s:fielderror>
              <form action="user_add.action" class="jqtransform" id="form2"  method="post">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
                  <td class="td_right">用户名：</td>
                  <td class=""> 
                    <input type="text" name="username" class="input-text lh30" >
                  </td>
                  </tr>
                  <tr>
                  <td class="td_right">密码 ：</td><td><input type="password" name="password" class="input-text lh30" ></td>
                </tr>
                <tr>
                  <td class="td_right">姓名：</td><td><input type="text" name="name" class="input-text lh30" size="20"></td>
                </tr>
         
                <tr >
                  <td class="td_right">角色：</td>
                  <td class="">
                    <span class="fl">
                      <div class="select_border"> 
                        <div class="select_containers ">
                        <select name=roleCode class="select"> 
                        <option value="manager">经理</option> 
                        <option value="admin">管理员</option> 
                        <option value="tomcat">普通用户</option> 
                        <option value="guest">临时工</option>
                        </select> 
                        </div> 
                      </div> 
                    </span>
                  </td>
                 </tr>
            
                              <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="button" name="button" class="btn btn82 btn_save2" value="保存" onclick="check()"> 
                    <input type="button" name="button" class="btn btn82 btn_res" value="取消" onclick="reset()"> 
                   </td>
                 </tr>
               </table>
               </form>
             
            </div>
          </div>
        </div>
     </div>
 </body>
 </html>