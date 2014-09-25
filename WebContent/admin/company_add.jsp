<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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
   </script>
   <title>Document</title>
 </head>
 <body>
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">添加角色</b></div>
            <div class="box_center">
              <form action="role_add.action" class="jqtransform" id="form2" method="post">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
                  <td class="td_right">角色名字：</td>
                  <td class=""> 
                    <input type="text" name="name" class="input-text lh30" size="40">
                  </td>
                  </tr>
                  <tr>
                  <td class="td_right">角色描述：</td><td><input type="text" name="descr" class="input-text lh30" size="40"></td>
                </tr>
                <tr>
                  <td class="td_right">公司代码（管理员有效）：</td><td><input type="text" name="comid" class="input-text lh30" size="10"></td>
                </tr>
                 <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="button" name="button" class="btn btn82 btn_save2" value="保存" onclick="check()"> 
                    <input type="button" name="button" class="btn btn82 btn_res" value="取消"> 
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