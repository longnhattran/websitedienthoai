package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDao;
import dao.EmailOfferDAO;

/**
 * Servlet implementation class SaveEmailOfferServlet
 */
@WebServlet("/SaveEmailOfferServlet")
public class SaveEmailOfferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveEmailOfferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		EmailOfferDAO emailOfferDAO = new EmailOfferDAO();
		AccountDao accountDao = new AccountDao();
		try {
			if(!emailOfferDAO.existsEmailOffer(email) || !accountDao.exists(email)) {
				emailOfferDAO.addEmailOffer(email);
			}
			String contextPath = request.getContextPath() + "/jsp/addemailsuccess.jsp";
			response.sendRedirect(contextPath);
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().println(e);
		}
	}

}
