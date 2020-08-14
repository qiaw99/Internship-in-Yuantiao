package myFirstServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SendEmail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.setProperty("java.net.preferIPv4Stack", "true");
		String to = "to@xxx.com";

		String from = "from@xxx.com";

		String host = "localhost";

		Properties properties = System.getProperties();

		properties.setProperty("mai.smtp.host", host);
		properties.setProperty("mail.user", from);
		properties.setProperty("mail.password", "psw");

		Session session = Session.getDefaultInstance(properties);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			// ����һ��Ĭ�ϵ� MimeMessage ����
			MimeMessage message = new MimeMessage(session);

			// ���� From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// ���� To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// ���� Subject: header field
			message.setSubject("This is the Subject Line!");

			// ��������ʵ����Ϣ
			message.setText("Hello World from Qianli");

			// ������Ϣ
			Transport.send(message);
			String title = "���͵����ʼ�";
			String res = "�ɹ�������Ϣ...";
			String docType = "<!DOCTYPE html> \n";
			out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
					+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n"
					+ "<p align=\"center\">" + res + "</p>\n" + "</body></html>");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
