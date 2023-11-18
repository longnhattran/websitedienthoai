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

import beans.Pagination;
import beans.Product;
import dao.ListProductDAO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int PRODUCTS_PER_PAGE = 6;
	private static final int VISIBLE_PAGES = 5;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
	
		try {
			int currentPage = 1;
			String page = request.getParameter("currentPage");
			String name = request.getParameter("name");
			String action = request.getParameter("action");
			List<Product> ls = new ListProductDAO().search(name);
			int totalPageSearch = (int) Math.ceil((double)ls.size()/PRODUCTS_PER_PAGE);
			Pagination p = new Pagination(PRODUCTS_PER_PAGE, ls);
			if(page != null) {
				currentPage = Integer.parseInt(page);
			}
			int startPage = Math.max(currentPage - VISIBLE_PAGES/2, 1);
			int endPage = Math.min(startPage + VISIBLE_PAGES - 1, totalPageSearch);
			List<Product> lp = p.getProductPerPage(currentPage);
			if(action.equals("search")) {
				session.setAttribute("words", name);
			}else {
				session.setAttribute("words", "");
			}
			session.setAttribute("action", action);
			session.setAttribute("name", name);
			session.setAttribute("currentPageSearch", currentPage);
			session.setAttribute("startPageSearch", startPage);
			session.setAttribute("endPageSearch", endPage);
			session.setAttribute("products_per_page", PRODUCTS_PER_PAGE);
			session.setAttribute("ProductSearch", lp);
			session.setAttribute("totalPageSearch", totalPageSearch);
			response.sendRedirect("jsp/home.jsp?page=search");
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().println(e);
		}
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
