package myFirstServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://localhost:8080/TestServlet/Refresh
 * @author 87290
 *
 */
@WebServlet("/Refresh")
public class Refresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Refresh() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setIntHeader("Refresh", 5);
		response.setContentType("text/html; charset=UTF-8");

		Calendar calendar = Calendar.getInstance();
		Date taskTimeDate = calendar.getTime();
		
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String nowTimeString = dFormat.format(taskTimeDate);
		PrintWriter outPrintWriter = response.getWriter();
		
		String title = "�Զ�ˢ�� Header";
        String docType = "<!DOCTYPE html>\n";
        outPrintWriter.println(docType +
		"<html>\n" +
		"<head><title>" + title + "</title></head>\n"+
		"<body bgcolor=\"#f0f0f0\">\n" +
		"<h1 align=\"center\">" + title + "</h1>\n" +
		"<p>��ǰʱ���ǣ�" + nowTimeString + "</p>\n");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
