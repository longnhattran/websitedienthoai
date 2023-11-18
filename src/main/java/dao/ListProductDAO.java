package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import beans.Product;
import context.DBContext;

public class ListProductDAO {
	
	private static final int PRODUCTS_PER_PAGE = 6;
	
	public List<Product> search(String productName) throws NamingException, SQLException{
		List<Product> products = new ArrayList<>();
		Connection conn = new DBContext().getConnection();
		String sql = "select product_id as id, product_name as name, product_des as description, product_price as price,"
				+ "product_img_source as source, product_type as type, product_brand as brand from products";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String description = rs.getString("description");
			float price = rs.getFloat("price");
			String source = rs.getString("source");
			String type = rs.getString("type");
			String brand = rs.getString("brand");
			
			if(name.toLowerCase().contains(productName.toLowerCase())) {
				Product product = new Product(id, name, description, price, source, type, brand, 0);
				products.add(product);
			}
		}
		rs.close();
		stmt.close();
		conn.close();
		return products;
	}
	
	public int getTotalPages() throws NamingException, SQLException {
		Connection conn = new DBContext().getConnection();
		String sql = "select count(*) as count from products";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		int totalProducts = 0;
		
		if(rs.next()) {
			totalProducts = rs.getInt("count");
		}
		
		rs.close();
		stmt.close();
		return (int) Math.ceil((double)totalProducts/PRODUCTS_PER_PAGE);
	}
	
	public List<Product> getProductsPerPage(int currentPage) throws NamingException, SQLException{
		List<Product> lp = new ArrayList<>();
		Connection conn = new DBContext().getConnection();
		int offset = (currentPage - 1)*PRODUCTS_PER_PAGE;
		String sql = "select product_id as id, product_name as name, product_des as description, product_price as price,"
				+ "product_img_source as source, product_type as type, product_brand as brand from products limit ? offset ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, PRODUCTS_PER_PAGE);
		stmt.setInt(2, offset);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String description = rs.getString("description");
			float price = rs.getFloat("price");
			String source = rs.getString("source");
			String type = rs.getString("type");
			String brand = rs.getString("brand");
			
			Product product = new Product(id, name, description, price, source, type, brand);
			lp.add(product);
		}
		rs.close();
		stmt.close();
		conn.close();
		return lp;
	}
	
	public Product getProducts(int id) throws NamingException, SQLException {
		Connection conn = new DBContext().getConnection();
		Product product = null;
		String sql = "select product_id as id, product_name as name, product_des as description, product_price as price,"
				+ "product_img_source as source, product_type as type, product_brand as brand from products";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int pid = rs.getInt("id");
			String name = rs.getString("name");
			String description = rs.getString("description");
			float price = rs.getFloat("price");
			String source = rs.getString("source");
			String type = rs.getString("type");
			String brand = rs.getString("brand");
			
			if(pid == id) {
				product = new Product(id, name, description, price, source, type, brand, 0);
				break;
			}
		}
		
		rs.close();
		stmt.close();
		conn.close();
		return product;
	}

	/**
	 * @return the productsPerPage
	 */
	public static int getProductsPerPageConstant() {
		return PRODUCTS_PER_PAGE;
	}
}
