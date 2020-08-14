package myFirstServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PageHitCounter")
public class PageHitCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int hitCount;
       
    public PageHitCounter() {
        super();
    }
    
    public void init() {
    	hitCount = 0;
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        hitCount ++;
        PrintWriter outPrintWriter = response.getWriter();
        String title = "×Üµã»÷Á¿";
        String docType = "<!DOCTYPE html> \n";
        outPrintWriter.println(docType +
            "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor=\"#f0f0f0\">\n" +
            "<h1 align=\"center\">" + title + "</h1>\n" +
            "<h2 align=\"center\">" + hitCount + "</h2>\n" +
            "</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
