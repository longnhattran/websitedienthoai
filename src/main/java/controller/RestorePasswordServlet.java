package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;

/**
 * Servlet implementation class RestorePasswordServlet
 */
@WebServlet("/RestorePasswordServlet")
public class RestorePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestorePasswordServlet() {
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
		String contextPath = request.getContextPath() + "/restorepassword.jsp";
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
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		if(!email.equals("") && !password.equals("")) {
			AccountDao accountDao = new AccountDao();
			session.setAttribute("success", "Restore password Success!");
			try {
				String contextPath = request.getContextPath() + "/jsp/login.jsp";
				accountDao.updatePassword(email, password);
				response.sendRedirect(contextPath);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				response.getWriter().println(e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				response.getWriter().println(e);
			}
		}
		else {
			String contextPath = request.getContextPath() + "/jsp/restorepassword.jsp";
			session.setAttribute("error", "Please fill in new password.");
			response.sendRedirect(contextPath);
		}
		
	}
}
