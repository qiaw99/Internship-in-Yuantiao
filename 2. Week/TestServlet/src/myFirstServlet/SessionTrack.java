package myFirstServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * http://localhost:8080/TestServlet/SessionTrack
 * @author 87290
 *
 */
@WebServlet("/SessionTrack")
public class SessionTrack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionTrack() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Date createDate = new Date(session.getCreationTime());
		Date lastAccessDate = new Date(session.getLastAccessedTime());

		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String title = "Servlet Session";
		Integer visitCount = Integer.valueOf(0);
		String visitCountKey = new String("visitCount");
		String userIDKey = new String("userID");
		String userID = new String("Runoob");

		if (session.getAttribute(visitCountKey) == null) {
			session.setAttribute(visitCountKey, Integer.valueOf(0));
		}

		if (session.isNew()) {
			title = "Servlet Session 实例 ";
			session.setAttribute(userIDKey, userID);
		} else {
			visitCount = (Integer) session.getAttribute(visitCountKey);
			visitCount = visitCount + 1;
			userID = (String) session.getAttribute(userIDKey);
		}
		session.setAttribute(visitCountKey, visitCount);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String docType = "<!DOCTYPE html>\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n"
				+ "<h2 align=\"center\">Session 信息</h2>\n" + "<table border=\"1\" align=\"center\">\n"
				+ "<tr bgcolor=\"#949494\">\n" + "  <th>Session 信息</th><th>值</th></tr>\n" + "<tr>\n" + "  <td>id</td>\n"
				+ "  <td>" + session.getId() + "</td></tr>\n" + "<tr>\n" + "  <td>创建时间</td>\n" + "  <td>"
				+ dFormat.format(createDate) + "  </td></tr>\n" + "<tr>\n" + "  <td>最后访问时间</td>\n" + "  <td>"
				+ dFormat.format(lastAccessDate) + "  </td></tr>\n" + "<tr>\n" + "  <td>用户 ID</td>\n" + "  <td>" + userID
				+ "  </td></tr>\n" + "<tr>\n" + "  <td>访问统计：</td>\n" + "  <td>" + visitCount + "</td></tr>\n"
				+ "</table>\n" + "</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
