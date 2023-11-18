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
 * Servlet implementation class SaveProfileServlet
 */
@WebServlet("/SaveProfileServlet")
public class SaveProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveProfileServlet() {
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
		String contextPath = request.getContextPath() + "/jsp/profile.jsp";
		response.sendRedirect(contextPath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		AccountDao accountDao = new AccountDao();
		try {
			if(accountDao.updateAccount(email, name, address, phone) > 0) {
				session.setAttribute("success", "Update success!");
			}
			else {
				session.setAttribute("error", "Update fail!");
			}
			String contextPath = request.getContextPath() + "/jsp/profile.jsp";
			response.sendRedirect(contextPath);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().println(e);
		}
	}

}
