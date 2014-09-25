<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    用户名:<s:property value="user.name"/>
	<s:form action="userRolesUpdate" method="post" name="myForm">
		 <s:optiontransferselect label="选择要授权的角色"  
              name="selectedRoles" leftTitle="已有角色"  
              list="rrs"
              listKey="id"
              listValue="name"
              doubleName="unSelecedRoles"  
              rightTitle="未授权角色" 
              doubleList="allRoles" 
              doubleListKey="id" 
              doubleListValue="name" 
              multiple="true" 
              addToLeftLabel="向左移动" 
              addToRightLabel="向右移动" 
              addAllToRightLabel="全部右移" 
              addAllToLeftLabel="全部左移"
              allowSelectAll="true" 
              headerKey="lKey" 
              headerValue="选择已有角色" 
              emptyOption="true"   
              doubleHeaderKey="rKey" 
              doubleHeaderValue="选择未擁有的角色" 
              doubleMultiple="true" 
              doubleEmptyOption="true"  
               >
   </s:optiontransferselect>
    <input type=hidden name="hid" value="${user.id}">
    <s:submit value="提交"></s:submit>
	</s:form>  
</body>
</html>