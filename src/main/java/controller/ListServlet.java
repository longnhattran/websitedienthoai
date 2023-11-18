package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cart;
import beans.Product;
import dao.ListProductDAO;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int VISIBLE_PAGES = 5;
	private int totalPageHome;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			totalPageHome = new ListProductDAO().getTotalPages();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF8");
		HttpSession session = request.getSession(true);
		Boolean loggedIn = (Boolean) session.getAttribute("isLoggedIn");
		String page = request.getParameter("page");
		Cart c = (Cart) session.getAttribute("cart");
		if(c != null) {
			getServletContext().setAttribute("cart", c);
		}
		else {
			getServletContext().setAttribute("cart", new Cart());
		}
		if(loggedIn == null) {
			session.setAttribute("isLoggedIn", false);
		}else {
			session.setAttribute("isLoggedIn",(boolean) loggedIn);
		}
		if(page == null || page.equals("home")) {
			try {
				int currentPage = 1;
				String numberPage = request.getParameter("currentPage");
				if(numberPage != null) {
					currentPage = Integer.parseInt(numberPage);
				}
				int startPage = Math.max(currentPage - VISIBLE_PAGES/2, 1);
				int endPage = Math.min(startPage + VISIBLE_PAGES - 1, totalPageHome);
				List<Product> lp = new ListProductDAO().getProductsPerPage(currentPage);
				session.setAttribute("words", "");
				session.setAttribute("currentPageHome", currentPage);
				session.setAttribute("startPageHome", startPage);
				session.setAttribute("endPageHome", endPage);
				session.setAttribute("products_per_page", ListProductDAO.getProductsPerPageConstant());
				session.setAttribute("ProductHome", lp);
				session.setAttribute("totalPageHome", totalPageHome);
				response.sendRedirect("jsp/home.jsp?page=home");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				response.getWriter().println(e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				response.getWriter().println(e);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}