<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<title>Database Access</title>
</head>
<body>
	<c:set var="SiteId" value="10"/>
	
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf-8"
		user="root" password="123456" />

	<sql:update dataSource="${snapshot}" var="result">
		INSERT INTO websites (name, url, alexa, country) VALUES ('菜鸟教程移动站', 'http://m.runoob.com', 5093, 'CN');
	</sql:update>
	
	<sql:update dataSource="${snapshot}" var="count">
		UPDATE websites SET name = 'RUNOOB' WHERE Id = ?
		<sql:param value="${SiteId}" />
	</sql:update>

	<sql:query dataSource="${snapshot}" var="result">
		SELECT * from websites;
	</sql:query>
	
	<h1>Database</h1>
	<table border="1" width="100%">
		<tr>
			<th>ID</th>
			<th>站点名</th>
			<th>站点地址</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.id}" /></td>
				<td><c:out value="${row.name}" /></td>
				<td><c:out value="${row.url}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>