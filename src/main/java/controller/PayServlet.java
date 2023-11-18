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
import beans.Orders;
import beans.Product;
import dao.DiscountDAO;
import dao.OrdersDAO;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html,charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}
		
		try {
			HttpSession session = request.getSession(true);
			OrdersDAO orderDao = new OrdersDAO();
			DiscountDAO discountDao = new DiscountDAO();
			if(session.getAttribute("cart") == null) {
				session.setAttribute("cart", new Cart());
			}
			Cart c = (Cart) session.getAttribute("cart");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String discount = request.getParameter("discount");
			List<Product> lp = c.getItems();
			Orders o = new Orders(name, address, phone, lp, 2, discount, null);
			orderDao.insertOrder(o);
			double total = c.getTotalAmount();
			double amountDiscount = discountDao.getDiscountAmount(discount);
			double grandTotal = total - amountDiscount;
			session.setAttribute("total", total);
			session.setAttribute("amountDiscount", amountDiscount);
			session.setAttribute("grandTotal", grandTotal);
			if(discount != null) {
				discountDao.updateDiscountCoupon(discount);
			}
			response.sendRedirect("jsp/success.jsp");
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().println(e);
		}
		
	}

}
