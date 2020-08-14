package myFirstServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PageRedirect")
public class PageRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PageRedirect() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8"); 
		String siteString = new String("http://www.baidu.com");
		
		response.sendRedirect(siteString);
//		response.setHeader("Location", siteString);
//		response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
