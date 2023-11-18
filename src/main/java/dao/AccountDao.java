package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import beans.Account;
import context.DBContext;

/**
 * contain operations with account table
 * @author LE PHONG LAM
 *
 */
public class AccountDao {
	/**
	 * login with email and password
	 * @param email
	 * @param password
	 * @return system login status
	 * @throws NamingException
	 * @throws SQLException
	 */
	public boolean login(String email, String password) throws NamingException, SQLException {
		Connection conn = new DBContext().getConnection();
		String sql = "select count(*) as count from account where user_mail=? && password=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, password);
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
	
	/**
	 * check existence of email
	 * @param email
	 * @return status existence of email
	 * @throws NamingException
	 * @throws SQLException
	 */
	public boolean exists(String email) throws NamingException, SQLException {
		Connection conn = new DBContext().getConnection();
		String sql = "select count(*) as count from account where user_mail=?";
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
	
	/**
	 * create account
	 * @param account
	 * @throws NamingException
	 * @throws SQLException
	 */
	public void createAccount(Account account) throws NamingException, SQLException {
		Connection conn = new DBContext().getConnection();
		String sql = "insert into account(user_mail, password, account_role, user_name, user_address, user_phone) values(?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, account.getEmail());
		stmt.setString(2, account.getPwd());
		stmt.setInt(3, account.getRole());
		stmt.setString(4, account.getName());
		stmt.setString(5, account.getAddress());
		stmt.setString(6, account.getPhone());
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	/**
	 * update account
	 * @param email
	 * @param name
	 * @param address
	 * @param phone
	 * @return number of record is updated
	 * @throws NamingException
	 * @throws SQLException
	 */
	public int updateAccount(String email, String name, String address, String phone) throws NamingException, SQLException {
		Connection conn = new DBContext().getConnection();
		String sql = "update account set user_name=?, user_address=?, user_phone=? where user_mail=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setString(2, address);
		stmt.setString(3, phone);
		stmt.setString(4, email);
		
		int result = stmt.executeUpdate();
		stmt.close();
		return result;
	}
	
	/**
	 * update password
	 * @param email
	 * @param password
	 * @throws NamingException
	 * @throws SQLException
	 */
	public void updatePassword(String email, String password) throws NamingException, SQLException {
		Connection conn = new DBContext().getConnection();
		String sql = "update account set password=? where user_mail=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, password);
		stmt.setString(2, email);
		
		stmt.executeUpdate();
		stmt.close();
	}
	
	/**
	 * get account by email
	 * @param email
	 * @return Account object
	 * @throws NamingException
	 * @throws SQLException
	 */
	public static Account getAccountByEmail(String email) throws NamingException, SQLException {
		Connection conn = new DBContext().getConnection();
		String sql = "select * from account where user_mail=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery(); 
		String pwd = "";
		int role = 0;
		String name = "";
		String address = "";
		String phone = "";
		if(rs.next()) {
			pwd = rs.getString("password");
			role = rs.getInt("account_role");
			name = rs.getString("user_name");
			address = rs.getString("user_address");
			phone = rs.getString("user_phone");
		}
		
		return new Account(email, pwd, role, name, address, phone);
	}
}
