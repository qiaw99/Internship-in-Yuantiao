<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- http://localhost:8080/JSP/Life.jsp -->
<html>
<head>
<title>life.jsp</title>
</head>
<body>
	<%!
		private int initVar = 0;
		private int serviceVar = 0;
		private int destroyVar = 0;
		private int day = 3;
		private int fontSize;
	%>
	
	<%!
		public void jspInit() {
			initVar++;
			System.out.println("jspInit()被调用： " + initVar);
		}
	
		public void jspDestroy() {
			destroyVar++;
			System.out.println("jspDestroy()被调用： " + initVar);
		}
	%>
	
	<!-- 脚本程序可以包含任意量的Java语句、变量、方法或表达式 -->
	<jsp:scriptlet>
		serviceVar++;
		System.out.println("_jspService(): JSP共响应了" + serviceVar + "次请求");
	</jsp:scriptlet>
	
	<%-- 一个声明语句可以声明一个或多个变量、方法，供后面的Java代码使用 --%>
	<jsp:declaration>	
		String content1 = "初始化次数 : " + initVar;
		String content2 = "响应客户请求次数 : " + serviceVar;
		String content3 = "销毁次数 : " + destroyVar;
	</jsp:declaration>
	
	<h1>JSP 测试实例</h1>
	<!-- 一个JSP表达式中包含的脚本语言表达式，先被转化成String，然后插入到表达式出现的地方。 -->
	<p><%=content1 %></p>
	<p><%=content2 %></p>
	<p><jsp:expression>content3</jsp:expression></p>
	<p>
	 	今天的日期是: <%= (new java.util.Date()).toString()%>
	</p>
	
	<%-- if..else.. --%>
	<% if(day == 0 | day == 7){ %>
		<p>Weelend!</p>
	<% } else {%>
		<p>Weekday!</p>
	<% } %>
	
	<%-- switch case --%>
	<% 
		switch(day) {
		case 0:
		   out.println("星期天");
		   break;
		case 1:
		   out.println("星期一");
		   break;
		case 2:
		   out.println("星期二");
		   break;
		case 3:
		   out.println("星期三");
		   break;
		case 4:
		   out.println("星期四");
		   break;
		case 5:
		   out.println("星期五");
		   break;
		default:
		   out.println("星期六");
		}
	%>
	
	<%-- for loop --%>
	<% for(fontSize = 1; fontSize <= 3; fontSize ++){ %>
		<br />
		<font color="green" size="<%=fontSize%>">
		Test!
		</font><br/>
	<% } %>
	
	<%-- while loop --%>
	<%while (fontSize <= 6){ %>
	   <font color="red" size="<%= fontSize %>">
	   	 Test
	   </font><br />
	<%fontSize++;%>
	<%}%>
</body>
</html>