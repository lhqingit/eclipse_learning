<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试结果</title>
</head>
<body>
	访问request作用范围域中的loginname对象requestScope.loginname：${requestScope.loginname}<br/><br/>
	访问request作用范围域中的password对象requestScope.password：${requestScope.password}<br/><br/>
	<br/><br/><br/><br/>requestScope:<br/><br/>${requestScope}<br/>
</body>
</html>