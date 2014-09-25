<%@ page language="java" contentType="text/html; charset=utf-8" errorPage="/default_error.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<script type="text/javascript">
			window.top.location.href="<%=basePath%>login.jsp";
		</script>
	</head>
</html>