<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="10kb"%>

<!DOCTYPE html>
<!-- http://localhost:8080/JSP/main.jsp -->
<html>
    <head>
		<title>main.jsp</title>
    </head>
    <body>
		<h2>Include date.jsp</h2>
		<%-- <jsp:include page="date.jsp" flush="true"/> --%>
		<jsp:useBean id="test" class="com.qiaw99.TestBean" />
		<jsp:setProperty name="test" property="message" value="qiaw99"/>
		<p>Print the information!</p>
		<br/>
		<jsp:getProperty name="test" property="message"/>
		
		<jsp:element name="xmlElement">
			<jsp:attribute name="xmlElementAttr">
			 	  属性值
			</jsp:attribute>
			<jsp:body>
			   XML 元素的主体
			</jsp:body>
		</jsp:element>
		
		<jsp:text>Test</jsp:text>
    </body>
</html>