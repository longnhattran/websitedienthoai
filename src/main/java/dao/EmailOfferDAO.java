package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import context.DBContext;

/**
 * contain operations with email_offer table
 * @author LE PHONG LAM
 *
 */
public class EmailOfferDAO {
	/**
	 * add email offer into email_offer table
	 * @param email
	 * @return number of record is added into email_offer table
	 * @throws NamingException
	 * @throws SQLException
	 */
	public int addEmailOffer(String email) throws NamingException, SQLException {
		Connection conn = new DBContext().getConnection();
		String sql="insert into email_offer(email) values(?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		int result = stmt.executeUpdate();
		stmt.close();
		return result;
	}
	
	/**
	 * check email offer exists or not
	 * @param email
	 * @return status of existence
	 * @throws NamingException
	 * @throws SQLException
	 */
	public boolean existsEmailOffer(String email) throws NamingException, SQLException {
		Connection conn = new DBContext().getConnection();
		String sql="select count(*) as count from email_offer where email=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		int count = 0;
		if(rs.next()) {
			count = rs.getInt("count");
		}
		rs.close();
		stmt.close();
		conn.close();
		if(count == 0) {
			return false;
		}
		else {
			return true;
		}
	}
}
