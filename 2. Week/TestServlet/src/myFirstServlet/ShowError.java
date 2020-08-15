package myFirstServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http://localhost:8080/TestServlet/ShowError
 * @author 87290
 *
 */
@WebServlet("/ShowError")
public class ShowError extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowError() {
        super();
    }

	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(407, "Like always do! Forbidden!!!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
