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
    角色名:<s:property value="role.name"/>        <font color=red><s:fielderror></s:fielderror></font>
	<s:form action="role_update" method="post" name="myForm">
		 <s:optiontransferselect label="选择要增加的菜单"  
              name="selectedNodes" leftTitle="已有菜单"  
              list="havedNodes"
              listKey="id"
              listValue="name"
              doubleName="unSelecedNodes"  
              rightTitle="未有菜单" 
              doubleList="allNodes" 
              doubleListKey="id" 
              doubleListValue="name" 
              multiple="true" 
              addToLeftLabel="向左移动" 
              addToRightLabel="向右移动" 
              addAllToRightLabel="全部右移" 
              addAllToLeftLabel="全部左移"
              allowSelectAll="true" 
              headerKey="lKey" 
              headerValue="选择已有菜单" 
              emptyOption="true"   
              doubleHeaderKey="rKey" 
              doubleHeaderValue="选择未擁有的菜单" 
              doubleMultiple="true" 
              doubleEmptyOption="true"  
               >
   </s:optiontransferselect>
    <input type=hidden name="rid" value="${role.id}">
    <s:submit value="提交"></s:submit>
	</s:form>  
</body>
</html>