package controller;

import java.io.IOException;
import java.net.URLDecoder;
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
 * Servlet implementation class AddToCardServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("cart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setContentType("text/html;charset=UTF-8");
			try {
				String idd = request.getParameter("id");
				String action = request.getParameter("action");
				HttpSession session = request.getSession(true);
				if(action != null && action.equalsIgnoreCase("add")) {
					
					if(session.getAttribute("cart") == null) {
						session.setAttribute("cart", new Cart());
					}
					int id = Integer.parseInt(idd);
					Product p = new ListProductDAO().getProducts(id);
					Cart c = (Cart) session.getAttribute("cart");
					c.add(new Product(p.getId(), p.getName(), p.getDescription(),
							p.getPrice(), p.getSrc(), p.getType(), p.getBrand(), 1));
					getServletContext().setAttribute("cart", c);
					response.sendRedirect("jsp/cart.jsp");
					
				}else if(action != null && action.equalsIgnoreCase("delete")) {
					Cart c = (Cart) session.getAttribute("cart");
					int id = Integer.parseInt(idd);
					c.remove(id);
					session.setAttribute("cart", c);
					response.sendRedirect("jsp/cart.jsp");
				}
				else if(action != null && action.equalsIgnoreCase("order")) {
					String encodeString = request.getParameter("quantity");
					String decodeString = URLDecoder.decode(encodeString, "UTF-8");
					if(session.getAttribute("cart") == null) {
						session.setAttribute("cart", new Cart());
					}
					Cart c = (Cart) session.getAttribute("cart");
					List<Product> products = c.getItems();
					
					if(decodeString != null) {
						String[] idQuantityCouples = decodeString.split(",");
						for(String idQuantityCouple : idQuantityCouples) {
							String[] idQuantity = idQuantityCouple.split(":");
							int id = Integer.parseInt(idQuantity[0]);
							int quantity = Integer.parseInt(idQuantity[1]);
							for(Product product : products) {
								if(product.getId() == id) {
									product.setNumber(quantity);
									break;
								}
							}
						}
						session.setAttribute("cart", c);
						response.sendRedirect("jsp/checkout.jsp");
					}
				}
				
			} catch (NamingException | SQLException e) {
				// TODO Auto-generated catch block
				response.getWriter().println(e);
			}
		}
	}