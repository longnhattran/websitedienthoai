package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Account;
import dao.AccountDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		Account account = new Account();
		Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("user")) {
						String user = cookie.getValue();
						String[] usr_pwd = user.split(":");
						account.setEmail(usr_pwd[0]);
						account.setPwd(usr_pwd[1]);
						break;
					}
					else {
						account.setEmail("");
						account.setPwd("");
					}
				}
			}else {
				account.setEmail("");
				account.setPwd("");
			}
		session.setAttribute("account", account);
		String contextPath = request.getContextPath() + "/jsp/login.jsp";
		response.sendRedirect(contextPath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			request.getSession(true).invalidate();
			AccountDao accountDao = new AccountDao();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String action = request.getParameter("action");
			Account account = AccountDao.getAccountByEmail(email);
			HttpSession session = request.getSession(true);
			session.setAttribute("account", account);
			if(!account.validate()) {
				session.setAttribute("error", "invalid syntax");
				session.setAttribute("isLoggedIn", false);
				String contextPath = request.getContextPath() + "/jsp/login.jsp";
				response.sendRedirect(contextPath);
			}
			else if(accountDao.login(email, password)) {
				session.setAttribute("isLoggedIn", true);
				if(action.equals("checked")) {
					Cookie cookie = new Cookie("user",account.getEmail() + ":" + account.getPwd());
					cookie.setMaxAge(30*24*60*60);
					response.addCookie(cookie);
				}
				response.sendRedirect("ListServlet");
			}else {
				session.setAttribute("error", "Wrong username or password.");
				session.setAttribute("isLoggedIn", false);
				String contextPath = request.getContextPath() + "/jsp/login.jsp";
				response.sendRedirect(contextPath);
			}
		}catch(NullPointerException e) {
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
		catch(Exception e) {
			response.getWriter().println(e);
		}
	}
}
