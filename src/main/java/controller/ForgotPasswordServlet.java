package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		session.setAttribute("error", "");
		String contextPath = request.getContextPath() + "/jsp/forgotpassword.jsp";
		response.sendRedirect(contextPath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession(true);
		
		AccountDao accountDao = new AccountDao();
		
		try {
			if(!accountDao.exists(email)) {
				session.setAttribute("error", "Email does not exists");
				response.sendRedirect("jsp/forgotpassword.jsp");
			}
			else {
				String senderEmail = "lamlpFX15058@funix.edu.vn";
				String senderPassword = System.getenv("EMAIL_SENDER_PASSWORD");
				Properties properties = new Properties();
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.starttls.enable", "true");
				properties.put("mail.smtp.host", "smtp.gmail.com");
				properties.put("mail.smtp.port", "587");
				
				Session mailSession = Session.getInstance(properties, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(senderEmail, senderPassword);
					}
				});
				
				MimeMessage message = new MimeMessage(mailSession);
				try {
					message.setFrom(new InternetAddress(senderEmail));
					message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(email));
					message.setSubject("Create new password");
					String createPasswordLink = "http://35.176.141.75:81" + request.getContextPath() + "/jsp/restorepassword.jsp?email=" + email;
					String emailContent = "Please access path below to restore password:\n" 
							+ createPasswordLink + "\n\nBest regards!";
					message.setText(emailContent);
					Transport.send(message);
					response.sendRedirect("jsp/mailsuccess.jsp");
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					response.getWriter().println(e);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					response.getWriter().println(e);
				}
			}
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().println(e);
		}
	}

}
