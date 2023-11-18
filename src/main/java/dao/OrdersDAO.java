package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.NamingException;

import beans.Orders;
import beans.Product;
import context.DBContext;
import java.sql.ResultSet;
/**
 * contain operations with orders table
 * @author LE PHONG LAM
 *
 */
public class OrdersDAO {
	/**
	 * add information order into orders table and order_detail table
	 * @param o
	 * @throws NamingException
	 * @throws SQLException
	 */
	public void insertOrder(Orders o) throws NamingException, SQLException {
		Connection conn = new DBContext().getConnection();
		List<Product> lp = o.getLp();
		String name = o.getUsername();
		int status = o.getStatus();
		String discount = o.getDiscount();
		String address = o.getAddress();
		String sql1 = "insert into orders(user_name, order_status, order_discount_code, order_address) values(?,?,?,?)";
		
		PreparedStatement stmt1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
		
		stmt1.setString(1, name);
		stmt1.setInt(2, status);
		stmt1.setString(3, discount);
		stmt1.setString(4, address);
		
		int effectedRows = stmt1.executeUpdate();
		
		if(effectedRows > 0) {
			String sql2="insert into orders_detail(order_id, product_id, amount_product, price_product) values(?,?,?,?)";
			int order_id = 0;
			PreparedStatement stmt2 = conn.prepareStatement(sql2);
			
			ResultSet generatedKeys = stmt1.getGeneratedKeys();
			if(generatedKeys.next()) {
				order_id = generatedKeys.getInt(1);
			}
			for(Product product : lp) {
				int product_id = product.getId();
				int amount_product = product.getNumber();
				double price_product = product.getPrice();
				
				stmt2.setInt(1, order_id);
				stmt2.setInt(2, product_id);
				stmt2.setInt(3, amount_product);
				stmt2.setDouble(4, price_product);
				
				stmt2.executeUpdate();
			}
			stmt2.close();
		}
		
		stmt1.close();
		conn.close();
	}
}