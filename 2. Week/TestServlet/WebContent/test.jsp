<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="TestServlet" method="post">
		账号:<input type="text" name="account" />${accountErrorString }<br>
		密码:<input type="password" name="psd" />${psdErrorString }<br> 
			<input type="submit" value="提交" /><br>${errorString }
	</form>
</body>
</html>