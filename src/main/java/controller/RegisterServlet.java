package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Account;
import dao.AccountDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		session.setAttribute("error_register", "");
		String contextPath = request.getContextPath() + "/jsp/register.jsp";
		response.sendRedirect(contextPath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}
		try {
			request.getSession(true).invalidate();
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String repeatPassword = request.getParameter("repeat-password");
			Account account = new Account();
			account.setEmail(email);
			account.setPwd(password);
			account.setName(name);
			account.setAddress(address);
			account.setPhone(phone);
			account.setRole(1);
			HttpSession session = request.getSession(true);
			session.setAttribute("account-register", account);
			AccountDao accountDao = new AccountDao();
			if(!password.equals(repeatPassword)) {
				session.setAttribute("error_register", "Password and repeat password is different.");
				String contextPath = request.getContextPath() + "/jsp/register.jsp";
				response.sendRedirect(contextPath);
			}
			else {
				if(!account.validate()) {
					session.setAttribute("error_register", "Email is invalid syntax");
					String contextPath = request.getContextPath() + "/jsp/register.jsp";
					response.sendRedirect(contextPath);
				}
				else if(accountDao.exists(email)) {
					session.setAttribute("error_register", "Email existed.");
					String contextPath = request.getContextPath() + "/jsp/register.jsp";
					response.sendRedirect(contextPath);
				}
				else{
					accountDao.createAccount(account);
					session.setAttribute("success", "Register success!");
					String contextPath = request.getContextPath() + "/jsp/login.jsp";
					response.sendRedirect(contextPath);
				}
			}
		}catch(NullPointerException e) {
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		catch(Exception e) {
			response.getWriter().println(e);
		}
	}
}