package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;


import context.DBContext;

/**
 * contain operations with discount_coupon table
 * @author LE PHONG LAM
 *
 */
public class DiscountDAO {
	/**
	 * get Discount amount
	 * @param code
	 * @return amount of Discount
	 * @throws SQLException
	 * @throws NamingException
	 */
	public double getDiscountAmount(String code) throws SQLException, NamingException {
		Connection conn = new DBContext().getConnection();
		String sql = "select * from discount_coupon where code=? and used=0";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, code);
		ResultSet rs = stmt.executeQuery();
		double amount = 0.0;
		if(rs.next()) {
			amount = rs.getDouble("amount");
		}
		rs.close();
		stmt.close();
		return amount;
	}
	
	public void updateDiscountCoupon(String code) throws NamingException, SQLException {
		Connection conn = new DBContext().getConnection();
		String sql="update discount_coupon set used=true where code=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, code);
		stmt.executeUpdate();
		stmt.close();
	}
}
