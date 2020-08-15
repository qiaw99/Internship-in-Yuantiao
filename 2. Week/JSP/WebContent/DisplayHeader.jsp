<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Display Header</title>
</head>
<body>
	<h2>HTTP Header Request</h2>
	<table width="100%" border="1" align="center">
		<tr bgcolor="#949494">
			<th>Header Name</th>
			<th>Header Value(s)</th>
		</tr>
		<%
			Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String paramName = headerNames.nextElement();
				out.print("<tr><td>" + paramName + "</td>\n");
				String paramValue = request.getHeader(paramName);
				out.println("<td> " + paramValue + "</td></tr>\n");
			}
		%>
	</table>
</body>
</html>