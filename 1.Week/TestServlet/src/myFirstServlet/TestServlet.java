package myFirstServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String message;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
	}

	@Override
	public void init() {
		this.message = "Hello!";
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * http://localhost:8080/TestServlet/TestServlet?name=%E8%8F%9C%E9%B8%9F%E6%95%99%E7%A8%8B&url=www.runoob.com
		 */

		Cookie nameCookie = new Cookie("name", URLEncoder.encode(request.getParameter("name"), "UTF-8"));
		Cookie urlCookie = new Cookie("url", request.getParameter("url"));
		
		nameCookie.setMaxAge(60 * 60 * 24);
		urlCookie.setMaxAge(60 * 60 * 24);
		
		response.addCookie(nameCookie);
		response.addCookie(urlCookie);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "使用 GET 方法读取表单数据";
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		String docType = "<!DOCTYPE html> \n";
		out.println(
				docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
						+ "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n" + "  <li><b>站点名</b>：" + name + "\n"
						+ "  <li><b>网址</b>：" + request.getParameter("url") + "\n" + "</ul>\n" + "</body></html>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

// 		处理表单数据		
//		response.setContentType("text/html");
//		PrintWriter outPrintWriter = response.getWriter();
//		outPrintWriter.println("<h1>" + message + "</h1>");
//		
//		String account = request.getParameter("account");
//		String psd = request.getParameter("psd");
//		if (account.equals("admin") && psd.equals("123456")) {
//			request.getRequestDispatcher("success.jsp").forward(request, response);
//		} else if (account.equals("admin") && !psd.equals("123456")) {
//			request.setAttribute("psdErrorString", "password is error");
//			request.getRequestDispatcher("test.jsp").forward(request, response);
//		} else if (!account.equals("admin") && psd.equals("123456")) {
//			request.setAttribute("accountErrorString", "account is error");
//			request.getRequestDispatcher("test.jsp").forward(request, response);
//		} else {
//			request.setAttribute("errorString", "login error");
//			request.getRequestDispatcher("test.jsp").forward(request, response);
//		}
	}

}
