package myFirstServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://localhost:8080/TestServlet/DisplayHeader
 */
@WebServlet("/DisplayHeader")
public class DisplayHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayHeader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8"); 
		
			PrintWriter outPrintWriter = response.getWriter();
			String title = "HTTP Header Display";
			String docType = "<!DOCTYPE html> \n";
	        outPrintWriter.println(docType +
	        "<html>\n" +
	        "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n"+
	        "<body bgcolor=\"#f0f0f0\">\n" +
	        "<h1 align=\"center\">" + title + "</h1>\n" +
	        "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
	        "<tr bgcolor=\"#949494\">\n" +
	        "<th>Header Ãû³Æ</th><th>Header Öµ</th>\n"+
	        "</tr>\n");
	        
	        Enumeration<String> headerNamesEnumeration = request.getHeaderNames();
	        
	        while(headerNamesEnumeration.hasMoreElements()) {
	        	String paramNameString = headerNamesEnumeration.nextElement();
	        	outPrintWriter.print("<tr><td>" + paramNameString + "</td>\n");
	        	String paramValueString = request.getHeader(paramNameString);
	        	outPrintWriter.println("<td>" + paramValueString + "</td></tr>\n");
	        }
	        outPrintWriter.println("</table>\n</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
