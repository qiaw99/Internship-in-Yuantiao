package myFirstServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * http://localhost:8080/TestServlet/DatabaseAccess
 * @author 87290
 *
 */
@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/world";
	static final String USER = "root";
	static final String PASSWORD = "123456";

	public DatabaseAccess() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection connection = null;
		Statement statement = null;

		response.setContentType("text/html; charset = UTF-8");
		PrintWriter outPrintWriter = response.getWriter();
		String title = "Servlet MYSQL";
		String docType = "<!DOCTYPE html>\n";
		outPrintWriter.println(docType + 
				"<html>\n" + 
				"<head><title>" + 
				title + "</title></head>\n" + 
				"<body bgcolor=\"#f0f0f0\">\n" + 
				"<h1 align=\"center\">" + 
				title + "</h1>\n"
		);
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASSWORD);
			statement = (Statement) connection.createStatement();
			String sqlString = "SELECT id, name, url FROM websites";
			ResultSet rSet = statement.executeQuery(sqlString);
			
			while(rSet.next()) {
				int id = rSet.getInt("id");
				String nameString = rSet.getString("name");
				String urlString = rSet.getString("url");
				
				outPrintWriter.println("ID: " + id);
				outPrintWriter.println("Name: " + nameString);
				outPrintWriter.println("URL: " + urlString);
				outPrintWriter.println("<br/>");
			}
			outPrintWriter.println("</body></html>");
			rSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(statement != null) {
					statement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
